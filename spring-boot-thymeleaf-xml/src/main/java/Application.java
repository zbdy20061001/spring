import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import zbdy.model.User;

@SpringBootApplication(scanBasePackages="zbdy")
public class Application {
	
	
	@Bean
	SpringTemplateEngine springTemplateEngine(ApplicationContext ctx) {
		
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setApplicationContext(ctx);
		resolver.setPrefix("classpath:/templates/");
		resolver.setSuffix(".xml");
		resolver.setTemplateMode(TemplateMode.XML);
		resolver.setCharacterEncoding("UTF-8");
		resolver.setCacheable(true);
		
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setEnableSpringELCompiler(true);
		engine.setTemplateResolver(resolver);
		
		return engine;
	}
	
//	@Bean
	TemplateEngine defaultTemplateEngine() {
		ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
		TemplateEngine engine = new TemplateEngine();
		engine.setTemplateResolver(resolver);
		
		return engine;
		
	}

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
		TemplateEngine engine = new TemplateEngine();
		engine.setTemplateResolver(resolver);
		
		Context ctx = new Context();
		ctx.setVariable("user", new User("zbdy", "2222"));
		System.out.println(engine.process("user.xml", ctx));
    }

}