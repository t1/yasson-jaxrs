package com.github.t1.yassonjaxrs;

import javax.enterprise.inject.Produces;
import javax.json.bind.*;

public class JsonbProducer {
    @Produces Jsonb jsonb = JsonbBuilder.create();
}
