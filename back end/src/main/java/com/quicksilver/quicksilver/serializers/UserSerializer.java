package com.quicksilver.quicksilver.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.quicksilver.quicksilver.models.Movie;
import com.quicksilver.quicksilver.models.User;

import java.io.IOException;

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

        for (Movie f : user.getFavorites()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", f.getId());
            jsonGenerator.writeStringField("title", f.getTitle());
            jsonGenerator.writeStringField("poster", f.getPoster());
            jsonGenerator.writeEndObject();
        }

        jsonGenerator.writeEndArray();
        jsonGenerator.writeArrayFieldStart("watchlist");

        for (Movie w : user.getWatchlist()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", w.getId());
            jsonGenerator.writeStringField("title", w.getTitle());
            jsonGenerator.writeStringField("poster", w.getPoster());
            jsonGenerator.writeEndObject();
        }

        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
