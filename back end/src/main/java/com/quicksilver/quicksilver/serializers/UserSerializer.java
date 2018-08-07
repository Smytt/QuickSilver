package com.quicksilver.quicksilver.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.quicksilver.quicksilver.models.Movie;
import com.quicksilver.quicksilver.models.User;

import java.io.IOException;
import java.util.Set;

public class UserSerializer extends StdSerializer<User> {

    public UserSerializer() {
        this(null);
    }

    protected UserSerializer(Class<User> t) {
        super(t);
    }

    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", user.getId());
        jsonGenerator.writeStringField("username", user.getUsername());
        jsonGenerator.writeArrayFieldStart("favorites");
        generateArray(jsonGenerator, user.getFavorites());
        jsonGenerator.writeEndArray();
        jsonGenerator.writeArrayFieldStart("watchlist");
        generateArray(jsonGenerator, user.getWatchlist());
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }

    private void generateArray(JsonGenerator jsonGenerator, Set<Movie> collection) throws IOException {
        for (Movie m : collection) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", m.getId());
            jsonGenerator.writeStringField("title", m.getTitle());
            jsonGenerator.writeStringField("poster", m.getPoster());
            jsonGenerator.writeStringField("summary", m.getSummary());
            jsonGenerator.writeEndObject();
        }
    }
}
