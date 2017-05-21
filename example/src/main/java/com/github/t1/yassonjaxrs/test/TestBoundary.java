package com.github.t1.yassonjaxrs.test;

import javax.json.bind.JsonbConfig;
import javax.ws.rs.*;

@Path("/")
public class TestBoundary {
    @javax.enterprise.inject.Produces JsonbConfig jsonbConfig = new JsonbConfig().withFormatting(true);

    @GET public TestDto get() {
        TestDto dto = new TestDto();
        dto.setOne("uno");
        dto.setTwo(2);
        return dto;
    }

    @POST public TestDto post(TestDto dto) {
        dto.setOne(dto.getOne() + "+");
        dto.setTwo(dto.getTwo() + 1);
        return dto;
    }

    @Path("/foo") @GET public Foo getFoo() {
        return new Foo("foo", "bar");
    }

    @Path("/bar") @POST public Bar postBar(Bar bar) {
        return new Bar(bar.getKey() + "+", bar.getValue() + "-");
    }
}
