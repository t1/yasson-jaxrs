package com.github.t1.yassonjaxrs.test;

import javax.json.bind.serializer.*;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import java.lang.reflect.Type;

import static javax.json.stream.JsonParser.Event.*;

public class BarDeserializer implements JsonbDeserializer<Bar> {
    @Override public Bar deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
        assertNext(parser, KEY_NAME);
        String key = parser.getString();
        assertNext(parser, VALUE_STRING);
        String value = parser.getString();
        return new Bar(key, value);
    }

    private void assertNext(JsonParser parser, Event expected) {
        Event actual = parser.next();
        if (expected != actual)
            throw new IllegalStateException("expected json event " + expected + " but found " + actual);
    }
}
