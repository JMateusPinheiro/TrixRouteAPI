package br.com.jm.trixRoutes.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jm.trixRoutes.service.PathService;

@RestController
@CrossOrigin("*")
@RequestMapping("/path")
public class PathController {
	
	@Autowired
	private PathService pathService; 
	
	
	@GetMapping("/get")	
	@ResponseBody
	public ResponseEntity<?> getPath(@RequestParam String origin, @RequestParam String destination, @RequestParam String waypoints){
		return ResponseEntity.ok(pathService.getPath(origin, destination, waypoints));
	}
}
