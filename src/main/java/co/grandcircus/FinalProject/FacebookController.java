package co.grandcircus.FinalProject;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.FinalProject.Dao.FearDao;
import co.grandcircus.FinalProject.Dao.UserDao;
import co.grandcircus.FinalProject.Entities.Fear;
import co.grandcircus.FinalProject.Entities.User;
import co.grandcircus.FinalProject.Facebook.FacebookService;

@Controller
public class FacebookController {

	@Autowired
	UserDao userDao;
	@Autowired
	FacebookService facebookService;
	@Autowired
	FearDao fearDao;

	/*
	 * @PostMapping("/login") // get the username and password from the form when
	 * it's submitted. public ModelAndView
	 * submitLoginForm(@RequestParam("facebookId") Long fancyId, HttpSession
	 * session, RedirectAttributes redir) { // Find the matching user. User user =
	 * userDao.findbyFacebookId(fancyId); if (user == null) { // If the user or
	 * password don't match, display an error message. ModelAndView mav = new
	 * ModelAndView("login");
	 */

	// long form used to setup a new user
	@RequestMapping("/createnew")
	private ModelAndView createNewAccount() {
		ModelAndView mav = new ModelAndView("createNewAccount");
		return mav;
	}

	/*
	 * @RequestMapping("/logout") public ModelAndView logout(HttpSession session,
	 * RedirectAttributes redir) { // invalidate clears the current user session and
	 * starts a new one. session.invalidate();
	 * 
	 * // A flash message will only show on the very next page. Then it will go
	 * away. // It is useful with redirects since you can't add attributes to the
	 * mav. redir.addFlashAttribute("message", "Logged out."); return new
	 * ModelAndView("redirect:/"); mav.addObject("message",
	 * "Incorrect username or password."); return mav; }
	 */

	// This is the second step in OAuth. After the user approves the login on the
	// facebook site, it redirects back
	// to our site with a temporary code.
	@RequestMapping("/oauth-facebook-callback")
	public ModelAndView handleFacebookCallback(@RequestParam("code") String code, HttpSession session) {
		// First we must exchange that code for an access token.
		String accessToken = facebookService.getFacebookAccessToken(code);
		// Then we can use that access token to get information about the user and other
		// things.
		long facebookId = facebookService.getUserFromFacebookApi(accessToken).getFacebookId();

		// Check to see if the user is already in our database.
		User user = userDao.findbyFacebookId(facebookId);
		// (user.getFacebookId());
		System.out.println(user);
		if (user == null) {
			// A new registration
		ModelAndView mav = new ModelAndView("createNewAccount");
			mav.addObject("facebookId", facebookId);
			return mav;

			
		} else {
			// An existing user login
			
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

		/*
		 * // In some apps, you need the access token later, so throw that on the
		 * session, too. session.setAttribute("facebookAccessToken", accessTokesn);
		 */
	}

}
