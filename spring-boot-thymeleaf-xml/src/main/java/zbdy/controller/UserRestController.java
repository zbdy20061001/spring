package zbdy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import zbdy.model.User;

@RestController
@RequestMapping("/")
public class UserRestController {

	@Autowired
	@Qualifier("springTemplateEngine")
	TemplateEngine engine;

	private User user = new User("zbdy", "2222");

	@GetMapping("user")
	public User getUser() {
		System.out.println("------------restful----------");

		Context ctx = new Context();
		ctx.setVariable("user", user);
		System.out.println(engine.process("user.xml", ctx));

		return this.user;
	}

}
