package com.github.t1.yassonjaxrs.test;

import lombok.*;

import javax.json.bind.adapter.JsonbAdapter;

public class FooAdapter implements JsonbAdapter<Foo, FooAdapter.AdaptedFoo> {
    @Override public AdaptedFoo adaptToJson(Foo obj) { return new AdaptedFoo(obj.getFoo(), obj.getBar()); }

    @Override public Foo adaptFromJson(AdaptedFoo obj) { return new Foo(obj.a, obj.b); }

    @Data
    @AllArgsConstructor
    public static class AdaptedFoo {
        public String a, b;
    }
}
