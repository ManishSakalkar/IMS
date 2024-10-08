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

import insurance.model.Category;
import insurance.service.ICategoryServices;
import insurance.util.CategoryUtil;

@RestController
@RequestMapping("/api/categorys")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryRestController {

	private Logger log = LoggerFactory.getLogger(CategoryRestController.class);

	@Autowired
	private ICategoryServices service;
	@Autowired
	private CategoryUtil util;

	/**
	 * 1. Read JSON(Category) and convert to Object Format
	 *    Store data in Database. Return one Message.
	 */
	@PostMapping
	public ResponseEntity<String> saveCategory(
			@RequestBody Category categorys)
	{
		log.info("Entered into method with Category data to save");

		ResponseEntity<String> resp = null;
		try {

			log.info("About to call save Operation");

			Integer id = service.saveCategory(categorys);
			log.debug("Category saved with id "+id);

			String body = "Category '"+id+"' created";

			resp =  new ResponseEntity<String>(
					body,HttpStatus.CREATED); //201

			log.info("Sucess response constructed");
		} catch (Exception e) {
			log.error("Unable to save employee : problem is :"+e.getMessage());
			resp =  new ResponseEntity<String>(
					"Unable to Create Customer", 
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
	public ResponseEntity<?> getAllCategorys() {
		log.info("Entered into method to fetch Customers data");
		ResponseEntity<?> resp = null ;
		try {

			log.info("About to call fetch customer service");
			List<Category> list = service.getAllCategorys();
			if(list!=null && !list.isEmpty()) {
				log.info("Data is not empty=>"+list.size());
				list.sort((s1,s2)->s1.getCategoryname().compareTo(s2.getCategoryname()));
				/* JDK 1.8
				list = list.stream()
						.sorted((s1,s2)->s1.getName().compareTo(s2.getName()))
						.collect(Collectors.toList());
				 */
				resp = new ResponseEntity<List<Category>>(list, HttpStatus.OK);
			} else {
				log.info("No Customer exist: size "+list.size());

				//resp = new ResponseEntity<>(HttpStatus.NO_CONTENT);
				resp = new ResponseEntity<String>(
						"No Customers Found",
						HttpStatus.OK);
			}
		} catch (Exception e) {
			log.error("Unable to fetch Customers : problem is :"+e.getMessage());

			resp =  new ResponseEntity<String>(
					"Unable to Fetch Customers", 
					HttpStatus.INTERNAL_SERVER_ERROR); //500
			e.printStackTrace();
		}
		log.info("About to Exist fetch all method with Response");
		return resp;
	}


	/***
	 * 3. Get one customer object based on ID (PathVariable). 
	 *   If Object exist then return Customer object 
	 *   else provide message(String).
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneCategory(
			@PathVariable Integer id
			) 
	{
		log.info("Entered into Get one Customer method");
		ResponseEntity<?> resp = null;
		try {
			log.info("About to make service call to fetch one record");
			Optional<Category> opt =  service.getOneCategory(id);
			if(opt.isPresent()) {
				log.info("Customer exist=>"+id);
				resp = new ResponseEntity<Category>(opt.get(), HttpStatus.OK);
				//resp = ResponseEntity.ok(opt.get());
			} else {
				log.warn("Given Customer id not exist=>"+id);
				resp = new ResponseEntity<String>(
						"Customer '"+id+"' not exist", 
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Unable to process request fetch " + e.getMessage());
			resp = new ResponseEntity<String>(
					"Unable to process customer fetch", 
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
	public ResponseEntity<String> removeCategory(
			@PathVariable Integer id
			)
	{

		log.info("Entered into delete method");
		ResponseEntity<String> resp = null;

		try {

			log.info("About to make service call for data check");
			boolean exist = service.isCategoryExist(id);
			if(exist) {
				service.deleteCategory(id);
				log.info("Customer exist with given id and deleted=>"+id);
				resp = new ResponseEntity<String>(
						"Category '"+id+"' deleted",
						HttpStatus.OK);
			} else {
				log.warn("Given Customer id not exist =>"+id);
				resp = new ResponseEntity<String>(
						"Customer '"+id+"' not exist",
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
	public ResponseEntity<String> updateCategory(
			@PathVariable Integer id,
			@RequestBody Category categorys
			)
	{
		log.info("Entered into Update method");

		ResponseEntity<String> resp =null;

		try {
			log.info("About to check given id exist or not db");
			Optional<Category> opt =  service.getOneCategory(id);
			if(opt.isPresent()) {
				log.info("Customer present in database");
				Category actual = opt.get();
				util.mapToActualObject(actual,categorys);
				service.updateCategory(actual);
				resp = new ResponseEntity<String>(
						"Customer '"+id+"' Updated", 
						//HttpStatus.RESET_CONTENT
						HttpStatus.OK
						);
				log.info("Customer update done successfully");
			} else {
				log.info("Customer not exist=>"+id);
				resp = new ResponseEntity<String>(
						"Customer '"+id+"' not found", 
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

