package br.com.jm.trixRoutes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
	@ResponseBody
	public ResponseEntity<?> home() {
		return ResponseEntity.ok("Server Funcionando");
	}
}
