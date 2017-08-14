package zbdy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import zbdy.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private User user = new User("zbdy", "1111");
	
	@ModelAttribute
	//@ModelAttribute will be executed firstly if on method
	public void init(){
		System.out.println("---init()----");
	}
	
	//@ModelAttribute
	//will put user into model
	public User returnUser(){
		return this.user;
	}
	
	@RequestMapping //use as relevant path if specify @RequestMapping in class level
	public String printHello(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!!!");
		System.out.println(model.get("message"));
		return "user";
	}
	

	//@RequestMapping
	//the returned user object will be added to Model, 
	//and the default view would be the request path, i.e. user.jsp
    public User getUser() {
        return this.user;
    }
	
	@RequestMapping("get/{username}") //use URL path
	public String getUserById(@PathVariable String username, Model model) {
		user.setUsername(username);
	    model.addAttribute("user", user);
	    return "user";
	}
	
	//@RequestMapping(value="form", method = {RequestMethod.POST, RequestMethod.GET})
    //public String setupForm(@RequestParam(name="username", required=false) String username, ModelMap model) {
	//@RequestParam can be omitted when the name is the same
	public String setupForm(String username, ModelMap model) {
    	user.setUsername(username);
        model.addAttribute("user", user);
        return "user";
    }

	@RequestMapping(value="form", method = {RequestMethod.POST, RequestMethod.GET})
	//can specify the form name with @ModelAttribute("formName") if the default form name is not "user"
	//will auto bind the input parameters to an object
	//public String setupForm(@ModelAttribute User user) {
	public String setupForm(User user) {
		return "user";
    }
	
	@RequestMapping("redirect")
	public String redirect(){
		return "redirect:/"; // to ROOT path
	}
}
