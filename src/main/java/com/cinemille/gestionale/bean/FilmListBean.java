package com.cinemille.gestionale.bean;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FilmListBean {
	
	List<String> genres;
	List<FilmBean> movies;

}
