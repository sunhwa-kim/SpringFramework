package kr.co.sh.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import kr.co.sh.mapper.MapperInterface;

@Configuration
@ComponentScan(basePackages = "kr.co.sh.beans")
public class BeanConfigClass {

	// dbcp - datasource 등록 : dbcp 이용한 DB 접속 정보
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/practice?serverTimezone=UTC");
		source.setUsername("root");
		source.setPassword("shroot");
		return source;
	}
	
	// SqlSessionFactory : jdbc 처리 객체 (JdbcTemplate 대신)
	@Bean
	public SqlSessionFactory factory(BasicDataSource source) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(source);
		SqlSessionFactory factory = factoryBean.getObject();
		return factory;
	}
	
	// 실제 쿼리문 처리
	// Mapper - 메서드명과 mapper interface 만 다르게 해서 여러개 사용할 수 있다.
	@Bean
	public MapperFactoryBean<MapperInterface> testMapper(SqlSessionFactory factory){
		MapperFactoryBean<MapperInterface> factoryBean = new MapperFactoryBean<MapperInterface>(MapperInterface.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
}
