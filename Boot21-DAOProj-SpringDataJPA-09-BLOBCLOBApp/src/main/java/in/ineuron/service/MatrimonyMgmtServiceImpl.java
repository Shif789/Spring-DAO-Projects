package in.ineuron.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.MarriageSeeker;
import in.ineuron.dao.IMarriageSeekerRepo;

@Service(value = "service")
public class MatrimonyMgmtServiceImpl implements IMatrimonyMgmtService {

	@Autowired
	private IMarriageSeekerRepo repo;

	@Override
	public String registerMarriageSeeker(MarriageSeeker marriageSeeker) {
		MarriageSeeker seeker = null;
		seeker = repo.save(marriageSeeker);
		return seeker != null ? "Marriage Seeker record registered with id: " + seeker.getId()
				: "Marriage Seeker failed to register ";
	}

	@Override
	public Optional<MarriageSeeker> searchMarriageSeekerById(Long id) {
		return repo.findById(id);
	}

}
