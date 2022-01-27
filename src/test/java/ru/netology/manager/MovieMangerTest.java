package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieMangerTest {

    private final Movie first = new Movie(1, "http://", "Spider-Man: No Way Home", "Adventure");
    private final Movie second = new Movie(2, "http://", "No Time To Die", "Thriller");
    private final Movie third = new Movie(3, "http://", "Shang-Chi And The Legend Of The Ten Rings", "Fantasy");
    private final Movie fourth = new Movie(4, "http://", "The Father", "Drama");
    private final Movie fifth = new Movie(5, "http://", "Dune", "Adventure");
    private final Movie sixth = new Movie(6, "http://", "ШеA Quiet Place: Part II", "Thriller");
    private final Movie seventh = new Movie(7, "http://", "Palm Springs", "Mystery");
    private final Movie eighth = new Movie(8, "http://", "The Suicide Squad", "Adventure");
    private final Movie ninth = new Movie(9, "http://", "Free Guy", "Comedy");
    private final Movie tenth = new Movie(10, "http://", "Cruella", "Crime");

    Movie[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

    @Test
    void shouldShowLast10Movies() {
        MovieManger manger = new MovieManger(10);
        manger.addMovie(first);
        manger.addMovie(second);
        manger.addMovie(third);
        manger.addMovie(fourth);
        manger.addMovie(fifth);
        manger.addMovie(sixth);
        manger.addMovie(seventh);
        manger.addMovie(eighth);
        manger.addMovie(ninth);
        manger.addMovie(tenth);
        Movie[] actual = manger.getLastAdd();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowCustomMovieLength() {
        MovieManger manger = new MovieManger(5);
        manger.addMovie(first);
        manger.addMovie(second);
        manger.addMovie(third);
        manger.addMovie(fourth);
        manger.addMovie(fifth);
        Movie[] expected = {fifth, fourth, third, second, first};
        Movie[] actual = manger.getLastAdd();
        assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowNothing() {
        MovieManger manger = new MovieManger();
        Movie[] actual = manger.getLastAdd();
        Movie[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowValid() {
        MovieManger manager = new MovieManger(5);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        Movie movieToAdd = new Movie(11, "Minari", "http://", "Drama");
        manager.addMovie(movieToAdd);
        Movie[] actual = manager.getLastAdd();
        Movie[] expected = {new Movie(11, "Minari", "http://", "Drama"), tenth, ninth, eighth, seventh};
        assertArrayEquals(expected, actual);

    }

    @Test
    void mustShowOverMax() {
        MovieManger manager = new MovieManger(11);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        Movie[] actual = manager.getLastAdd();
        assertArrayEquals(expected, actual);

    }
}