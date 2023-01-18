package io.nology.resourceapi.temp;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Transactional
public class TempService {
	
	@Autowired
	private TempRepository tempRepository;

		
	
	public Temp create(TempCreateDTO data) {
		
		Temp newTemp = new Temp(data.getFirstName(), data.getLastName(), null);
		this.tempRepository.save(newTemp);
		return newTemp;
	}
	
	public List<Temp> findAll() {

		return this.tempRepository.findAll();
			
	}
	
	
	public Optional<Temp> findById(Long id) {
		
	    return this.tempRepository.findById(id);
	}
	
	public Temp update(Long TempId, TempUpdateDTO data) {
        Temp Temp = this.findById(TempId).get();

        if (data.firstName != null) {
            String cleanedFirstName = data.firstName.trim();
            Temp.setFirstName(cleanedFirstName);
        }

        if (data.lastName != null) {
            String cleanedLastName = data.lastName.trim();
            Temp.setLastName(cleanedLastName);
        }

        return this.tempRepository.save(Temp);
    }

}
