package ch2wiringbeans.auto;

import org.springframework.stereotype.Component;

@Component
public class VitalSigns implements CompactDisc {

	private String title = "Yeh Sham";
	private String artist = "Junaid Jamshed";
	
	@Override
	public void play() {
		System.out.println("Playing " + title + " by" + artist);
	}

}
