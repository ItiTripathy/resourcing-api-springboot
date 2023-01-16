package io.nology.resourceapi.job;



import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;






@RestController
@RequestMapping("/jobs")
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	
	@PostMapping
	public ResponseEntity<Job> create(@Valid @RequestBody JobCreateDTO data) {
		Job createdJob = this.jobService.create(data);
		return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Job>> findAll() {
		List<Job> allJobs = this.jobService.findAll();
		return new ResponseEntity<>(allJobs, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Job> findById(@PathVariable Long id) {
		Optional<Job> maybeJob = this.jobService.findById(id);
		
		if(maybeJob.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Job");
		}
		
		return new ResponseEntity<>(maybeJob.get(), HttpStatus.OK);
	}	
	
	
	
	
}
