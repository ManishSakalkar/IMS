package insurance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import insurance.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>
{

}
