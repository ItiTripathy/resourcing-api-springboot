package io.nology.resourceapi.job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
	/*
	 * @Query("SELECT j FROM Job j WHERE j.temp = null") List<Job>
	 * findAllUnassigned();
	 * 
	 * @Query("SELECT j FROM Job j WHERE j.temp <> null") List<Job>
	 * findAllAssigned();
	 */
	}
