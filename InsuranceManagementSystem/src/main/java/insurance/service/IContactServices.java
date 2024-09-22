package insurance.service;

import java.util.List;
import java.util.Optional;

import insurance.model.Contact;

public interface IContactServices {

	
	Integer saveContact(Contact a);
	void updateContact(Contact a);
	
	void deleteContact(Integer a);
	
	Optional<Contact> getOneContact(Integer id);
	List<Contact> getAllContacts();
	
	boolean isContactExist(Integer id);
	
}
