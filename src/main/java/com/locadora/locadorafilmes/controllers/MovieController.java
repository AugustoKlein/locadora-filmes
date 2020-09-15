package com.locadora.locadorafilmes.controllers;

import com.locadora.locadorafilmes.model.User;
import com.locadora.locadorafilmes.model.Movie;
import com.locadora.locadorafilmes.security.UserPrincipal;
import com.locadora.locadorafilmes.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/movies")
@CrossOrigin
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(path = "/find/available", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> findAvailableMovies(){
        return movieService.getAvailableMovies();
    }

    @GetMapping(path = "/find/title/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> findByTitle(@PathVariable("title") String title){
        return movieService.searchByTitle(title);
    }

    @PutMapping(path = "/return/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void returnMovie(@PathVariable("id") Long id){
        movieService.returnMovie(id);
    }

    @PutMapping(path = "/allocate/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie allocateMovie(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("id") Long movieId){
        return movieService.allocateMovie(movieId,userPrincipal.getUsername());
    }


}
