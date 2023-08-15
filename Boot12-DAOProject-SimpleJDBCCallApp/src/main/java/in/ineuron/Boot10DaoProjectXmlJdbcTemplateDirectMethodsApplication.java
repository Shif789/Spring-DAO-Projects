package in.ineuron;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.DTO.ProductDTO;
import in.ineuron.service.IProductManagementService;

@SpringBootApplication
public class Boot10DaoProjectXmlJdbcTemplateDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication
				.run(Boot10DaoProjectXmlJdbcTemplateDirectMethodsApplication.class, args);

		IProductManagementService service = context.getBean(IProductManagementService.class);


		List<ProductDTO> productDTOList = service.fetchProductByName("tissot", "fossil");
		productDTOList.forEach(System.out::println);

		
		

		((ConfigurableApplicationContext) context).close();
	}

}
