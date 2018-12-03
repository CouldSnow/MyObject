package com.zy.test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.zy.jdbc.DBUtils;


public class JDBCTest {
	
	@Test
	public void jdbctest() throws Exception {
//		Statement stm = DBUtils.getStatement();
		
//		String sql = "select * from shop.dbo.data_assettype_t where shopcode='0533001'";
//		
//		ResultSet rs = DBUtils.queryByStament(sql);
//		System.out.println(rs.next());
		BigDecimal total = new BigDecimal("0");
		total=total.add(new BigDecimal("5.00000"));
		System.out.println(total);
	}
}
