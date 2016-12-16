package com.osi.urm.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osi.urm.domain.OsiRespUser;
import com.osi.urm.domain.OsiUser;
import com.osi.urm.service.OsiRespUserService;
import com.osi.urm.service.OsiUserService;
import com.osi.urm.service.dto.OsiUserDTO;

/**
 * REST controller for managing OsiUser.
 */
@RestController
@RequestMapping("/api")
public class OsiRespUserResource {

	private final Logger log = LoggerFactory.getLogger(OsiRespUserResource.class);

	@Autowired
	private OsiRespUserService osiRespUserService;

	/**
	 * POST /osi-users : Create a new osiUser.
	 *
	 * @param osiUser
	 *            the OsiUser to create
	 * @return the ResponseEntity with status 201 (Created) and with body the
	 *         new OsiUser, or with status 400 (Bad Request) if the osiUser has
	 *         already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	/*
	 * @PostMapping("/osi-resp-users") public ResponseEntity<OsiRespUser>
	 * createOsiRespUser(@Valid @RequestBody OsiRespUser osiRespUser) throws
	 * URISyntaxException { if (osiRespUser.getId() != null) { return
	 * ResponseEntity.badRequest() .body(null); }
	 * 
	 * OsiRespUser result = osiRespUserService.save(osiRespUser);
	 * 
	 * return ResponseEntity.created(new URI("/api/osi-resp-users/" +
	 * result.getId())) .body(result); }
	 */

	@PostMapping("/osi-resp-users")
	public ResponseEntity<List<OsiRespUser>> createOsiRespUser(@Valid @RequestBody List<OsiRespUser> osiRespUser)
			throws URISyntaxException {
		List<OsiRespUser> resultSet = new ArrayList<>();
		for (OsiRespUser resp : osiRespUser) {
			if (resp.getId() != null) {
				return ResponseEntity.badRequest().body(null);
			}

			OsiRespUser result = osiRespUserService.save(resp);
			resultSet.add(result);
		}
		
		return ResponseEntity.created(new URI("/api/osi-resp-users")).body(resultSet);
	}
}
