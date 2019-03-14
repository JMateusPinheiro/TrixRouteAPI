package br.com.jm.trixRoutes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.jm.trixRoutes.service.LocationService;

@RestController
@CrossOrigin("*")
@RequestMapping("/location")
public class LocationController {

	@Autowired
	private LocationService locationService;
	@GetMapping("/get")
	public ResponseEntity<?> getLocation(@RequestParam String location){
		return ResponseEntity.ok(locationService.getLocation(location));
	}
}
