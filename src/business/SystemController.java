package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;
import librarysystem.LibrarySystem;

public class SystemController implements ControllerInterface {
	public static Auth currentAuth = null;

	public void login(String id, String password) throws LoginException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if (!map.containsKey(id)) {
			throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = map.get(id).getPassword();
		if (!passwordFound.equals(password)) {
			throw new LoginException("Password incorrect");
		}
		currentAuth = map.get(id).getAuthorization();
		
		LibrarySystem.hideAllWindows();
		LibrarySystem.INSTANCE.setVisible(true);
	}

	public void addNewMember(String memberId, String firstName, String lastName, String phone, String street,
			String city, String state, String zip) throws LoginException {

		if (memberId.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || phone.isEmpty() || street.isEmpty()
				|| city.isEmpty() || state.isEmpty() || zip.isEmpty()) {
			
			throw new LoginException("Please Fill all fields");
		}
		
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if (!map.containsKey(memberId)) {
			throw new LoginException("ID " + memberId + " Already Exist");
		}
		
		Address address = new Address(street, city, state, zip);
		LibraryMember libraryMember = new LibraryMember(memberId, firstName, lastName, phone, address);
		
		da.saveNewMember(libraryMember);
		
		LibrarySystem.hideAllWindows();
		LibrarySystem.INSTANCE.setVisible(true);
	}

	@Override
	public List<String> allMemberIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readMemberMap().keySet());
		return retval;
	}

	@Override
	public List<String> allBookIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readBooksMap().keySet());
		return retval;
	}

}
