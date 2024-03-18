package com.cinemille.gestionale.service;

import java.io.IOException;

import com.cinemille.gestionale.bean.FilmListBean;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

public interface FilmService {

	FilmListBean getAllFilms() throws StreamReadException, DatabindException, IOException;

}
