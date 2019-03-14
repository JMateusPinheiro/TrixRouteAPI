package br.com.jm.trixRoutes.model;


import lombok.Data;

@Data
public class Stop {
	String name;
	Coords coords = new Coords(0.0,0.0);
}
