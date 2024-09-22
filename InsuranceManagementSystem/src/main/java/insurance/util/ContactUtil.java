package insurance.util;

import org.springframework.stereotype.Component;


import insurance.model.Contact;

@Component
public class ContactUtil {
	
	public void mapToActualObject(Contact actual, Contact contact) {
		
		
		if(contact.getName()!=null)
			actual.setName(contact.getName());
		actual.setEmail(contact.getEmail());
		actual.setPhoneNumber(contact.getPhoneNumber());
		if(contact.getMessage()!=null)
			actual.setMessage(contact.getMessage());
		actual.setEmail(contact.getEmail());
	}
}
