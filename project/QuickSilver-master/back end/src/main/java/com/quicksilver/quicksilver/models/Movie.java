package com.quicksilver.quicksilver.models;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.quicksilver.quicksilver.serializers.MovieSerializer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movies")
@JsonSerialize(using = MovieSerializer.class)
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "favorites",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> favedBy;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "watchlist",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> inWatchlistOf;

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

    public Set<User> getFavedBy() {
        return favedBy;
    }

    public void setFavedBy(Set<User> favedBy) {
        this.favedBy = favedBy;
    }

    public Set<User> getInWatchlistOf() {
        return inWatchlistOf;
    }

    public void setInWatchlistOf(Set<User> inWatchlistOf) {
        this.inWatchlistOf = inWatchlistOf;
    }
}
