package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.Customer;
import in.ineuron.dao.ICustomerRepo;

@Service(value = "service")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	private ICustomerRepo repo;

	@Override
	public String registerCustomer(Customer customer) {
		Customer customerSaved = repo.save(customer);
		return customerSaved!=null?"customer registered successfully with id: "+customerSaved.getCid():"customer registration failed";
	}

	@Override
	public List<Customer> fetchAllCustomers() {
		
		return (List<Customer>) repo.findAll();
	}
	
	
}
