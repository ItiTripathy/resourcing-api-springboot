package io.nology.resourceapi.temp;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temps")
public class TempController {
	
	@Autowired
	private TempService tempService;
	
	
	
	@PostMapping
	public ResponseEntity<Temp> create(@Valid @RequestBody TempCreateDTO data) {
		
		Temp createdTemp = this.tempService.create(data);
		return new ResponseEntity<>(createdTemp, HttpStatus.CREATED);
	}
	
	@GetMapping 
	public ResponseEntity<List<Temp>> findAll() {
			List<Temp> allTemps = this.tempService.findAll();
			return new ResponseEntity<>(allTemps, HttpStatus.OK);
	}
	
	
}
