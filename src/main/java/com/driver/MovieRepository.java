package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieRepository {

    HashMap<String,Movie> movieMap = new HashMap<>();

    HashMap<String,Director> directorMap = new HashMap<>();

    HashMap<Director, List<Movie>> pairMap = new HashMap<>();

    public void addMovie(Movie movie){
        String key = movie.getName();
        movieMap.put(key,movie);
    }

    public boolean movieAlreadyAdded (String movieName){
        if(movieMap.containsKey(movieName)){
            return true;
        }
        return false;
    }

    public void addDirector(Director director){
        String key = director.getName();
        directorMap.put(key,director);
    }

    public boolean directorAlreadyAdded(String directorName){
        if(directorMap.containsKey(directorName)){
            return true;
        }
        return false;
    }

    public void addMovieDirectorPair(String movieName, String directorName){
        Movie movie = movieMap.get(movieName);
        Director director = directorMap.get(directorName);
        if(pairMap.containsKey(director)){
            List <Movie> tempList = pairMap.get(director);
            if(tempList.contains(movie)){
                return;
            }
            tempList.add(movie);
            pairMap.put(director,tempList);
        }
        else{
            List <Movie> tempList = new ArrayList<>();
            tempList.add(movie);
            pairMap.put(director,tempList);
        }
    }

    public List<Movie> getAllMovies(){

        return movieMap.values().stream().toList();
    }

    public List<Director> getAllDirectors(){
        return directorMap.values().stream().toList();
    }

    public List<Movie>  getMoviesByDirectorName(Director director){
        if(pairMap.containsKey(director)){
            return pairMap.get(director);
        }
        return new ArrayList <> ();
    }


    public void deleteDirectorByName(String directorName) {
        Director director = directorMap.get(directorName);
        directorMap.remove(directorName);
        List<Movie> movies = pairMap.get(director);
        pairMap.remove(director);
        for(Movie movie : movies){
            movieMap.remove(movie.getName());
        }
    }

    public void deleteAllDirectors() {
        for(String directorName : directorMap.keySet()){
            Director director = directorMap.get(directorName);
            directorMap.remove(directorName);
            List<Movie> movies = pairMap.get(director);
            pairMap.remove(director);
            for(Movie movie : movies){
                movieMap.remove(movie.getName());
            }
        }
    }
}
