package in.ineuron;

import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class Boot13DaoProjSpringDataJpa01Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Boot13DaoProjSpringDataJpa01Application.class,
				args);

		ICoronaVaccineMgmtService mgmtService = applicationContext.getBean(ICoronaVaccineMgmtService.class);

		List<CoronaVaccine> vaccineByCompany = mgmtService.fetchVaccineByCompany("Spikevax");
		vaccineByCompany.forEach(System.out::println);

		System.out.println("*************************************************************************************");

		List<CoronaVaccine> vaccineByCompanies = mgmtService.fetchVaccineByCompanies("Comirnaty", "Russie");
		vaccineByCompanies.forEach(System.out::println);

		System.out.println("****************************************************************************************");
		List<String> vaccineByPriceRange = mgmtService.fetchVaccineByPriceRange(250.0, 560.0);
		vaccineByPriceRange.forEach(System.out::println);

		System.out.println("****************************************************************************************");
		List<Object[]> vaccineByNames = mgmtService.fetchVaccineByNames("Covacin", "CovidShield");
		vaccineByNames.forEach(objects -> {
			for (Object object : objects) {
				System.out.print(object + " ");
			}
			System.out.println();
		});

		System.out.println("****************************************************************************************");

		System.out.println("No. of records updated is/are: " + mgmtService.modifyPriceByCountry(155.0, "China"));
		
		System.out.println("****************************************************************************************");
		
		String deletionStatus = mgmtService.removeVaccineByPriceRange(700.0, 900.0);
		System.out.println(deletionStatus);
		
		System.out.println("****************************************************************************************");
		
		String registerStatus = mgmtService.registerVaccine("Emcure", "Covovax", "USA", 850.0, 2);
		System.out.println(registerStatus);
		
		System.out.println("****************************************************************************************");
		
		Date systemDate = mgmtService.fetchSystemDate();
		System.out.println("Current date info is: "+systemDate);
	}

}
