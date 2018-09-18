package co.grandcircus.FinalProject.Facebook;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.grandcircus.FinalProject.Entities.User;


@Component
public class FacebookService {

	@Value("${facebook.client_secret}")
	private String clientSecret;

	/**
	 * Make an HTTP request to Github's server. Get an access token using the provided code.
	 */
	public String getFacebookAccessToken(String code) {
		// We'll talk more about rest template in the coming days.
		Map<String, String> params = new HashMap<>();
		params.put("code", code);
		params.put("client_id", "1509075672527896");  
		params.put("client_secret", clientSecret); 
		params.put("redirect_uri", "http://localhost:8080/oauth-facebook-callback");
		RestTemplate rest = new RestTemplate();
		@SuppressWarnings("unchecked")
		Map<String, String> response = rest.postForObject("https://graph.facebook.com/v3.1/oauth/access_token"
				+ "", params,
				Map.class);  //??
		return response.get("access_token");
	}

	/**
	 * Make an HTTP request to Facebook's server. Use the access token to get the user details.
	 */
	
	public User getUserFromFacebookApi(String accessToken) {
		System.out.println(accessToken);
		RestTemplate rest = new RestTemplate();
		String uri = "https://graph.facebook.com/v3.1/me?access_token=EAAVcfw9mdBgBAM9yBBf76uviHUNmw2VWQbi8NVdduyxRrZAkvPSjeVJpPSWL3a6VCZAnbf2KU5nbJgzGX51vfrIsrtvrRq6ONjcUkrhZAXYJOuhNZAWbCAqeyYNKtO6g6fZA7RaWcAs9NXi7MLs5CWYbLYWBxBFMZD";
		User response = rest.getForObject(uri, User.class);
		System.out.println("response: " + response);
		User user = new User();
		response.copyToUser(user);
		System.out.println("user: " + user);
		return user;
	}

	
}
