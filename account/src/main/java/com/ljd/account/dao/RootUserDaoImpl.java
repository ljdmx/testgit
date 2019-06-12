package com.ljd.account.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ljd.account.entity.RootUser;
@Repository("rootUserDao")
public   class RootUserDaoImpl implements RootUserDao {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	public void add(RootUser ru) {
		// TODO Auto-generated method stub
		String sql="insert into root_user(name,password) values(?,?)";
		Object obj[]=new Object[]
			 	{ru.getName(),ru.getPassword()};
			 		jdbcTemplate.update(sql,obj);
		
	}
	public List<RootUser> selectAll() {
		String sql="select * from root_user";
		RowMapper<RootUser> rowMapper=new BeanPropertyRowMapper<RootUser>(RootUser.class);
		List<RootUser> list=jdbcTemplate.query(sql,rowMapper);
		return list;
	}

	public RootUser select(String name, String password) {
		String sql="select * from root_user where name=? and password=?";
		Object[] obj= {name,password};
		RowMapper<RootUser> rowMapper=new BeanPropertyRowMapper<RootUser>(RootUser.class);
		List<RootUser> list=jdbcTemplate.query(sql,obj,rowMapper);
		if(!list.isEmpty()) {
			RootUser ru=list.get(0);
			return ru;
		}
		
		return null;
	}
	public void delete(int id) {
		String sql="delete from root_user where id = ?";
 		jdbcTemplate.update(sql,id);
		
	}
	
}
