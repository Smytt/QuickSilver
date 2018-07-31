package com.quicksilver.quicksilver.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.quicksilver.quicksilver.models.Movie;
import com.quicksilver.quicksilver.models.User;

import java.io.IOException;
import java.util.Set;

public class MovieSerializer extends StdSerializer<Movie> {

    public MovieSerializer() {
        this(null);
    }

    protected MovieSerializer(Class<Movie> t) {
        super(t);
    }

    @Override
    public void serialize(Movie movie, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", movie.getId());
        jsonGenerator.writeStringField("title", movie.getTitle());
        jsonGenerator.writeStringField("summary", movie.getSummary());
        jsonGenerator.writeStringField("poster", movie.getPoster());
        jsonGenerator.writeNumberField("year", movie.getYear());
        jsonGenerator.writeArrayFieldStart("favedBy");
        generateArray(jsonGenerator, movie.getFavedBy());
        jsonGenerator.writeEndArray();
        jsonGenerator.writeArrayFieldStart("inWatchlistOf");
        generateArray(jsonGenerator, movie.getInWatchlistOf());
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }

    private void generateArray(JsonGenerator jsonGenerator, Set<User> collection) throws IOException {
        for (User u : collection) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", u.getId());
            jsonGenerator.writeStringField("username", u.getUsername());
            jsonGenerator.writeEndObject();
        }
    }
}
