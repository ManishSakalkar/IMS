package insurance.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import insurance.model.Contact;
import insurance.repo.ContactRepository;
import insurance.service.IContactServices;


@Service
public class ContactServiceImpl implements IContactServices {

	
	@Autowired
	private ContactRepository repo;
	
	@Override 
	public Integer saveContact(Contact a) {
		a= repo.save(a);
		return a.getId();		
	}
	
	@Override
	public void updateContact(Contact a) {
		repo.save(a);
	}
	
	@Override
	public void deleteContact(Integer id) {
		repo.deleteById(id);
	}
	
	@Override
	public Optional<Contact> getOneContact(Integer id) {
		return repo.findById(id);
	}
	
	@Override 
	public List<Contact> getAllContacts() {
		return repo.findAll();
	}
	
	@Override 
	public boolean isContactExist(Integer id) {
		return repo.existsById(id);
	}
	

}
