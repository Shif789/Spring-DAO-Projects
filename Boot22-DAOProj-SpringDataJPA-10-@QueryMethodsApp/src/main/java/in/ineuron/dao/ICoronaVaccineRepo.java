package in.ineuron.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

	// @Query(value = "FROM CoronaVaccine WHERE company=?1")
	//@Query(value = "FROM CoronaVaccine WHERE company=:vendor") // param name in method should be same as the named param
																// here in HQL
	 @Query(value = "FROM in.ineuron.bo.CoronaVaccine WHERE company=:comp")//@Param is required for this one
	public List<CoronaVaccine> searchVaccineByCompany( @Param("comp") String vendor);

	@Query("FROM CoronaVaccine WHERE company IN(:company1,:company2)")
	public List<CoronaVaccine> searchVaccineByCompanies(String company1, String company2);

	@Query("SELECT name, company, price FROM CoronaVaccine WHERE name IN(:name1,:name2)")
	public List<Object[]> searchVaccineByNames(String name1, String name2);

	@Query("SELECT name FROM CoronaVaccine WHERE price BETWEEN :min AND :max")
	public List<String> searchVaccineByPriceRange(Double min, Double max);
	
	@Modifying //required for non-select operations
	@Query("UPDATE CoronaVaccine SET price=:newPrice WHERE country=:country")
	public int updatePriceByCountry(Double newPrice, String country);
	
	@Modifying //required for non-select operations
	@Query("DELETE FROM CoronaVaccine WHERE price BETWEEN :min AND :max")
	@Transactional
	public int deleteVaccineByPriceRange(Double min, Double max);
	
	@Modifying //required for non-select operations
	@Query( value = "INSERT INTO corona_vaccine (company,name,country,price,required_dose_count) VALUES(?,?,?,?,?)", nativeQuery = true)
	@Transactional
	public int insertVaccine(String company, String name, String country, Double price, Integer requiredDoseCount);
	
	@Query(value = "SELECT NOW() FROM DUAL", nativeQuery = true)
	public Date getSystemDate();
}
