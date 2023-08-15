package in.ineuron;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.Customer;
import in.ineuron.service.ICustomerMgmtService;

@SpringBootApplication
public class Boot13DaoProjSpringDataJpa01Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Boot13DaoProjSpringDataJpa01Application.class,
				args);

		ICustomerMgmtService mgmtService = applicationContext.getBean(ICustomerMgmtService.class);
		
		Customer customer = new Customer("Walid", "Riyadh", LocalDateTime.of(1997, 9, 25,14,0,12), LocalTime.of(13, 45), LocalDate.now());
		
		String registerStatus = mgmtService.registerCustomer(customer);
		System.out.println(registerStatus);
		
		System.out.println("*******************************************************************************");
		
		List<Customer> allCustomers = mgmtService.fetchAllCustomers();
		allCustomers.forEach(System.out::println);

		((ConfigurableApplicationContext) applicationContext).close();
	}

}
