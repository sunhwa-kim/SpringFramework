package kr.co.sh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"kr.co.sh.beans", " kr.co.sh.advisor"})
@EnableAspectJAutoProxy
public class BeanConfigClass {

	
}
