package com.quicksilver.quicksilver.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.quicksilver.quicksilver.models.Movie;
import com.quicksilver.quicksilver.models.User;

import java.io.IOException;

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

        for (User f : movie.getFavedBy()) {
            jsonGenerator.writeNumber(f.getId());
        }

        jsonGenerator.writeEndArray();
        jsonGenerator.writeArrayFieldStart("inWatchlistOf");

        for (User w : movie.getInWatchlistOf()) {
            jsonGenerator.writeNumber(w.getId());
        }

        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
