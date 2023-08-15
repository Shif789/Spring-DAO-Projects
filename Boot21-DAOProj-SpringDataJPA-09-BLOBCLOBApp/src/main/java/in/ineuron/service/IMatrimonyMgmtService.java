package in.ineuron.service;

import java.util.Optional;

import in.ineuron.bo.MarriageSeeker;

public interface IMatrimonyMgmtService {

	public String registerMarriageSeeker(MarriageSeeker marriageSeeker);
	public Optional<MarriageSeeker> searchMarriageSeekerById(Long id);
}
