package in.ineuron;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.service.IEmployeeManagementService;

public class App 
{
    public static void main( String[] args )
    {
         ApplicationContext context = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
         IEmployeeManagementService service =  context.getBean(IEmployeeManagementService.class);
         
         try {
			
		
         int recordCount = service.fetchEmpsCount();
         System.out.println("Number of employees are: "+ recordCount );
         
         String name = service.getEmployeeNameByNo(1);
         System.out.println("Name of the employee is: "+name);
        
         Map<String, Object> empDetails = service.getEmployeeDetailsByNo(1);
         System.out.println("Employee details are: "+empDetails);
         
         List<Map<String,Object>> employeeDetailsByDesignation = service.getEmployeeDetailsByDesignation("Dhaka", "Barisal");
         employeeDetailsByDesignation.forEach(System.out::println);
         
         int rowsAffected = service.insertEmp("Kabir", 55, "Saudi");
         System.out.println("No. of rows affected: "+rowsAffected);
         
         int rowsForUpdation = service.addBounsToEmpByDesig("Dhaka", 300);
         System.out.println("No. of rows affected are: "+rowsForUpdation);
         
         } catch (Exception e) {
 			System.out.println("The exception message is: "+e.getMessage());
 		}
         
        ((ConfigurableApplicationContext) context).close();
    }
}
