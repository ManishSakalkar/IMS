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

import insurance.model.Manish;
import insurance.service.IManishServices;
import insurance.util.ManishUtil;

@RestController
@RequestMapping("/api/manishs")
@CrossOrigin(origins = "http://localhost:4200")
public class ManishRestController {

	private Logger log = LoggerFactory.getLogger(ManishRestController.class);

	@Autowired
	private IManishServices service;
	@Autowired
	private ManishUtil util;

	/**
	 * 1. Read JSON(Manish) and convert to Object Format
	 *    Store data in Database. Return one Message.
	 */
	@PostMapping
	public ResponseEntity<String> saveManish(
			@RequestBody Manish manishs)
	{
		log.info("Entered into method with Manish data to save");

		ResponseEntity<String> resp = null;
		try {

			log.info("About to call save Operation");

			Integer id = service.saveManish(manishs);
			log.debug("Manish saved with id "+id);

			String body = "Manish '"+id+"' created";

			resp =  new ResponseEntity<String>(
					body,HttpStatus.CREATED); //201

			log.info("Sucess response constructed");
		} catch (Exception e) {
			log.error("Unable to save manish : problem is :"+e.getMessage());
			resp =  new ResponseEntity<String>(
					"Unable to Create Manish", 
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
	public ResponseEntity<?> getAllManishs() {
		log.info("Entered into method to fetch Manishs data");
		ResponseEntity<?> resp = null ;
		try {

			log.info("About to call fetch manish service");
			List<Manish> list = service.getAllManishs();
			if(list!=null && !list.isEmpty()) {
				log.info("Data is not empty=>"+list.size());
				list.sort((s1,s2)->s1.getPolicyname().compareTo(s2.getPolicyname()));
				/* JDK 1.8
				list = list.stream()
						.sorted((s1,s2)->s1.getName().compareTo(s2.getName()))
						.collect(Collectors.toList());
				 */
				resp = new ResponseEntity<List<Manish>>(list, HttpStatus.OK);
			} else {
				log.info("No Manish exist: size "+list.size());

				//resp = new ResponseEntity<>(HttpStatus.NO_CONTENT);
				resp = new ResponseEntity<String>(
						"No Manishs Found",
						HttpStatus.OK);
			}
		} catch (Exception e) {
			log.error("Unable to fetch Manishs : problem is :"+e.getMessage());

			resp =  new ResponseEntity<String>(
					"Unable to Fetch Manishs", 
					HttpStatus.INTERNAL_SERVER_ERROR); //500
			e.printStackTrace();
		}
		log.info("About to Exist fetch all method with Response");
		return resp;
	}


	/***
	 * 3. Get one customer object based on ID (PathVariable). 
	 *   If Object exist then return Manish object 
	 *   else provide message(String).
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneManish(
			@PathVariable Integer id
			) 
	{
		log.info("Entered into Get one Manish method");
		ResponseEntity<?> resp = null;
		try {
			log.info("About to make service call to fetch one record");
			Optional<Manish> opt =  service.getOneManish(id);
			if(opt.isPresent()) {
				log.info("Manish exist=>"+id);
				resp = new ResponseEntity<Manish>(opt.get(), HttpStatus.OK);
				//resp = ResponseEntity.ok(opt.get());
			} else {
				log.warn("Given Manish id not exist=>"+id);
				resp = new ResponseEntity<String>(
						"Manish '"+id+"' not exist", 
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Unable to process request fetch " + e.getMessage());
			resp = new ResponseEntity<String>(
					"Unable to process manish fetch", 
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
	public ResponseEntity<String> removeManish(
			@PathVariable Integer id
			)
	{

		log.info("Entered into delete method");
		ResponseEntity<String> resp = null;

		try {

			log.info("About to make service call for data check");
			boolean exist = service.isManishExist(id);
			if(exist) {
				service.deleteManish(id);
				log.info("Manish exist with given id and deleted=>"+id);
				resp = new ResponseEntity<String>(
						"Manish '"+id+"' deleted",
						HttpStatus.OK);
			} else {
				log.warn("Given Manish id not exist =>"+id);
				resp = new ResponseEntity<String>(
						"Manish '"+id+"' not exist",
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
	public ResponseEntity<String> updateManish(
			@PathVariable Integer id,
			@RequestBody Manish manishs
			)
	{
		log.info("Entered into Update method");

		ResponseEntity<String> resp =null;

		try {
			log.info("About to check given id exist or not db");
			Optional<Manish> opt =  service.getOneManish(id);
			if(opt.isPresent()) {
				log.info("Manish present in database");
				Manish actual = opt.get();
				util.mapToActualObject(actual,manishs);
				service.updateManish(actual);
				resp = new ResponseEntity<String>(
						"Manish '"+id+"' Updated", 
						//HttpStatus.RESET_CONTENT
						HttpStatus.OK
						);
				log.info("Manish update done successfully");
			} else {
				log.info("Manish not exist=>"+id);
				resp = new ResponseEntity<String>(
						"Manish '"+id+"' not found", 
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

