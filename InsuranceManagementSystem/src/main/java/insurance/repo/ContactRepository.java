package insurance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import insurance.model.Contact;


public interface ContactRepository  extends JpaRepository<Contact, Integer>
{

}
