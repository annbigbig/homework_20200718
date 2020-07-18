package com.kashu.website.repository;

import java.util.HashMap;
import com.kashu.website.entity.User;

public class UserRepositoryDummyImpl implements UserRepository {
	/*
	 * accounts and passwords in clear text:
	 *   rooot  :   roootpass
	 *   johnny :   johnnypass
	 *   julia  :   juliapass
	 */
	
	HashMap<String,User> users = new HashMap<String,User>();
	
	public UserRepositoryDummyImpl() {
		User rooot = new User("A18C582D-C7DA-11EA-8F7E-D92940C8286F","Rooot","rooot","b2bf6b8d31d1bff9d3fb6ca45244f32c");
		User johnny = new User("A6B26A18-C7DA-11EA-8F7E-D92940C8286F","Johnny","johnny","f2735e411f697ce721c5024720968f6a");
		User julia = new User("AD533994-C7DA-11EA-8F7E-D92940C8286F","Julia","julia","116f77a3fda354d9df1c3bb2a7586d54");
		users.put("rooot",rooot);
		users.put("johnny",johnny);
		users.put("julia",julia);
	}

	public void save(User user) {
		users.put(user.getAccount(),user);
	}

	public User login(String account, String password) {
		User user = null;
		if (account.equals("rooot") && password.equals("b2bf6b8d31d1bff9d3fb6ca45244f32c")) {
			user = users.get("rooot");
		}else if(account.equals("johnny") && password.equals("f2735e411f697ce721c5024720968f6a")) {
			user = users.get("johnny");
		}else if(account.equals("julia") && password.equals("116f77a3fda354d9df1c3bb2a7586d54")) {
			user = users.get("julia");
		}
		return user;
	}

	public User getById(String id) {
		User user = null;
		switch(id) {
			case "A18C582D-C7DA-11EA-8F7E-D92940C8286F":
			   user = users.get("rooot");
			   break;
			case "A6B26A18-C7DA-11EA-8F7E-D92940C8286F":
	           user = users.get("johnny");
			   break;
			case "AD533994-C7DA-11EA-8F7E-D92940C8286F":
	           user = users.get("julia");
			   break;
		}
		return user;
	}

	public User getByAccount(String account) {
		User user = null;
		switch(account) {
		    case "rooot":
		       user = users.get("rooot"); 	
			   break;
		    case "johnny":
	           user = users.get("johnny");
			   break;
			case "julia":
	           user = users.get("julia");
			   break;
		}
		return user;
	}

}
