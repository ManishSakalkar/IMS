package insurance.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import insurance.model.Customer;
import insurance.repo.CustomerRepository;
import insurance.service.ICustomerServices;

@Service
public class CustomerServiceImpl implements ICustomerServices {

	@Autowired
	private CustomerRepository repo;
	
	@Override
	public Integer saveCustomer(Customer s) {
		s = repo.save(s);
		return s.getId();
	}

	@Override
	public void updateCustomer(Customer s) {
		repo.save(s);
	}

	@Override
	public void deleteCustomer(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Customer> getOneCustomer(Integer id) {
		return repo.findById(id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}

	@Override
	public boolean isCustomerExist(Integer id) {
		return repo.existsById(id);
	}

	
}
