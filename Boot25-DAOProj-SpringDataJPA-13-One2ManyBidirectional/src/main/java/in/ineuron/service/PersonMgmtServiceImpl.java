package in.ineuron.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.Person;
import in.ineuron.model.PhoneNumber;
import in.ineuron.repo.IPersonRepository;
import in.ineuron.repo.IPhoneNumberRepository;

@Service("service")
public class PersonMgmtServiceImpl implements IPersonMgmtService {

	@Autowired
	private IPhoneNumberRepository phoneRepo;

	@Autowired
	private IPersonRepository personRepo;

	@Override
	public String savePerson(Person person) {
		Person savedPerson = personRepo.save(person);

		return "Person and his phone numbers record is saved with id: " + savedPerson.getPid();
	}

	@Override
	public String savePhoneNumbers(Iterable<PhoneNumber> numbers) {

		for (PhoneNumber phoneNumber : numbers) {
			phoneRepo.save(phoneNumber);
		}
		return "No. of Phone number record saved is: " + ((Set<PhoneNumber>) numbers).size();
	}

	@Override
	public Iterable<Person> fetchByPerson() {

		return personRepo.findAll();
	}

	@Override
	public Iterable<PhoneNumber> fetchByPhoneNumber() {
		return phoneRepo.findAll();
	}

	@Override
	public String deleteByPersonById(int personId) {
		Optional<Person> optional = personRepo.findById(personId);
		if (optional.isPresent()) {
			personRepo.delete(optional.get());
			return "Person and his phone numbers are deleted with id: "+personId;
		}
		return "Person not found for deletion with id: "+personId;
	}

	@Override
	public String deleteAllPhoneNumbersOfAPerson(int personId) {
		Optional<Person> optional = personRepo.findById(personId);
		if (optional.isPresent()) {
			Set<PhoneNumber> phoneNumbers = optional.get().getContactDetails();
			
			phoneNumbers.forEach(phoneNumber->{
				phoneNumber.setPerson(null);
			});
			// delete all children
			phoneRepo.deleteAll(phoneNumbers);
			
			return phoneNumbers.size()+" phone numbers are deleted with Person id: "+personId;
		}
		return "Person not found for deletion with id: "+personId;
	}

}
