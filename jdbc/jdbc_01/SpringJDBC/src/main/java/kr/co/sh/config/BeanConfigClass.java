package kr.co.sh.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = {"kr.co.sh.beans","kr.co.sh.db"})
public class BeanConfigClass {

	// DataSource (db 접속 정보 가진 객체 - DBCP 이용)
	@Bean
	public BasicDataSource source() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/practice?serverTimezone=UTC");
		source.setUsername("root");
		source.setPassword("shroot");
		return source;
	}
	
	
	// db 접속해서 쿼리 전달하는 빈 등록
	// 외부 라이브러리 클래스 bean 등록시  @Bean 이용 / 내가 만든 클래스는 @Component
	@Bean
	public JdbcTemplate db(BasicDataSource source) {
		JdbcTemplate db = new JdbcTemplate(source);
		return db;
	}
}
