package com.driver;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    MovieRepository movieRepository = new MovieRepository();

    public String addMovie(Movie movie){
        if(movie.getName().equals(null)){
            return "Movie name cant be null";
        }
        if(movieRepository.movieAlreadyAdded(movie.getName())){
            return "Movie Already Added";
        }
        movieRepository.addMovie(movie);
        return "Movie Added Successfully";
    }

    public String addDirector(Director director){
        if(director.getName().equals(null)){
            return "Director name cant be null";
        }
        if(movieRepository.directorAlreadyAdded(director.getName())){
            return "Director Already Added";
        }
        movieRepository.addDirector(director);
        return "Director Added Successfully";
    }

    public String addMovieDirectorPair(String movieName, String directorName){
        if(!movieRepository.movieAlreadyAdded(movieName)){
            return "Movie is not in the list, Add Movie First";
        }
        if(!movieRepository.directorAlreadyAdded(directorName)){
            return "Director Movie is not in the list, Add Director First";
        }
        movieRepository.addMovieDirectorPair(movieName,directorName);
        return "Movie and Director pair is added Successfully";
    }

    public Movie getMovieByName(String movieName) {
        List <Movie> movieList = movieRepository.getAllMovies();
        for(Movie movie : movieList){
            if(movie.getName().equals(movieName)){
                return movie;
            }
        }
        return null;
    }

    public Director getDirectorByName(String directorName) {
        List <Director> directorList = movieRepository.getAllDirectors();
        for(Director director : directorList){
            if(director.getName().equals(directorName)){
                return director;
            }
        }
        return null;
    }

    public List<Movie> getMoviesByDirectorName(String directorName) {
        List <Director> directorList = movieRepository.getAllDirectors();
        for(Director director : directorList){
            if(director.getName().equals(directorName)){
                return movieRepository.getMoviesByDirectorName(director);
            }
        }
        return new ArrayList<Movie> ();
    }

    public List<Movie> findAllMovies() {
        List <Movie> movieList = movieRepository.getAllMovies();
        return movieList;
    }

    public void deleteDirectorByName(String directorName) {
        movieRepository.deleteDirectorByName(directorName);
    }

    public void deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
    }
}
