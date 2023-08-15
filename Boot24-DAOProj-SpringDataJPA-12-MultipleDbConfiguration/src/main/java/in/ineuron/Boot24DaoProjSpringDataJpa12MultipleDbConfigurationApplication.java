package in.ineuron;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.ineuron.config.model.customer.Customer;
import in.ineuron.config.model.product.Product;
import in.ineuron.repo.customer.ICustomerRepository;
import in.ineuron.repo.product.IProductRepository;

@SpringBootApplication
public class Boot24DaoProjSpringDataJpa12MultipleDbConfigurationApplication implements CommandLineRunner {

	@Autowired
	private ICustomerRepository customerRepo;

	@Autowired
	private IProductRepository productRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Boot24DaoProjSpringDataJpa12MultipleDbConfigurationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepo.saveAll(
				Arrays.asList(
						new Product(null, "C-001", "Fossil"),
						new Product(null, "C-002", "Armani"),
						new Product(null, "C-001", "Tissot")
						)
				);
		
		customerRepo.saveAll(
				Arrays.asList(
						new Customer(null, "Shifat", "shifat@gmail.com"),
						new Customer(null, "Nadim", "nadim@gmail.com"),
						new Customer(null, "Mahmud", "mahmud@gmail.com")
						)
				);
		
	}

}
