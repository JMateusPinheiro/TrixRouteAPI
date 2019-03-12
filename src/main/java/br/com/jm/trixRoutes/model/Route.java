package br.com.jm.trixRoutes.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Route {
	@Id
	String id;
	String name;
	LocalDate date;
	List<Stop> stops;
//	List<COORDENADAS> path;
}
