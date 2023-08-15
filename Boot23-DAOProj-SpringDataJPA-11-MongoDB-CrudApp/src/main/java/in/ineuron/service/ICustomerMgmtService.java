package in.ineuron.service;

import java.util.List;

import in.ineuron.document.Customer;
import in.ineuron.dto.CustomerDTO;

public interface ICustomerMgmtService {

	public String registerCustomer(CustomerDTO customerDTO);
	public List<Customer> findAllCustomer();
	public String removeCustomerById(String id);
	public String saveOrUpdateCustomerWithUUID(CustomerDTO customerDTO);
	public List<Customer> fetchCustomersByBillAmtRange(Float min, Float max);
	public List<Customer> fetchCustomerByAddressHavingMobileNo(String... address);
}
