package business;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.HashMap;

import dataaccess.DataAccessFacade;
import dataaccess.User;

public class LoginException extends Exception implements Serializable {

	public LoginException() {
		super();
	}

	public LoginException(String msg) {
		super(msg);
	}

	public LoginException(Throwable t) {
		super(t);
	}

	public boolean authorizedUser(String userName, String password) {

		boolean find = false;

		DataAccessFacade dataAccess = new DataAccessFacade();
		HashMap<String, User> members;
		members = dataAccess.readUserMap();

		for (String name : members.keySet()) {
			User value = members.get(name);
			System.out.println(value.getId());
			System.out.println(value.getPassword());
			if (userName.equals(value.getId()) && password.equals(value.getPassword())) {
				find = true;
			}
		}

		return find;
	}

	private static final long serialVersionUID = 8978723266036027364L;

}
