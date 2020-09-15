package com.locadora.locadorafilmes.services.impl;

import com.locadora.locadorafilmes.exception.CustomGenericException;
import com.locadora.locadorafilmes.model.Movie;
import com.locadora.locadorafilmes.model.User;
import com.locadora.locadorafilmes.repositories.MovieRepository;
import com.locadora.locadorafilmes.repositories.UserRepository;
import com.locadora.locadorafilmes.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Movie> getAvailableMovies() {
        return movieRepository.findAllAvailableMovies();
    }

    @Override
    public List<Movie> searchByTitle(String title) {
        return movieRepository.findAllByTitle(title);
    }

    @Override
    public void returnMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                                     .orElseThrow(() -> {throw new CustomGenericException("There's no movie with the id given!");});

        movie.setUser(null);

        movieRepository.save(movie);
    }

    @Override
    public Movie allocateMovie(Long movieId, String userEmail) {
        User user = userRepository.findByEmail(userEmail);

        Movie movie = movieRepository.findById(movieId)
                                     .orElseThrow(() -> {throw new CustomGenericException("There's no movie with the id given!");});

        if(movie.getUser() != null)
            throw new CustomGenericException("This movie is already allocated!");

        movie.setUser(user);

        return movieRepository.save(movie);
    }


}
