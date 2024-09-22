package insurance.service;

import java.util.List;
import java.util.Optional;

import insurance.model.Customer;

public interface ICustomerServices {

	Integer saveCustomer(Customer s);
	void updateCustomer(Customer s);
	
	void deleteCustomer(Integer id);

	Optional<Customer> getOneCustomer(Integer id);
	List<Customer> getAllCustomers();

	boolean isCustomerExist(Integer id);
}
