package com.github.t1.yassonjaxrs;

import lombok.extern.slf4j.Slf4j;

import javax.enterprise.inject.*;
import javax.inject.Inject;
import javax.json.bind.*;
import javax.json.bind.adapter.JsonbAdapter;
import java.util.*;

@Slf4j
public class JsonbProducer {
    @Inject Instance<JsonbConfig> configs;
    @Inject Instance<JsonbAdapter<?, ?>> adapters;

    @Produces Jsonb jsonb() {
        JsonbConfig config = configs.isUnsatisfied() ? new JsonbConfig() : configs.get();
        return JsonbBuilder.create(config.withAdapters(adapters()));
    }

    private JsonbAdapter[] adapters() {
        List<JsonbAdapter<?, ?>> list = new ArrayList<>();
        for (JsonbAdapter adapter : adapters)
            list.add(adapter);
        return list.toArray(new JsonbAdapter[list.size()]);
    }
}
