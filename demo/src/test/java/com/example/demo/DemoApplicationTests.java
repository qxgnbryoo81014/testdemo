package com.example.demo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.entity.ProLinkProPrice;
import com.google.gson.Gson;

@SpringBootTest
class DemoApplicationTests {
	
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Test
	void test() {
		ProLinkProPrice test = new ProLinkProPrice();
		test.setLink_pro_code("123");
		test.setPrice_dt(new Date("1991/01/01"));
		
		Date currentDate = new Date();
        Timestamp currentTimestamp = new Timestamp(currentDate.getTime());
		test.setCreate_dt(currentTimestamp);
		test.setModify_dt(currentTimestamp);
		
		
		String sql = "INSERT INTO PRO_LINK_PRO_PRICE values (?,?,?,?) ";
		jdbcTemplate.update(sql, new Object[] {"789", new Date("1991/01/01"), currentTimestamp, currentTimestamp});
		System.out.println("finish");
		
		List<Map<String, Object>> dataList = jdbcTemplate.queryForList("select * from PRO_LINK_PRO_PRICE", new Object[] {});
		System.out.println(new Gson().toJson(dataList));
		
		System.out.println("test1");
		List<ProLinkProPrice> list = jdbcTemplate.query("select * from PRO_LINK_PRO_PRICE", new BeanPropertyRowMapper<ProLinkProPrice>(ProLinkProPrice.class), new Object[] {});
		System.out.println(new Gson().toJson(list));
		System.out.println("test2");
	}

}
