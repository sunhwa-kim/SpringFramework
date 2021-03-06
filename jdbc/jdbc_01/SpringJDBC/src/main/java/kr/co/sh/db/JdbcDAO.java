package kr.co.sh.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.co.sh.beans.JdbcBean;

@Component
public class JdbcDAO {

	// JDBC 관리 객체 주입
	@Autowired
	private JdbcTemplate db;
	
	// Mapper 주입
	@Autowired
	private MapperClass mapper;
	
	public void insert_data(JdbcBean bean) {
		String sql = "insert into jdbc_table (int_data, str_data) values (?,?)";
		db.update(sql, bean.getInt_data(), bean.getStr_data());  // preparestatement
	}
	
	// 
	public List<JdbcBean> select_data(){
		// mapper는 한줄씩, 여러 row는 list로 반환
		String sql = "select int_data, str_data from jdbc_table";
		List<JdbcBean> list = db.query(sql, mapper);
		return list;
	}
	
	public void update_data(JdbcBean bean) {
		String sql = "update jdbc_table set str_data = ? where int_data = ?";
		db.update(sql, bean.getStr_data(), bean.getInt_data());  // 순서대로 1:1 대응
	}
	
	public void delete_data(int int_data) {
		String sql = "delete from jdbc_table where int_data=?";
		db.update(sql, int_data);
	}
}
