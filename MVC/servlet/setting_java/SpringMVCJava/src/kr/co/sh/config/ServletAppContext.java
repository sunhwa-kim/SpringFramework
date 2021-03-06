package kr.co.sh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Spring MVC 프로젝트 관련 설정 클래스
@Configuration
// Controller 어노테이션 세팅된 클래스를 Controller로 등록
@EnableWebMvc
// 스캔할 패키지 지정
@ComponentScan("kr.co.sh.controller")
public class ServletAppContext implements WebMvcConfigurer{

	// Controller 메서드가 반환하는 jsp 이름 압뒤 경로, 확장자 문자열 설정
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/",".jsp");
	}
	
	// 정적 파일 경로 매핑
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
}
