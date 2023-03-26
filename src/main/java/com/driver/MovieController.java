package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    MovieService movieService = new MovieService();

    @PostMapping("/add-movie")
    public String addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    @PostMapping("/add-director")
    public String addDirector(@RequestBody Director director){
        return movieService.addDirector(director);
    }

    @PutMapping("/add-movie-director-pair")
    public String addMovieDirectorPair(@RequestParam("movieName") String movieName, @RequestParam("directorName") String directorName){
        return movieService.addMovieDirectorPair(movieName, directorName);
    }

    @GetMapping("/get-movie-by-name/{movieName}")
    public Movie getMovieByName(@PathVariable String movieName){
        return movieService.getMovieByName(movieName);
    }

    @GetMapping("/get-director-by-name/{directorName}")
    public Director getDirectorByName(@PathVariable String directorName){
        return movieService.getDirectorByName(directorName);
    }

    @GetMapping("/get-movies-by-director-name/{directorName}")
    public List<Movie> getMoviesByDirectorName(@PathVariable String directorName){
        //return new ArrayList <Movie>();
        return movieService.getMoviesByDirectorName(directorName);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){
        List <Movie> ans = movieService.findAllMovies();
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("directorName") String directorName){
        movieService.deleteDirectorByName(directorName);
        return new ResponseEntity <>("Deleted Successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity <>("Deleted Successfully", HttpStatus.CREATED);
    }
}
