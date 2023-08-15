package in.ineuron.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ineuron.model.Person;

public interface IPersonRepository extends JpaRepository<Person, Integer> {

	@Query(value = "SELECT p.pid,p.pname,p.paddress,ph.regNo,ph.phoneNo,ph.provider,ph.type FROM Person p inner join p.contactDetails ph")
	//@Query(value = "SELECT p.pid,p.pname,p.paddress,ph.regNo,ph.phoneNo,ph.provider,ph.type FROM Person p right join p.contactDetails ph")
	//@Query(value = "SELECT p.pid,p.pname,p.paddress,ph.regNo,ph.phoneNo,ph.provider,ph.type FROM Person p left join p.contactDetails ph")
	//@Query(value = "SELECT p.pid,p.pname,p.paddress,ph.regNo,ph.phoneNo,ph.provider,ph.type FROM Person p full join p.contactDetails ph")// not working
	public List<Object[]> findDataUsingJoinsByParent();
}
