package co.grandcircus.FinalProject;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.FinalProject.APIClass.WordResult;
import co.grandcircus.FinalProject.Dao.FearDao;
import co.grandcircus.FinalProject.Dao.MessageDao;
import co.grandcircus.FinalProject.Dao.QuoteDao;
import co.grandcircus.FinalProject.Dao.UserDao;
import co.grandcircus.FinalProject.Entities.Fear;
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
	
	
	@RequestMapping("/")
	private ModelAndView showHome(){
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	@RequestMapping("/login")
	private ModelAndView checkLoginInfo(@RequestParam("username")String username,
			@RequestParam("password") String password, 
			HttpSession session,
			RedirectAttributes redir){
		//find the matching user.
		User user = userDao.findbyUsername(username);
		
		if(user == null || !password.equals(user.getPassword())) {
			redir.addFlashAttribute("message", "Incorrect username or password");
			return new ModelAndView("redirect:/index");
		} else {
		//Add first user to session
		session.setAttribute("user1", user);
		
		User partner = userDao.findUserById(user.getPartnerId());
		session.setAttribute("partner", partner);
		
		Fear userFear = fearDao.findByShort(user.getFearCurrent());
		session.setAttribute("userFear", userFear);
		
		Fear partnerFear = fearDao.findByShort(partner.getFearCurrent());
		session.setAttribute("partnerFear", partnerFear);
		
		return new ModelAndView("redirect:/details");
		
	}
	}
	
	@RequestMapping("/create-account")
	private ModelAndView createAccount(){
		ModelAndView mav = new ModelAndView("createAccount");
		return mav;
	}
	
	@RequestMapping("/create-new-user")
	private ModelAndView createNewUser(@RequestParam("username") String username,
										@RequestParam("password") String password,
										@RequestParam("firstName") String firstName,
										@RequestParam("lastName") String lastName,
										@RequestParam("email") String email,
										@RequestParam("address") String address,
										@RequestParam("city") String city,
										@RequestParam("state") String state,
										@RequestParam("zip") String zip,
										@RequestParam("fear") String fear,
										HttpSession session){
		
		User user = new User(null, username, password, firstName,lastName,email,address,city,state,zip,fear, 1,null,null,null,0);
		userDao.create(user);
		session.setAttribute("user1", user);
	/*	
	 * 
	 * This is where partner assigning is going to go
	 * 
	 * 
		User partner = userDao.findUserById(user.getPartnerId());
		session.setAttribute("partner", partner);
		
		Fear userFear = fearDao.findByShort(user.getFearCurrent());
		session.setAttribute("userFear", userFear);
		
		Fear partnerFear = fearDao.findByShort(partner.getFearCurrent());
		session.setAttribute("partnerFear", partnerFear);
	*/
		return new ModelAndView("redirect:/details");
	}
	
	@RequestMapping("/details")
	private ModelAndView showDetails(HttpSession session) {
		ModelAndView mav = new ModelAndView("details");
		
		// Create a rest template - This is for the UserFear
		RestTemplate restTemplate = new RestTemplate();
		
		// Create a rest template - This is for the partnerFear
		RestTemplate restTemplate2 = new RestTemplate();

		// Set up headers.- This is for the UserFear
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("app_id", "bab49820");
		headers.add("app_key", "52d3c38897896527415c368afe8d270e");
		
		// Set up headers.- This is for the PartnerFear
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Accept", "application/json");
		headers2.add("app_id", "bab49820");
		headers2.add("app_key", "52d3c38897896527415c368afe8d270e");

		
		//setup fear - This is for the UserFear
		Fear fear = (Fear) session.getAttribute("userFear");
		
		//setup fear2 - This is for the partnerFear
		Fear fear2 = (Fear) session.getAttribute("partnerFear");
		
		// Set url- This is for the UserFear
		String url = "https://od-api.oxforddictionaries.com:443/api/v1/entries/en/"+ fear.getLongFear() +"/regions=us";
		
		// Set url2- This is for the partnerFear
		String url2 = "https://od-api.oxforddictionaries.com:443/api/v1/entries/en/"+ fear2.getLongFear() +"/regions=us";

		// Make the Request.- This is for the UserFear
		ResponseEntity<WordResult> response = restTemplate.exchange(url,
				HttpMethod.GET, new HttpEntity<>(headers),
				WordResult.class);
		
		// Make the Request.- This is for the PartnerFear
		ResponseEntity<WordResult> response2 = restTemplate2.exchange(url2,
						HttpMethod.GET, new HttpEntity<>(headers2),
						WordResult.class);

		// Extract body from response.- This is for the UserFear
		WordResult result = response.getBody();
		
		// Extract body from response.- This is for the partnerFear
				WordResult result2 = response2.getBody();
		
		//add the fear to the jsp- This is for the UserFear
		mav.addObject("word", result.getResults().get(0).getLexicalEntries().get(0).getEntries().get(0).getSenses().get(0).getDefinitions().get(0).getDefinition());
		
		
		//add the fear to the jsp- This is for the partnerFear
		mav.addObject("word2", result2.getResults().get(0).getLexicalEntries().get(0).getEntries().get(0).getSenses().get(0).getDefinitions().get(0).getDefinition());
		
		return mav;

	}
	
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session, RedirectAttributes redir) {
		// invalidate clears the current user session and starts a new one.
		session.invalidate();
		
		// A flash message will only show on the very next page. Then it will go away.
		// It is useful with redirects since you can't add attributes to the mav.
		redir.addFlashAttribute("message", "Logged out.");
		return new ModelAndView("redirect:/");
	}
	
	

}
