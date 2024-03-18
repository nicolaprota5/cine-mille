package com.cinemille.gestionale.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmBean {

	private int id;
	private String title;
	private String year;
	private String runtime;
	private List<String> genres;
	private String director;
	private String actors;
	private String plot;
	private String posterUrl;
	private String dataInizioProgrammazione;
	private String dataFineProgrammazione;

}
