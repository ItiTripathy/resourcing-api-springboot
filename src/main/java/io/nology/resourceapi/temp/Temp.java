package io.nology.resourceapi.temp;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.nology.resourceapi.job.Job;

@Entity
public class Temp {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  Long id;

	  @Column
	  String firstName;

	  @Column
	  String lastName;
	  
	  @OneToMany(
			    mappedBy = "temp",
			    fetch = FetchType.EAGER,
			    cascade = CascadeType.ALL
			  )
	  @JsonIgnoreProperties("temp")
	  Set<Job> jobs;
	  
	  public Temp() {}
	  
	  public Temp(String firstName, String lastName, Set<Job> jobs) {
		  this.firstName = firstName;
		  this.lastName = lastName;
		  this.jobs = jobs;
	  }
	  
	  

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Job> getJobs() {
		return jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}
	  
	public boolean isAvailableOnSpecificedDate(LocalDate specifiedDate) {
	    if (this.jobs.isEmpty()) return true;

	    return !(
	      this.jobs.stream()
	        .anyMatch(
	          job ->
	            job.getEndDate().isAfter(specifiedDate) ||
	            job.getEndDate().isEqual(specifiedDate)
	        )
	    );
	}

}
