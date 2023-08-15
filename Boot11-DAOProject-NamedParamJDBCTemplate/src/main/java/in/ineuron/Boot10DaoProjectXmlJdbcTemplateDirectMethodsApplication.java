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
		ApplicationContext context = SpringApplication
				.run(Boot10DaoProjectXmlJdbcTemplateDirectMethodsApplication.class, args);

		IStudentManagementService service = context.getBean(IStudentManagementService.class);

		String name = service.getStudentNameByNo(11);
		System.out.println("Name is: " + name);

		System.out.println();

		StudentDTO studentDTO = service.fetchStudentNameByNo(11);
		System.out.println("Student details are: " + studentDTO);

		System.out.println();

		List<StudentDTO> studentDTOList = service.fetchStudentByName("Ovi", "Walid");
		studentDTOList.forEach(System.out::println);

		System.out.println();

		List<StudentDTO> studentDTOListByCity = service.fetchStudentByCity("Dhaka", "Riyadh");
		studentDTOListByCity.forEach(System.out::println);
		
		System.out.println();
		
		StudentDTO studentDTO2 = new StudentDTO();
		studentDTO2.setSid(23);
		studentDTO2.setSname("Shifath");
		studentDTO2.setSage(26);
		studentDTO2.setSaddress("Dhaka");
		String status = service.registerStudent(studentDTO2);
		System.out.println("Record insertion status: "+status);
		

		((ConfigurableApplicationContext) context).close();
	}

}
