package com.cinemille.gestionale.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.cinemille.gestionale.bean.FilmListBean;
import com.cinemille.gestionale.service.FilmService;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FilmServiceImpl implements FilmService {

	@Override
	public FilmListBean getAllFilms() throws StreamReadException, DatabindException, IOException {

		File file = new File(getClass().getClassLoader().getResource("json/film_list.json").getFile());
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(file, FilmListBean.class);
		
		 
	}

}
