package in.ineuron.service;

import java.util.List;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineMgmtService {

	public List<CoronaVaccine> searchVaccinesByGivenData(CoronaVaccine coronaVaccine,boolean asc,String... properties);
	public CoronaVaccine getVaccineById(Long regNo);
	public String removeVaccinesByRegNo(Iterable<Long> regNos);
}
