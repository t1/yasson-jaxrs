package com.github.t1.yassonjaxrs;

import lombok.extern.slf4j.Slf4j;

import javax.enterprise.inject.*;
import javax.inject.Inject;
import javax.json.bind.*;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.serializer.*;
import java.lang.reflect.Array;
import java.util.stream.StreamSupport;

@Slf4j
public class JsonbProducer {
    @Inject Instance<JsonbConfig> configs;
    @Inject Instance<JsonbAdapter<?, ?>> adapters;
    @Inject Instance<JsonbSerializer<?>> serializers;
    @Inject Instance<JsonbDeserializer<?>> deserializers;

    @Produces Jsonb jsonb() {
        JsonbConfig config = (configs.isUnsatisfied() ? new JsonbConfig() : configs.get())
                .withAdapters(adapters())
                .withSerializers(serializers())
                .withDeserializers(deserializers());
        return JsonbBuilder.create(config);
    }

    private JsonbAdapter[] adapters() {
        return toArray(JsonbAdapter.class, adapters);
    }

    private JsonbSerializer[] serializers() {
        return toArray(JsonbSerializer.class, serializers);
    }

    private JsonbDeserializer[] deserializers() {
        return toArray(JsonbDeserializer.class, deserializers);
    }

    @SuppressWarnings("unchecked") private <T> T[] toArray(Class<T> type, Iterable iterable) {
        return StreamSupport.stream(((Iterable<T>) iterable).spliterator(), false)
                            .toArray(size -> (T[]) Array.newInstance(type, size));
    }
}
