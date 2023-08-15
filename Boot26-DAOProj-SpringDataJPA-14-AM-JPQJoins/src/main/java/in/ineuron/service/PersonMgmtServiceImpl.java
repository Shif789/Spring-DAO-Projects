package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.repo.IPersonRepository;
import in.ineuron.repo.IPhoneNumberRepository;

@Service("service")
public class PersonMgmtServiceImpl implements IPersonMgmtService {

	@Autowired
	private IPhoneNumberRepository phoneRepo;

	@Autowired
	private IPersonRepository personRepo;

	@Override
	public List<Object[]> fetchDataUsingJoinsByParent() {
		
		return personRepo.findDataUsingJoinsByParent();
	}

	

}
