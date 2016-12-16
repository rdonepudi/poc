package com.osi.urm.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osi.urm.service.OsiFunctionOperationService;
import com.osi.urm.service.dto.OsiFunctionOperationDTO;

@RestController
@RequestMapping("/api")
public class OsiFunctionOperationResource {
	
	@Autowired
	private OsiFunctionOperationService osiFunctionOperationService;
	
	@GetMapping("/osi-functions-operations/{id}")
	public ResponseEntity<List<OsiFunctionOperationDTO>> getOsiFunction(@PathVariable Long id) {
		List<OsiFunctionOperationDTO> osiFunctionOperationDTOs = null;
		try {
			osiFunctionOperationDTOs = osiFunctionOperationService.findOne(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<OsiFunctionOperationDTO>>(osiFunctionOperationDTOs, HttpStatus.OK);
	}

}
