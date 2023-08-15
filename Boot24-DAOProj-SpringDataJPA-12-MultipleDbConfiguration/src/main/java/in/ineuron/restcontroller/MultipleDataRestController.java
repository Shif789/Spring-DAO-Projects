package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.config.model.customer.Customer;
import in.ineuron.config.model.product.Product;
import in.ineuron.repo.customer.ICustomerRepository;
import in.ineuron.repo.product.IProductRepository;

@RestController
@RequestMapping("/api")
public class MultipleDataRestController {

	@Autowired
	private ICustomerRepository customerRepo;

	@Autowired
	private IProductRepository productRepo;

	@GetMapping(value = "/product")
	public List<Product> findAllProducts() {
		List<Product> allProducts = productRepo.findAll();
		return allProducts;
	}

	@GetMapping(value = "/customer")
	public List<Customer> findAllCustomers() {
		List<Customer> allCustomers = customerRepo.findAll();
		return allCustomers;
	}

}
