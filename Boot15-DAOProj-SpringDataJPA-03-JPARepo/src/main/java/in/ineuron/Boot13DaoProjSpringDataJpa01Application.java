package in.ineuron;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class Boot13DaoProjSpringDataJpa01Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Boot13DaoProjSpringDataJpa01Application.class,
				args);

		ICoronaVaccineMgmtService mgmtService = applicationContext.getBean(ICoronaVaccineMgmtService.class);

		CoronaVaccine coronaVaccine = new CoronaVaccine(null, null, null, null, null, 3);
		List<CoronaVaccine> vaccinesByGivenData = mgmtService.searchVaccinesByGivenData(coronaVaccine, true, "price");
		vaccinesByGivenData.forEach(System.out::println);

		System.out.println("**********************************************************");

		try {
			CoronaVaccine vaccineById = mgmtService.getVaccineById(1L);
			System.out.println("Vaccine details are: " + vaccineById);

		} catch (EntityNotFoundException e) {
			e.printStackTrace();// doesnt handle
		} catch (DataAccessException e) {
			e.printStackTrace();// doesnt handle
		} catch (Exception e) {
			System.out.println("vaccine not available");
			e.printStackTrace();// doesnt handle
		}

		System.out.println("**********************************************************");

		List<Long> regNoList = new ArrayList<Long>();
		regNoList.add(8L);
		regNoList.add(9L);
		regNoList.add(10L);
		String deletionStatus = mgmtService.removeVaccinesByRegNo(regNoList);
		System.out.println(deletionStatus);

		((ConfigurableApplicationContext) applicationContext).close();
	}

}
