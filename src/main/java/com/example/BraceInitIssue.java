package com.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

class BraceInitIssue {
    void foo(Object dummyReq) throws Exception {
        var paramRequestString = new ObjectMapper() {{
            setSerializationInclusion(JsonInclude.Include.NON_ABSENT);
        }}.writeValueAsString(dummyReq);
    }
}