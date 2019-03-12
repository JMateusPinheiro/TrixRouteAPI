package br.com.jm.trixRoutes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.jm.trixRoutes.model.Route;

@Repository
public interface RouteRepository extends MongoRepository<Route, String> {
	
}
