package com.github.t1.yassonjaxrs;

import javax.ws.rs.*;

@Path("/")
public class TestBoundary {
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
}
