package in.ineuron;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.document.Customer;
import in.ineuron.dto.CustomerDTO;
import in.ineuron.service.ICustomerMgmtService;

@SpringBootApplication
public class Boot23DaoProjSpringDataJpa11MongoDbCrudAppApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Boot23DaoProjSpringDataJpa11MongoDbCrudAppApplication.class, args);
		
		ICustomerMgmtService mgmtService = applicationContext.getBean(ICustomerMgmtService.class);
		System.out.println(mgmtService.registerCustomer(new CustomerDTO(8, "Mahmood", 72.0f,"Dhaka", 41123456789L)));
		
		System.out.println("***********************************************************************");
		
		List<Customer> allCustomer = mgmtService.findAllCustomer();
		allCustomer.forEach(System.out::println);
		
		System.out.println("***********************************************************************");
		
		String removeStatus= mgmtService.removeCustomerById("6468082263ea39ddf2fa71f8");
		System.out.println(removeStatus);
		
		System.out.println("***********************************************************************");
		
		System.out.println(mgmtService.saveOrUpdateCustomerWithUUID(new CustomerDTO(17, "Nasima", 68.0f, "Barisal", 31123456789L)));
		
		System.out.println("***********************************************************************");
		
		List<Customer> customersByBillAmtRange = mgmtService.fetchCustomersByBillAmtRange(50.0f, 70.0f);
		customersByBillAmtRange.forEach(System.out::println);
		
		System.out.println("***********************************************************************");
		
		List<Customer> customerByAddressHavingMobileNo = mgmtService.fetchCustomerByAddressHavingMobileNo("Dhaka","Gazipur");
		customerByAddressHavingMobileNo.forEach(System.out::println);
		
		((ConfigurableApplicationContext) applicationContext).close();
	}

}
