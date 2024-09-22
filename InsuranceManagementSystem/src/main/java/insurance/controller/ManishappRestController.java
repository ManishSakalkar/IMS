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

import insurance.model.Manishapp;
import insurance.service.IManishappServices;
import insurance.util.ManishappUtil;

@RestController
@RequestMapping("/api/manishapps")
@CrossOrigin(origins = "http://localhost:4200")
public class ManishappRestController {

	private Logger log = LoggerFactory.getLogger(ManishappRestController.class);

	@Autowired
	private IManishappServices service;
	@Autowired
	private ManishappUtil util;

	/**
	 * 1. Read JSON(Manishapp) and convert to Object Format
	 *    Store data in Database. Return one Message.
	 */
	@PostMapping
	public ResponseEntity<String> saveManishapp(
			@RequestBody Manishapp manishapps)
	{
		log.info("Entered into method with Manishapp data to save");

		ResponseEntity<String> resp = null;
		try {

			log.info("About to call save Operation");

			Integer id = service.saveManishapp(manishapps);
			log.debug("Manishapp saved with id "+id);

			String body = "Policy '"+id+"' applied";

			resp =  new ResponseEntity<String>(
					body,HttpStatus.CREATED); //201

			log.info("Sucess response constructed");
		} catch (Exception e) {
			log.error("Unable to save manishapp : problem is :"+e.getMessage());
			resp =  new ResponseEntity<String>(
					"Unable to Create Manishapp", 
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
	public ResponseEntity<?> getAllManishapps() {
		log.info("Entered into method to fetch Manishapps data");
		ResponseEntity<?> resp = null ;
		try {

			log.info("About to call fetch manishapp service");
			List<Manishapp> list = service.getAllManishapps();
			if(list!=null && !list.isEmpty()) {
				log.info("Data is not empty=>"+list.size());
				list.sort((s1,s2)->s1.getPolicynamea().compareTo(s2.getPolicynamea()));
				/* JDK 1.8
				list = list.stream()
						.sorted((s1,s2)->s1.getName().compareTo(s2.getName()))
						.collect(Collectors.toList());
				 */
				resp = new ResponseEntity<List<Manishapp>>(list, HttpStatus.OK);
			} else {
				log.info("No Manishapp exist: size "+list.size());

				//resp = new ResponseEntity<>(HttpStatus.NO_CONTENT);
				resp = new ResponseEntity<String>(
						"No Manishapps Found",
						HttpStatus.OK);
			}
		} catch (Exception e) {
			log.error("Unable to fetch Manishapps : problem is :"+e.getMessage());

			resp =  new ResponseEntity<String>(
					"Unable to Fetch Manishapps", 
					HttpStatus.INTERNAL_SERVER_ERROR); //500
			e.printStackTrace();
		}
		log.info("About to Exist fetch all method with Response");
		return resp;
	}


	/***
	 * 3. Get one customer object based on ID (PathVariable). 
	 *   If Object exist then return Manishapp object 
	 *   else provide message(String).
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneManishapp(
			@PathVariable Integer id
			) 
	{
		log.info("Entered into Get one Manishapp method");
		ResponseEntity<?> resp = null;
		try {
			log.info("About to make service call to fetch one record");
			Optional<Manishapp> opt =  service.getOneManishapp(id);
			if(opt.isPresent()) {
				log.info("Manishapp exist=>"+id);
				resp = new ResponseEntity<Manishapp>(opt.get(), HttpStatus.OK);
				//resp = ResponseEntity.ok(opt.get());
			} else {
				log.warn("Given Manishapp id not exist=>"+id);
				resp = new ResponseEntity<String>(
						"Manishapp '"+id+"' not exist", 
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Unable to process request fetch " + e.getMessage());
			resp = new ResponseEntity<String>(
					"Unable to process manishapp fetch", 
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
	public ResponseEntity<String> removeManishapp(
			@PathVariable Integer id
			)
	{

		log.info("Entered into delete method");
		ResponseEntity<String> resp = null;

		try {

			log.info("About to make service call for data check");
			boolean exist = service.isManishappExist(id);
			if(exist) {
				service.deleteManishapp(id);
				log.info("Manish exist with given id and deleted=>"+id);
				resp = new ResponseEntity<String>(
						"Policy '"+id+"' disapproved",
						HttpStatus.OK);
			} else {
				log.warn("Given Manishapp id not exist =>"+id);
				resp = new ResponseEntity<String>(
						"Manishapp '"+id+"' not exist",
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
	public ResponseEntity<String> updateManishapp(
			@PathVariable Integer id,
			@RequestBody Manishapp manishapps
			)
	{
		log.info("Entered into Update method");

		ResponseEntity<String> resp =null;

		try {
			log.info("About to check given id exist or not db");
			Optional<Manishapp> opt =  service.getOneManishapp(id);
			if(opt.isPresent()) {
				log.info("Manish present in database");
				Manishapp actual = opt.get();
				util.mapToActualObject(actual,manishapps);
				service.updateManishapp(actual);
				resp = new ResponseEntity<String>(
						"Policy '"+id+"' Approved", 
						//HttpStatus.RESET_CONTENT
						HttpStatus.OK
						);
				log.info("Manishapp update done successfully");
			} else {
				log.info("Manishapp not exist=>"+id);
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

