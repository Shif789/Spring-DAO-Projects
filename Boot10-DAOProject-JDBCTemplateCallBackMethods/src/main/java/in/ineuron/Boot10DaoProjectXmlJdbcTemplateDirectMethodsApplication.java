package in.ineuron;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.DTO.StudentDTO;
import in.ineuron.service.IStudentManagementService;

@SpringBootApplication
public class Boot10DaoProjectXmlJdbcTemplateDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Boot10DaoProjectXmlJdbcTemplateDirectMethodsApplication.class, args);

		IStudentManagementService service = context.getBean(IStudentManagementService.class);

		StudentDTO studentDTO = service.fetchStudentNameByNo(11);
		System.out.println("Student details are: " + studentDTO);

		System.out.println();

		List<StudentDTO> studentDTOList = service.fetchStudentByName("Ovi", "Walid");
		studentDTOList.forEach(System.out::println);

		System.out.println();

		List<StudentDTO> studentDTOListByCity = service.fetchStudentByCity("Dhaka", "Riyadh");
		studentDTOListByCity.forEach(System.out::println);

		((ConfigurableApplicationContext) context).close();
	}

}
