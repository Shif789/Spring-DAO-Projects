package in.ineuron.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;

@Service(value = "service")
//@Transactional // can be applied here too
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	ICoronaVaccineRepo repo;

	@Override
	public List<CoronaVaccine> fetchVaccineByCompany(String company) {

		return repo.searchVaccineByCompany(company);
	}

	@Override
	public List<CoronaVaccine> fetchVaccineByCompanies(String company1, String company2) {

		return repo.searchVaccineByCompanies(company1, company2);
	}

	@Override
	public List<Object[]> fetchVaccineByNames(String name1, String name2) {

		return repo.searchVaccineByNames(name1, name2);
	}

	@Override
	public List<String> fetchVaccineByPriceRange(Double min, Double max) {

		return repo.searchVaccineByPriceRange(min, max);
	}

	@Override
	@Transactional
	public int modifyPriceByCountry(Double newPrice, String country) {
		
		return repo.updatePriceByCountry(newPrice, country);
	}

	@Override
	public String removeVaccineByPriceRange(Double min, Double max) {
		int rowCount = repo.deleteVaccineByPriceRange(min, max);
		if (rowCount>0) {
			return "No. of vaccine record/records deleted is/are: "+rowCount;
		} 
		return "no records are deleted";
	}

	@Override
	public String registerVaccine(String company, String name, String country, Double price,
			Integer requiredDoseCount) {
		int rowCount = repo.insertVaccine(company, name, country, price, requiredDoseCount);
		if (rowCount>0) {
			return "No. of vaccine record inserted is: "+rowCount;
		} 
		return "Vaccine record insertion failed";
	}

	@Override
	public Date fetchSystemDate() {
		
		return repo.getSystemDate();
	}

}
