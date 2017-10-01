package guru.di.pofiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("english")
public class HelloWorldEnglish implements HelloWorld {

	@Override
	public void sayHello() {
		System.out.println("Hello World!!!");
	}

}
