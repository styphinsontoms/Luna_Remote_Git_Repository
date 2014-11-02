package com.testcompany.primechat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ChatUsers implements Serializable {

	private List<User> users;


	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public boolean login(String firstName) {

		if (users == null)
			users = new ArrayList<User>();
		synchronized (users) {
			return users.add(new User(firstName));
		}
	}

	public void logout(String user) {
		synchronized (users) {
			users.remove(user);
		}
	}

	@PostConstruct
	public void initUsers() {

		this.login("Winnie");
		login("Styphy");
		login("Styphinson");

	}

}
