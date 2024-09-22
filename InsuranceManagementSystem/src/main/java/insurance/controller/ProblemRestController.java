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

import insurance.model.Problem;
import insurance.service.IProblemServices;
import insurance.util.ProblemUtil;

@RestController
@RequestMapping("/api/problems")
@CrossOrigin(origins = "http://localhost:4200")
public class ProblemRestController {

	private Logger log = LoggerFactory.getLogger(ProblemRestController.class);

	@Autowired
	private IProblemServices service;
	@Autowired
	private ProblemUtil util;

	/**
	 * 1. Read JSON(Problem) and convert to Object Format
	 *    Store data in Database. Return one Message.
	 */
	@PostMapping
	public ResponseEntity<String> saveProblem(
			@RequestBody Problem problems)
	{
		log.info("Entered into method with Problem data to save");

		ResponseEntity<String> resp = null;
		try {

			log.info("About to call save Operation");

			Integer id = service.saveProblem(problems);
			log.debug("Problem saved with id "+id);

			String body = "Problem '"+id+"' created";

			resp =  new ResponseEntity<String>(
					body,HttpStatus.CREATED); //201

			log.info("Sucess response constructed");
		} catch (Exception e) {
			log.error("Unable to save problem : problem is :"+e.getMessage());
			resp =  new ResponseEntity<String>(
					"Unable to Create Problem", 
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
	public ResponseEntity<?> getAllProblems() {
		log.info("Entered into method to fetch Problems data");
		ResponseEntity<?> resp = null ;
		try {

			log.info("About to call fetch problem service");
			List<Problem> list = service.getAllProblems();
			if(list!=null && !list.isEmpty()) {
				log.info("Data is not empty=>"+list.size());
				list.sort((s1,s2)->s1.getProblemname().compareTo(s2.getProblemname()));
				/* JDK 1.8
				list = list.stream()
						.sorted((s1,s2)->s1.getName().compareTo(s2.getName()))
						.collect(Collectors.toList());
				 */
				resp = new ResponseEntity<List<Problem>>(list, HttpStatus.OK);
			} else {
				log.info("No Problem exist: size "+list.size());

				//resp = new ResponseEntity<>(HttpStatus.NO_CONTENT);
				resp = new ResponseEntity<String>(
						"No Problems Found",
						HttpStatus.OK);
			}
		} catch (Exception e) {
			log.error("Unable to fetch Problems : problem is :"+e.getMessage());

			resp =  new ResponseEntity<String>(
					"Unable to Fetch Problems", 
					HttpStatus.INTERNAL_SERVER_ERROR); //500
			e.printStackTrace();
		}
		log.info("About to Exist fetch all method with Response");
		return resp;
	}


	/***
	 * 3. Get one Problem object based on ID (PathVariable). 
	 *   If Object exist then return Customer object 
	 *   else provide message(String).
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneProblem(
			@PathVariable Integer id
			) 
	{
		log.info("Entered into Get one Problem method");
		ResponseEntity<?> resp = null;
		try {
			log.info("About to make service call to fetch one record");
			Optional<Problem> opt =  service.getOneProblem(id);
			if(opt.isPresent()) {
				log.info("Problem exist=>"+id);
				resp = new ResponseEntity<Problem>(opt.get(), HttpStatus.OK);
				//resp = ResponseEntity.ok(opt.get());
			} else {
				log.warn("Given Problem id not exist=>"+id);
				resp = new ResponseEntity<String>(
						"Problem '"+id+"' not exist", 
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Unable to process request fetch " + e.getMessage());
			resp = new ResponseEntity<String>(
					"Unable to process problem fetch", 
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
	public ResponseEntity<String> removeProblem(
			@PathVariable Integer id
			)
	{

		log.info("Entered into delete method");
		ResponseEntity<String> resp = null;

		try {

			log.info("About to make service call for data check");
			boolean exist = service.isProblemExist(id);
			if(exist) {
				service.deleteProblem(id);
				log.info("Problem exist with given id and deleted=>"+id);
				resp = new ResponseEntity<String>(
						"Problem '"+id+"' deleted",
						HttpStatus.OK);
			} else {
				log.warn("Given Problem id not exist =>"+id);
				resp = new ResponseEntity<String>(
						"Problem '"+id+"' not exist",
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
	public ResponseEntity<String> updateProblem(
			@PathVariable Integer id,
			@RequestBody Problem problems
			)
	{
		log.info("Entered into Update method");

		ResponseEntity<String> resp =null;

		try {
			log.info("About to check given id exist or not db");
			Optional<Problem> opt =  service.getOneProblem(id);
			if(opt.isPresent()) {
				log.info("Problem present in database");
				Problem actual = opt.get();
				util.mapToActualObject(actual,problems);
				service.updateProblem(actual);
				resp = new ResponseEntity<String>(
						"Problem '"+id+"' Updated", 
						//HttpStatus.RESET_CONTENT
						HttpStatus.OK
						);
				log.info("Problem update done successfully");
			} else {
				log.info("Problem not exist=>"+id);
				resp = new ResponseEntity<String>(
						"Problem '"+id+"' not found", 
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

