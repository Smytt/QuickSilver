package com.quicksilver.quicksilver.models;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.stream.Stream;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "summary")
    private String summary;

    @Column(name = "poster")
    private String poster;

    @Column(name = "year")
    private int year;

    @ManyToMany
    @JoinTable(
            name = "favorites",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private ArrayList<User> favedBy;

    @ManyToMany
    @JoinTable(
            name = "watchlist",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private ArrayList<User> inWatchlistOf;

    public Movie() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<User> getFavedBy() {
        return favedBy;
    }

    public void setFavedBy(ArrayList<User> favedBy) {
        this.favedBy = favedBy;
    }

    public ArrayList<User> getInWatchlistOf() {
        return inWatchlistOf;
    }

    public void setInWatchlistOf(ArrayList<User> inWatchlistOf) {
        this.inWatchlistOf = inWatchlistOf;
    }
}
