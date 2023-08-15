package in.ineuron;

import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.IEmployeeManagementService;

@SpringBootApplication
public class Boot09DaoProjectXmlJdbcTemplateDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Boot09DaoProjectXmlJdbcTemplateDirectMethodsApplication.class, args);
		
		IEmployeeManagementService service = context.getBean(IEmployeeManagementService.class);
		
		String name = service.getEmployeeNameByNo(1);
		System.out.println("Name of the employee is: "+name);
		
		List<Map<String,Object>> employeeDetailsByDesignation = service.getEmployeeDetailsByDesignation("Dhaka", "Barisal");
		employeeDetailsByDesignation.forEach(System.out::println);
		
		
		((ConfigurableApplicationContext) context).close();
	}

}
