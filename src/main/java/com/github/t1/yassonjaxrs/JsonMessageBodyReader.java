package com.github.t1.yassonjaxrs;

import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import static javax.ws.rs.core.MediaType.*;

@Provider
@Consumes(APPLICATION_JSON)
public class JsonMessageBodyReader implements MessageBodyReader<Object> {
    @Inject Jsonb jsonb;

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public Object readFrom(Class<Object> type, Type genericType, Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
            throws IOException, WebApplicationException {
        return jsonb.fromJson(entityStream, genericType);
    }
}
