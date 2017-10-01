package guru.di.pofiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

	private HelloWorld helloWorld;

	@Autowired
	public void setHelloWorld(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}

	public void sayGreetings() {
		helloWorld.sayHello();
	}
}
