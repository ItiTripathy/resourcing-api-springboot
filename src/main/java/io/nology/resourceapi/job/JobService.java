package io.nology.resourceapi.job;

import java.time.LocalDate;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.nology.resourceapi.temp.Temp;
import io.nology.resourceapi.temp.TempService;

@Service
@Transactional
public class JobService {
	
	 @Autowired
	 private JobRepository jobRepository;
	 
	 @Autowired
	 private TempService tempService;

	

	public Job create(@Valid JobCreateDTO data) {
		    Long tempId = data.getTempId();
		    String name = data.getName();
		    LocalDate startDate = data.getStartDate();
		    LocalDate endDate = data.getEndDate();

		    if (tempId == null) {
		      Job unassignedJob = new Job(name, startDate, endDate, null);
		      this.jobRepository.save(unassignedJob);
		      return unassignedJob;
		    }

		    Optional<Temp> maybeTemp = this.tempService.findById(tempId);
		    if (maybeTemp.isEmpty()) {
		    	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no temp");
		    }

		    Temp foundTemp = maybeTemp.get();
		    if (!foundTemp.isAvailableOnSpecificedDate(startDate)) {
		    	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no temp");
		    }

		    Job assignedJob = new Job(name, startDate, endDate, foundTemp);
		    this.jobRepository.save(assignedJob);
		    return assignedJob;
	}

}
