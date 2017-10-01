package guru.di.pofiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("punjabi")
public class HelloWorldPunjabi implements HelloWorld {

	@Override
	public void sayHello() {
		System.out.println("G Aya Nu!!!");
	}

}
