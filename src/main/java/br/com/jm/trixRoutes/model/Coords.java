package br.com.jm.trixRoutes.model;

import lombok.Data;

@Data
public class Coords {
	Double lat;
	Double lng;
	
	public Coords(double d, double e) {
		lat = d;
		lng = e;
	}
}
