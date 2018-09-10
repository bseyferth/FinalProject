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
	private ModelAndView createNewUser(){
		ModelAndView mav = new ModelAndView("redirect:/details");
		return mav;
	}
	
	@RequestMapping("/details")
	private ModelAndView showDetails() {
		ModelAndView mav = new ModelAndView("details");
		
		// Create a rest template
		RestTemplate restTemplate = new RestTemplate();

		// Set up headers.
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("app_id", "bab49820");
		headers.add("app_key", "52d3c38897896527415c368afe8d270e");

		// Set url
		String url = "https://od-api.oxforddictionaries.com:443/api/v1/entries/en/arachnophobia/regions=us";

		// Make the Request.
		ResponseEntity<WordResult> response = restTemplate.exchange(url,
				HttpMethod.GET, new HttpEntity<>(headers),
				WordResult.class);

		// Extract body from response.
		WordResult result = response.getBody();
		
		mav.addObject("word", result.getResults().get(0).getLexicalEntries().get(0).getEntries().get(0).getSenses().get(0).getDefinitions().get(0).getDefinition());
		System.out.println(result.getResults().get(0).getLexicalEntries().get(0).getEntries().get(0).getSenses().get(0).getDefinitions().get(0).getDefinition());
		return mav;

	}
	
	

}
