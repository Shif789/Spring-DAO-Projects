package in.ineuron.runner;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ineuron.model.Person;
import in.ineuron.model.PhoneNumber;
import in.ineuron.service.IPersonMgmtService;

@Component
public class AssociationRunner implements CommandLineRunner {

	@Autowired
	private IPersonMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		//Save Operation parent to child
		  
		  // create a parent object 
		  Person person = new Person("Shifat", "Dhaka");
		  
		  // create child objects 
		  PhoneNumber p1 = new PhoneNumber(9998887775L,"grameenphone", "office"); 
		  PhoneNumber p2 = new PhoneNumber(9998887776L,"robi", "home");
		  
		// link parent to child
		  p1.setPerson(person);
		  p2.setPerson(person);
		  
		  Set<PhoneNumber> contacts = new LinkedHashSet<PhoneNumber>();
		  contacts.add(p1); 
		  contacts.add(p2);
		  
		  // link child to parent 
		  person.setContactDetails(contacts);
		  String status1 = service.savePerson(person);
		  System.out.println(status1);
		 
		
		// Save Operation child to parent
//		PhoneNumber p1 = new PhoneNumber(9998887772L,"airtel", "personal3"); 
//		PhoneNumber p2 = new PhoneNumber(9998887773L,"citycell", "residence3");
//		Person person = new Person("Naim", "Dhaka");
//		// link parent to child
//		p1.setPerson(person);
//		p2.setPerson(person);
//		Set<PhoneNumber> contacts = new LinkedHashSet<PhoneNumber>();
//		contacts.add(p1);
//		contacts.add(p2);
//		person.setContactDetails(contacts);
//		String status2 = service.savePhoneNumbers(contacts);
//		System.out.println(status2);
		
		
		// load operation from parent to child
//		service.fetchByPerson().forEach(person -> {
//			System.out.println("Parent:: " + person);
//			Set<PhoneNumber> contactDetails = person.getContactDetails();
//			contactDetails.forEach(contact -> System.out.println("Child:: " + contact));
//		});
		  
		
//		System.out.println();
//		
//		// load operation from child to parent
//		service.fetchByPhoneNumber().forEach(contact -> {
//			System.out.println("Child:: " + contact);
//			Person person = contact.getPerson();
//			System.out.println("Parent:: " + person);
//		});
		  
		
		// delete person and his phone numbers
//		String deleteStatus = service.deleteByPersonById(3);
//		System.out.println(deleteStatus);
		  
		
		// delete person's phone numbers only
//		String deleteStatus2 = service.deleteAllPhoneNumbersOfAPerson(5);
//		System.out.println(deleteStatus2);
		
	}

}
