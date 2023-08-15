package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.document.Customer;
import in.ineuron.dto.CustomerDTO;
import in.ineuron.generator.IdGenerator;
import in.ineuron.repository.ICustomerRepo;

@Service(value = "service")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	private ICustomerRepo repo;

	@Override
	public String registerCustomer(CustomerDTO customerDTO) {
		System.out.println("In memory proxy class is : " + repo.getClass().getName());

		Customer customerDocument = new Customer();
		
		BeanUtils.copyProperties(customerDTO, customerDocument);

		Customer savedCustomer = null;
		//savedCustomer = repo.insert(customerDocument);// it will just insert
		savedCustomer = repo.save(customerDocument);// it will both insert as well as update

		return savedCustomer != null ? "Customer record registered with id: " + savedCustomer.getId()
				: "Customer registration failed";
	}

	@Override
	public List<Customer> findAllCustomer() {
		//List<CustomerDTO> listCustomerDTO = new ArrayList<>();
		List<Customer> listCustomer = null;
		listCustomer = repo.findAll();
		/*
		 * if (listCustomer != null) {
		 * 
		 * listCustomer.forEach(customer -> { CustomerDTO customerDTO = new
		 * CustomerDTO(customer.getCno(), customer.getCname(), customer.getBillAmt());
		 * listCustomerDTO.add(customerDTO); }); }
		 */
		return listCustomer;
	}

	@Override
	public String removeCustomerById(String id) {
		Optional<Customer> optional = repo.findById(id);
		if (optional.isPresent()) {
			//repo.deleteById(id);// both works fine
			repo.delete(optional.get());
			return "Customer record deleted with id: " + optional.get().getId();
		}

		return "Customer record not found for deletion with id: "+id;
	}

	@Override
	public String saveOrUpdateCustomerWithUUID(CustomerDTO customerDTO) {
		
		Customer customerDocument = new Customer();
		customerDocument.setId(IdGenerator.generateId());
		//customerDocument.setId("ed8f14a300");
		
		BeanUtils.copyProperties(customerDTO, customerDocument);

		Customer savedCustomer = null;
		//savedCustomer = repo.insert(customerDocument);// it will just insert
		savedCustomer = repo.save(customerDocument);// it will both insert as well as update

		return savedCustomer != null ? "Customer record registered/updated with id: " + savedCustomer.getId()
				: "Customer registration failed";
	}

	@Override
	public List<Customer> fetchCustomersByBillAmtRange(Float min, Float max) {
		
		return repo.findByBillAmtBetween(min, max);
	}

	@Override
	public List<Customer> fetchCustomerByAddressHavingMobileNo(String... address) {
		
		return repo.findByCaddInAndMobileNoIsNotNull(address);
	}

}
