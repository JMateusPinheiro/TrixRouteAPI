package br.com.jm.trixRoutes.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.maps.model.LatLng;

import lombok.Data;

@Data
@Document
public class Route {
	@Id
	String id;
	String name;
	Stop origin;
	Stop destination;
	LocalDate date = LocalDate.now()	;
	List<Stop> stops;
	List<LatLng> path;
}
