package com.cinemille.gestionale.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinemille.gestionale.bean.FilmListBean;
import com.cinemille.gestionale.service.FilmService;

@RestController
@RequestMapping("/v1/film")
public class FilmController {

	Logger logger = LoggerFactory.getLogger(FilmController.class);

	@Autowired
	FilmService filmService;

	@GetMapping(value = "/")
	public ResponseEntity<?> getAllFilms() {

		try {
			
			FilmListBean filmListBean = filmService.getAllFilms();
			return ResponseEntity.ok(filmListBean);

		} catch (Exception ex) {

			logger.error(ex.getMessage(), ex);
			return ResponseEntity.internalServerError().build();

		}

	}

}
