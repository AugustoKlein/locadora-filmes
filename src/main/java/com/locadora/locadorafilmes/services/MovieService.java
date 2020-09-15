package com.locadora.locadorafilmes.services;

import com.locadora.locadorafilmes.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    public List<Movie> getAvailableMovies();

    public List<Movie> searchByTitle(String title);

    public void returnMovie(Long id);

    public Movie allocateMovie(Long movieId, String userEmail);


}
