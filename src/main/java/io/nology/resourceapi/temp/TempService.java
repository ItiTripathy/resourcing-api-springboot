package io.nology.resourceapi.temp;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import io.nology.resourceapi.job.JobRepository;

@Service
@Transactional
public class TempService {
	
	@Autowired
	private TempRepository tempRepository;

	//@Autowired
	//private JobRepository jobRepository;

	
	public Temp create(TempCreateDTO data) {
		
		Temp newTemp = new Temp(data.getFirstName(), data.getLastName(), null);
		this.tempRepository.save(newTemp);
		return newTemp;
	}
	
	public Optional<Temp> findById(Long id) {
		
	    return this.tempRepository.findById(id);
	}

}
