package com.github.t1.yassonjaxrs.test;

import javax.json.bind.serializer.*;
import javax.json.stream.JsonGenerator;

public class BarSerializer implements JsonbSerializer<Bar> {
    @Override public void serialize(Bar obj, JsonGenerator generator, SerializationContext ctx) {
        generator.writeStartObject().write(obj.getKey(), obj.getValue()).writeEnd();
    }
}
