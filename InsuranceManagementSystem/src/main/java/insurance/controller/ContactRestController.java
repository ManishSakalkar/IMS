package insurance.controller;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import insurance.model.Contact;
import insurance.service.IContactServices;
import insurance.util.ContactUtil;



/*@Api(description="sample data")*/
@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactRestController {
	
	private Logger log = LoggerFactory.getLogger(ContactRestController.class);

	@Autowired
	private IContactServices service;
	
	@Autowired
	private ContactUtil util;
	
	/**
	 * 1. Read JSON(Contact) and convert to Object Format
	 *    Store data in Database. Return one Message.
	 */
	/*@ApiOperation("creating employee data")*/
	@PostMapping
	public ResponseEntity<String> saveContact(
			@RequestBody Contact contacts)
	{
		log.info("Entered into method with Contactus data to save");

		ResponseEntity<String> resp = null;
		try {

			log.info("About to call save Operation");

			Integer id = service.saveContact(contacts);
			log.debug("Contact saved with id "+id);

			String body = "Contact '"+id+"' created";

			resp =  new ResponseEntity<String>(
					body,HttpStatus.CREATED); //201

			log.info("Sucess response constructed");
		} catch (Exception e) {
			log.error("Unable to save Contactus : problem is :"+e.getMessage());
			resp =  new ResponseEntity<String>(
					"Unable to Create Contactus", 
					HttpStatus.INTERNAL_SERVER_ERROR); //500
			e.printStackTrace();
		}

		log.info("About to Exist save method with Response");
		return resp;
	}
	
	/**
	 * 2. Fetch all rows from database using Service
	 *    Sort data using name, return as JSON, 
	 *    else String message no data found.
	 *    
	 */
	
	@GetMapping
	public ResponseEntity<?> getAllContact() {
		log.info("Entered into method to fetch Contactus data");
		ResponseEntity<?> resp = null ;
		try {

			log.info("About to call fetch contactus service");
			List<Contact> list = service.getAllContacts();
			if(list!=null && !list.isEmpty()) {
				log.info("Data is not empty=>"+list.size());
				list.sort((s1,s2)->s1.getName().compareTo(s2.getName())); 
				/* JDK 1.8s
				list = list.stream()
	 					.sorted((s1,s2)->s1.getName().compareTo(s2.getName()))
						.collect(Collectors.toList());
				 */
				resp = new ResponseEntity<List<Contact>>(list, HttpStatus.OK);
			} else {
				log.info("No Contactus exist: size "+list.size());

				//Res = new ResponseEntity<>(HttpStatus.NO_CONTENT);
				resp = new ResponseEntity<String>(
						"No Contact Found",
						HttpStatus.OK);
			}
		} catch (Exception e) {
			log.error("Unable to fetch contactus : problem is :"+e.getMessage());

			resp =  new ResponseEntity<String>(
					"Unable to Fetch Contactus", 
					HttpStatus.INTERNAL_SERVER_ERROR); //500
			e.printStackTrace();
		}
		log.info("About to Exist fetch all method with Response");
		return resp;
	}
	
	/***
	 * 3. Get one Contact object based on ID (PathVariable). 
	 *   If Object exist then return Employee object 
	 *   else provide message(String).
	 */
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneContact(
			@PathVariable Integer id
			) 
	{
		log.info("Entered into Get one Contact method");
		ResponseEntity<?> resp = null;
		try {
			log.info("About to make service call to fetch one record");
			Optional<Contact> opt =  service.getOneContact(id);
			if(opt.isPresent()) {
				log.info("Contact exist=>"+id);
				resp = new ResponseEntity<Contact>(opt.get(), HttpStatus.OK);
				//resp = ResponseEntity.ok(opt.get());
			} else {
				log.warn("Given Contact id not exist=>"+id);
				resp = new ResponseEntity<String>(
						"Contact '"+id+"' not exist", 
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Unable to process request fetch " + e.getMessage());
			resp = new ResponseEntity<String>(
					"Unable to process contactus fetch", 
					HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return resp;
	}
	
	/**
	 * 4. delete one row based on id (PathVariable)
	 *    First check given row exist or not?
	 *    if exist then call delete operation
	 *    else return  NO RECORD MESSAGE
	 *    
	 */
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeContact(
			@PathVariable Integer id
			)
	{

		log.info("Entered into delete method");
		ResponseEntity<String> resp = null;

		try {

			log.info("About to make service call for data check");
			boolean exist = service.isContactExist(id);
			if(exist) {
				service.deleteContact(id);
				log.info("Contact exist with given id and deleted=>"+id);
				resp = new ResponseEntity<String>(
						"Contact '"+id+"' deleted",
						HttpStatus.OK);
			} else {
				log.warn("Given Contact id not exist =>"+id);
				resp = new ResponseEntity<String>(
						"Contact '"+id+"' not exist",
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Unable to perform Delete Operation =>" + e.getMessage());
			resp = new ResponseEntity<String>(
					"Unable to delete", 
					HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return resp;
	}
	
	/**
	 * 5. Update
	 */
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateContact(
			@PathVariable Integer id,
			@RequestBody Contact contacts
			)
	{
		log.info("Entered into Update method");

		ResponseEntity<String> resp =null;

		try {
			log.info("About to check given id exist or not db");
			Optional<Contact> opt =  service.getOneContact(id);
			if(opt.isPresent()) {
				log.info("Contactus present in database");
				Contact actual = opt.get();
				util.mapToActualObject(actual,contacts);
				service.updateContact(actual);
				resp = new ResponseEntity<String>(
						"Contact'"+id+"' Updated", 
						//HttpStatus.RESET_CONTENT
						HttpStatus.OK
						);
				log.info("Contact update done successfully");
			} else {
				log.info("Contact not exist=>"+id);
				resp = new ResponseEntity<String>(
						"Contact '"+id+"' not found", 
						//HttpStatus.RESET_CONTENT
						HttpStatus.BAD_REQUEST
						);
			}

		} catch (Exception e) {
			log.error("Unable to perform Update Operation=>" + e.getMessage() );
			resp = new ResponseEntity<String>(
					"Unable to process Update",
					HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return resp;
	}



}
