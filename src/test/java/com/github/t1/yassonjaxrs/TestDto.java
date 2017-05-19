package com.github.t1.yassonjaxrs;

import lombok.Data;

import javax.json.bind.annotation.JsonbProperty;

@Data
public class TestDto {
    @JsonbProperty("eins")
    private String one;
    @JsonbProperty("zwei")
    private int two;
}
