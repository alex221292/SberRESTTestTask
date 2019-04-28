package com.altr.sber.web.pojo.build;

import com.altr.sber.web.pojo.response.AbstractResponse;

abstract class AbstractResponseBuilder {
    Object input;
    String status;
    int code;

    AbstractResponseBuilder(Object input, String status, int code) {
        this.input = input;
        this.status = status;
        this.code = code;
    }

    AbstractResponseBuilder(String status, int code) {
        this.status = status;
        this.code = code;
    }

    abstract AbstractResponse build();
}
