package com.cinemille.gestionale.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cinemille.gestionale.bean.FilmListBean;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

@SpringBootTest
public class FilmTest {

	@Autowired
	private FilmService filmService;

	@Test
	void testFilmSevice() throws StreamReadException, DatabindException, IOException {
		FilmListBean allFilms = filmService.getAllFilms();
		assertNotNull(allFilms);
		assertFalse(allFilms.getMovies().isEmpty());
	}

}
