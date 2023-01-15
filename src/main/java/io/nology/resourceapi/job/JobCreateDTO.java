package io.nology.resourceapi.job;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class JobCreateDTO {
	
	@NotBlank
	String name;
	
	
	LocalDate startDate;
	
	LocalDate endDate;
	
	@Min(1)
	Long tempId;
	
	
	 public JobCreateDTO(
			    @NotBlank String name,
			   LocalDate startDate,
			    LocalDate endDate,
			    @Min(1) Long tempId
			  ) {
			    this.name = name;
			    this.startDate = startDate;
			    this.endDate = endDate;
			    this.tempId = tempId;
			  }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public Long getTempId() {
		return tempId;
	}


	public void setTempId(Long tempId) {
		this.tempId = tempId;
	}
	
	
	

}
