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
@Produces(APPLICATION_JSON)
public class JsonMessageBodyWriter implements MessageBodyWriter {
    @Inject Jsonb jsonb;

    @Override public boolean isWriteable(Class type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public long getSize(Object o, Class type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(Object o, Class type, Type genericType, Annotation[] annotations, MediaType mediaType,
            MultivaluedMap httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        jsonb.toJson(o, entityStream);
    }
}
