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
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String ans = movieService.addMovie(movie);
        return new ResponseEntity <>(ans, HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        String ans = movieService.addDirector(director);
        return new ResponseEntity <>(ans, HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName") String movieName, @RequestParam("directorName") String directorName){
        String ans =  movieService.addMovieDirectorPair(movieName, directorName);
        return new ResponseEntity <>(ans, HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{movieName}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String movieName){
        Movie ans = movieService.getMovieByName(movieName);
        return new ResponseEntity <>(ans, HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{directorName}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String directorName){
        Director ans = movieService.getDirectorByName(directorName);
        return new ResponseEntity <>(ans, HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{directorName}")
    public ResponseEntity<List<Movie>> getMoviesByDirectorName(@PathVariable String directorName){
        //return new ArrayList <Movie>();
        List<Movie> ans = movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity <>(ans, HttpStatus.CREATED);
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
