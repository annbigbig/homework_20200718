package com.kashu.website.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.kashu.website.entity.User;

public class UserRepositoryJdbcImpl implements UserRepository {

    private DataSource dataSource;

    public UserRepositoryJdbcImpl() {
    	Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
	        dataSource = (DataSource) envContext.lookup("jdbc/DB_SPRING");
		} catch (NamingException e) {
			e.printStackTrace();
		}
    }
    
	public void save(User user) {
		// no time for this function , maybe finish it later ...
		
	}

	public User login(String account, String password) {
		User user = null;
		try {
			Connection conn = dataSource.getConnection(); 
			
			String sql = "SELECT id_text, name, account, password FROM TB_YOAN_USER WHERE account=? AND password=?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, account);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			
			/*
			 * don't wrote code like this , it could cause u under SQL Injection attack
			String sql = "SELECT id_text, name, account, password FROM TB_YOAN_USER WHERE account = '" + account + "' and password = '" + password + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			*/
			
			while(rs.next()) {
				user = new User();
				user.setId(rs.getString("id_text"));
				user.setName(rs.getString("name"));
				user.setAccount(rs.getString("account"));
				user.setPassword(rs.getString("password"));
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public User getById(String id) {
		User user = null;
		try {
			Connection conn = dataSource.getConnection();
		    
			String sql = "SELECT id_text, name, account, password FROM TB_YOAN_USER WHERE id_text=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			
			/*
			 * don't wrote code like this , it could cause u under SQL Injection attack
			String sql = "SELECT id_text, name, account, password FROM TB_YOAN_USER WHERE id_text = '" + id + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			*/
			
			while(rs.next()) {
				user = new User();
				user.setId(rs.getString("id_text"));
				user.setName(rs.getString("name"));
				user.setAccount(rs.getString("account"));
				user.setPassword(rs.getString("password"));
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getByAccount(String account) {
		User user = null;
		try {
			Connection conn = dataSource.getConnection(); 
		    
			String sql = "SELECT id_text, name, account, password FROM TB_YOAN_USER WHERE account=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, account);
			ResultSet rs = stmt.executeQuery();
			
			/* don't write code like this , it could cause u under SQL Injection attack
			String sql = "SELECT id_text, name, account, password FROM TB_YOAN_USER WHERE account = '" + account + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			*/
			
			while(rs.next()) {
				user = new User();
				user.setId(rs.getString("id_text"));
				user.setName(rs.getString("name"));
				user.setAccount(rs.getString("account"));
				user.setPassword(rs.getString("password"));
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
