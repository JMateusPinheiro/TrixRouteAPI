package br.com.jm.trixRoutes.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jm.trixRoutes.service.RouteService;

@RestController
@RequestMapping("/route")
public class RouteController {
	
	@Autowired
	private RouteService routeService; 
	
	
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<?> getRoute(@RequestParam String origin, @RequestParam String destination, @RequestParam String waypoints) throws IOException{
		return ResponseEntity.ok(routeService.getRoute(origin, destination, waypoints));
	}
}
