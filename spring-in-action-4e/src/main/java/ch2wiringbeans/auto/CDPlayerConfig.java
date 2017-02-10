package ch2wiringbeans.auto;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses={CompactDisc.class})
public class CDPlayerConfig {

}
