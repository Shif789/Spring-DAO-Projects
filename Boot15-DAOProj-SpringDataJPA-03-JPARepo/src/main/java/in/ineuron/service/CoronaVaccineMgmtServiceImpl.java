package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;

@Service(value = "service")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	ICoronaVaccineRepo repo;

	@Override
	public List<CoronaVaccine> searchVaccinesByGivenData(CoronaVaccine coronaVaccine, boolean asc,
			String... properties) {
		System.out.println("Proxy class is: " + repo.getClass().getName());

		Example<CoronaVaccine> example = Example.of(coronaVaccine);
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);
		List<CoronaVaccine> vaccineList = repo.findAll(example, sort);
		return vaccineList;
	}

	@Override
	public CoronaVaccine getVaccineById(Long regNo) {
		CoronaVaccine coronaVaccine = repo.getReferenceById(regNo);
		return coronaVaccine;
	}

	@Override
	public String removeVaccinesByRegNo(Iterable<Long> regNos) {
		List<CoronaVaccine> vaccineList = repo.findAllById(regNos);
		vaccineList.forEach(vaccine->{
			System.out.println("vaccine available wiht register No. : "+vaccine.getRegNo());
		});
		if (vaccineList.size() != 0) {
			repo.deleteAllByIdInBatch(regNos);
			return "Vaccines deletion successful with vaccine count: "+vaccineList.size();
		}
		return "Vaccines not found for deletion";

	}

}
