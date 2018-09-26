package co.grandcircus.FinalProject;

//comment added on 9/26 for testing - Darby
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.jdbc.Messages;

import co.grandcircus.FinalProject.APIClass.WordResult;
import co.grandcircus.FinalProject.Dao.FearDao;
import co.grandcircus.FinalProject.Dao.MessageDao;
import co.grandcircus.FinalProject.Dao.QuoteDao;
import co.grandcircus.FinalProject.Dao.UserDao;
import co.grandcircus.FinalProject.Entities.Fear;
import co.grandcircus.FinalProject.Entities.Message;
import co.grandcircus.FinalProject.Entities.User;

@Controller
public class FearController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private FearDao fearDao;

	@Autowired
	private MessageDao messageDao;

	@Autowired
	private QuoteDao quoteDao;
	
	@Value("${oxford.apikey}")
	String oxfordApiKey;

	//maps to the login home page we refer to it as index
	@RequestMapping("/")
	private ModelAndView showHome() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	//This verifies username and password, redirect if no match. Submitting the login form is mapped here.
	@RequestMapping("/login")
	private ModelAndView checkLoginInfo(@RequestParam("username") String username,
			@RequestParam("password") String password, HttpSession session, RedirectAttributes redir) {
		// find the matching user.
		User user = userDao.findbyUsername(username);
		//this is where it checks if user exists by checking username and password
		if(user == null  || !password.equals(user.getPassword())) {
			 ModelAndView mav = new ModelAndView("index");
				mav.addObject("specificmessage", "Incorrect username or password. Please try again.");
				return mav; 
		} 
		//Here we add the user to the session!!!!
		session.setAttribute("user1", user);
		//here we check if that user has a partner		
		if(user.getPartnerId() == null) {
			//if the user doesn't have a partner we only add the userfear to sessions
				Fear userFear = fearDao.findByShort(user.getFearCurrent());
				session.setAttribute("userFear", userFear);
				//directs to the details mapping
				return new ModelAndView("redirect:/details");
		} else {
			//if the user does have a partner than we add the partner information and fear to the session
			//and the user information. the fear is added to sessions using the current user in sessions and their FearCurrent.
				Fear userFear = fearDao.findByShort(user.getFearCurrent());
				session.setAttribute("userFear", userFear);
				
				User partner = userDao.findUserById(user.getPartnerId());
				session.setAttribute("partner", partner);

				Fear partnerFear = fearDao.findByShort(partner.getFearCurrent());
				session.setAttribute("partnerFear", partnerFear);
						
				//directs to the details mapping
				return new ModelAndView("redirect:/details");
		}
	}

	//long form used to setup a new user
	@RequestMapping("/create-account")
	private ModelAndView createAccount() {
		ModelAndView mav = new ModelAndView("createAccount");
		return mav;
	}	
	
	//receives the information from create-account, and builds user and stores in database
	@RequestMapping("/create-new-user")
	private ModelAndView createNewUser(@RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email,
			@RequestParam("address") String address, @RequestParam("city") String city,
			@RequestParam("state") String state, @RequestParam("zip") String zip, @RequestParam("fear") String fear,
			@RequestParam("facebookId") Long facebookId,
			HttpSession session) {

		if((userDao.findbyUsername(username) == null) && (userDao.findbyEmail(email) == null)) {

		//this is the list of all users in the database we access and create this list using the DAO.
		List<User> userList = userDao.listAll();

		//this is the for loop that checks the users and whether they meet our criteria to be matched
		int i;
		for (i = 0; i < userList.size(); i++) {
			if ((city.equals(userList.get(i).getCity())) && (!fear.equals(userList.get(i).getFearCurrent()))
					&& (userList.get(i).getPartnerId() == null)) {
				Long h = userList.get(i).getId();
				
				
				//User gets created with a partner
				if ((session.getAttribute("user") != null)) {
					User user = (User) session.getAttribute("user");
				user.setId(null);
				user.setUsername(username);
				user.setPassword(password);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmail(email);
				user.setAddress(address);
				user.setCity(city);
				user.setState(state);
				user.setZip(zip);
				user.setFearCurrent(fear);
				user.setRank(1);
				user.setPartnerId(h);
				user.setFearProgress(0);
				user.setFacebookId(facebookId);
				//user is added to database
				userDao.create(user);
				
				
				//setting the user, partner, userfear, and partenr fear to sessions
				session.setAttribute("user1", user);
				
					//partner set
				User partner = userDao.findUserById(h);
				partner.setPartnerId(user.getId());
				session.setAttribute("partner", partner);
				
				//userfear is set here
				Fear userFear = fearDao.findByShort(fear);
				session.setAttribute("userFear", userFear);

				//partnerfear is set here
				Fear partnerFear = fearDao.findByShort(userDao.findUserById(h).getFearCurrent());
				session.setAttribute("partnerFear", partnerFear);
				return new ModelAndView("redirect:/details");
				
				
				
				
				
				} else {
					
					User user = new User(null, username, password, firstName, lastName, email, address, city, state, zip,
						fear, 1, h, null, null, 0, null);
				
				
				
				
				//user is added to database
				userDao.create(user);
				

				
				//setting the user, partner, userfear, and partner fear to sessions

				session.setAttribute("user1", user);
				
					//partner set
				User partner = userDao.findUserById(h);
				partner.setPartnerId(user.getId());
				session.setAttribute("partner", partner);
				
				//userfear is set here
				Fear userFear = fearDao.findByShort(fear);
				session.setAttribute("userFear", userFear);

				//partnerfear is set here
				Fear partnerFear = fearDao.findByShort(userDao.findUserById(h).getFearCurrent());
				session.setAttribute("partnerFear", partnerFear);
				return new ModelAndView("redirect:/details");
				}
			}
		}
		//No partner path, collects necessary information if we don't have a matching partner. The Details page will direct
		//the single user to a detailsSolo jsp. that will contain only the necessary information for a single user
		User user = new User(null, username, password, firstName,lastName,email,address,city,state,zip,fear,1,null,null,null,0, facebookId);
		userDao.create(user);
		session.setAttribute("user1", user);
		Fear userFear = fearDao.findByShort(fear);
		session.setAttribute("userFear", userFear);
		return new ModelAndView("redirect:/details");	
	} else {
		ModelAndView mav = new ModelAndView("createAccount");
		mav.addObject("message", "That username or email already exists, please try again.");
		return mav;	
	}
	}
	
	@RequestMapping("/details")
	private ModelAndView showDetails(HttpSession session) {
		//with a partner MAV
		ModelAndView mav = new ModelAndView("details");
		//without a partner MAV
		ModelAndView mav2 = new ModelAndView("detailsSolo");
		
		//the next steps are the API
		// Create a rest template - This is for the UserFear - API
		RestTemplate restTemplate = new RestTemplate();


		// Set up headers.- This is for the UserFear - API
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("app_id", "bab49820");
		headers.add("app_key", oxfordApiKey);

		//setup fear - This is for the UserFear - API
		Fear fear = (Fear) session.getAttribute("userFear");
		
		// Set url- This is for the UserFear - API
		String url = "https://od-api.oxforddictionaries.com:443/api/v1/entries/en/"+ fear.getLongFear() +"/regions=us";
		System.out.println(url);
		
		// Make the Request.- This is for the UserFear - API
		ResponseEntity<WordResult> response = restTemplate.exchange(url,
		HttpMethod.GET, new HttpEntity<>(headers),
		WordResult.class);
		
		// Extract body from response.- This is for the UserFear - API
		WordResult result = response.getBody();
		
		//add the fear to the jsp- This is for the UserFear - API
		mav.addObject("word", result.getResults().get(0).getLexicalEntries().get(0).getEntries().get(0).getSenses().get(0).getDefinitions().get(0).getDefinition());
		mav2.addObject("word", result.getResults().get(0).getLexicalEntries().get(0).getEntries().get(0).getSenses().get(0).getDefinitions().get(0).getDefinition());
	
		//this checks to see if the user has a partner id assigned, if not then they will see the solo details page
		User test = (User) session.getAttribute("user1");
		if(test.getPartnerId() == null) {
			return mav2;
			
		//this path shows and populates the information needed if the user does have a partner ID assigned	
		} else {
		
		// Create a rest template - This is for the partnerFear
		RestTemplate restTemplate2 = new RestTemplate();
		
		// Set up headers.- This is for the PartnerFear
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Accept", "application/json");
		headers2.add("app_id", "bab49820");
		headers2.add("app_key", oxfordApiKey);
		
		//setup fear2 - This is for the partnerFear
		Fear fear2 = (Fear) session.getAttribute("partnerFear");
		
		// Set url2- This is for the partnerFear
		String url2 = "https://od-api.oxforddictionaries.com:443/api/v1/entries/en/"+ fear2.getLongFear() +"/regions=us";

		// Make the Request.- This is for the PartnerFear
		ResponseEntity<WordResult> response2 = restTemplate2.exchange(url2, HttpMethod.GET, new HttpEntity<>(headers2),
				WordResult.class);

		// Extract body from response.- This is for the partnerFear
		WordResult result2 = response2.getBody();
		
		//add the fear to the jsp- This is for the partnerFear
		mav.addObject("word2", result2.getResults().get(0).getLexicalEntries().get(0).getEntries().get(0).getSenses().get(0).getDefinitions().get(0).getDefinition());
	
		//create a list of messages ordered by date (all messages)
		List<Message> userMessages = messageDao.findMessageByDate();
		
		//for loop iterates through list of all messages
		//if statement determines if the sender of the message is the current user or their partner. If so, it skips to the code at the bottom and keeps the message in our list.
		int i;
		for(i=0; i<userMessages.size(); i++) {
		if((userMessages.get(i).getSenderId() == test.getId()) || (userMessages.get(i).getSenderId() == test.getPartnerId())) {
		
		//if the user or their partner did NOT send the message, then we remove it from the list and decrement i (otherwise it skips over a message).
		}else {
			userMessages.remove(userMessages.get(i));
			i--;
		}
		}
		//add edited list of messages to the model and view and to the session
		mav.addObject("userMessages", userMessages);
		session.setAttribute("userMessages", userMessages);
		return mav;
		}
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session, RedirectAttributes redir) {
		// invalidate clears the current user session and starts a new one.
		session.invalidate();

		// A flash message will only show on the very next page. Then it will go away.
		redir.addFlashAttribute("specificmessage", "Logged out.");
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/steps")
		public ModelAndView progress(HttpSession session) {
			//find partner
			User assignedPartner = (User) session.getAttribute("partner");
		if (assignedPartner.getFearProgress() <3) {
			assignedPartner.setFearProgress((assignedPartner.getFearProgress())+1);
			userDao.update(assignedPartner);
		} else if (assignedPartner.getFearProgress() ==3){
			assignedPartner.setFearProgress((assignedPartner.getFearProgress())+1);
			assignedPartner.setRank((assignedPartner.getRank())+1);
			userDao.update(assignedPartner);
		}
			return new ModelAndView("details");
	}
	
	@RequestMapping("/messages")
	//request the message that the user entered in the text box
	public ModelAndView addMessageToDb(HttpSession session, @RequestParam("messagebox") String userMessage) {
		
		//get user and partner from session
		User test = (User) session.getAttribute("user1");
		User partner = (User) session.getAttribute("partner");
		
		//create a new message object and add it to the database
		Message newMessage = new Message (null, userMessage, test.getId(), test.getPartnerId(), null, test.getFirstName(), partner.getFirstName());
			//message is added to database and session
			messageDao.create(newMessage);
			
		//create new model and view and redirect to details controller
		ModelAndView mav = new ModelAndView("redirect:/details");
		return mav;
		}		

	
	@RequestMapping("/newFearForm")
	public ModelAndView showNewFearForm(HttpSession session) {
		ModelAndView mav = new ModelAndView("newFearForm");
		User user = (User) session.getAttribute("user1");
		mav.addObject(user);
		return mav;
	}

	@RequestMapping("/newFear")
	public ModelAndView createNewFear(@RequestParam("fear") String fear,
			HttpSession session) {
		//find partner
		User user = (User) session.getAttribute("user1");
		User assignedPartner = (User) session.getAttribute("partner");
		
		if(user.getFearCurrent().equals(fear)) {
			ModelAndView mav = new ModelAndView("newFearForm");
			mav.addObject("message", "Please select a new fear. The fear you selected is the one you just got over.");
			return mav;
		}
		
		user.setFearCurrent(fear);
		user.setFearProgress(0);

	
		//this is the list of all users in the database we access and create this list using the DAO.
		List<User> userList = userDao.listAll();

		//this is the for loop that checks the users and whether they meet our criteria to be matched
		int i;
		for (i = 0; i < userList.size(); i++) {
			if ((userList.get(i).getCity().equals(user.getCity())) && (!userList.get(i).getFearCurrent().equals(fear))
					&& (userList.get(i).getPartnerId() == null) && (userList.get(i).getId() != user.getId())) {
				Long h = userList.get(i).getId();
				user.setPartnerId(h);
				assignedPartner.setPartnerId(null);
				//user is added to database
				userDao.update(user);
				userDao.update(assignedPartner);
				//setting the user, partner, userfear, and partenr fear to sessions
				session.setAttribute("user1", user);
				
					//partner set
				User partner = userDao.findUserById(h);
				partner.setPartnerId(user.getId());
				session.setAttribute("partner", partner);
				userDao.update(partner);
				
				//userfear is set here
				Fear userFear = fearDao.findByShort(fear);
				session.setAttribute("userFear", userFear);

				//partnerfear is set here
				Fear partnerFear = fearDao.findByShort(userDao.findUserById(h).getFearCurrent());
				session.setAttribute("partnerFear", partnerFear);
				return new ModelAndView("redirect:/details");
			}
		}
		//No partner path, collects necessary information if we don't have a matching partner. The Details page will direct
		//the single user to a detailsSolo jsp. that will contain only the necessary information for a single user
		user.setPartnerId(null);
		user.setFearProgress(0);
		userDao.update(user);
		session.setAttribute("user1", user);
		Fear userFear = fearDao.findByShort(fear);
		session.setAttribute("userFear", userFear);
		assignedPartner.setPartnerId(null);
		userDao.update(assignedPartner);
		
		
		return new ModelAndView("redirect:/details");	
}
}
	

	


	
