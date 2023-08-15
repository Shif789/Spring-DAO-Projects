package in.ineuron.service;

import java.util.Date;
import java.util.List;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineMgmtService {

	public List<CoronaVaccine> fetchVaccineByCompany(String company);

	public List<CoronaVaccine> fetchVaccineByCompanies(String company1, String company2);

	public List<Object[]> fetchVaccineByNames(String name1, String name2);

	public List<String> fetchVaccineByPriceRange(Double min, Double max);
	
	public int modifyPriceByCountry(Double newPrice, String country);
	
	public String removeVaccineByPriceRange(Double min, Double max);
	
	public String registerVaccine(String company, String name, String country, Double price, Integer requiredDoseCount);
	
	public Date fetchSystemDate();
}
