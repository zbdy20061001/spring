package zbdy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import zbdy.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private User user = new User();
	
	@RequestMapping //use as relevant path if specify @RequestMapping in class level
	public String printHello(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!!!");
		System.out.println(model.get("message"));
		return "user";
	}
	
	@RequestMapping("get/{username}") //use URL path
	public String getUserById(@PathVariable String username, Model model) {
		user.setUsername(username);
	    model.addAttribute("user", user);
	    return "user";
	}
	
	@RequestMapping(value="form", method = {RequestMethod.POST, RequestMethod.GET})
    public String setupForm(@RequestParam(name="username", required=false) String username, ModelMap model) {
    	user.setUsername(username);
        model.addAttribute("user", user);
        return "user";
    }

}
