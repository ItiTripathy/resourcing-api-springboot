package io.nology.resourceapi.temp;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.nology.resourceapi.job.JobRepository;

@Service
@Transactional
public class TempService {
	
	@Autowired
	  private TempRepository tempRepository;

	  @Autowired
	  private JobRepository jobRepository;


	
	public Optional<Temp> findById(Long id) {
	    return this.tempRepository.findById(id);
	  }

}
