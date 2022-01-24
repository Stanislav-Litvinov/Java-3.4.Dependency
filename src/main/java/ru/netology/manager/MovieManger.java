package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.Movie;

@Data

public class MovieManger {
    private Movie[] movies = new Movie[0];
    private int defaultMovieLength = 10;

    MovieManger() {
    }

    public MovieManger(int userLength) {
        if (userLength > 0) {
            defaultMovieLength = userLength;
        }

    }

    public void addMovie(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] getLastAdd() {
        int moviesLength = movies.length;
        if (moviesLength < defaultMovieLength) {
            defaultMovieLength = moviesLength;
        }
        Movie[] result = new Movie[defaultMovieLength];
        for (int i = 0; i < result.length; i++) {
            int index = moviesLength - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

}