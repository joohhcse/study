package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    // HTML <Form>
    // ajax 검색 (에 사용)
    // http post body -> data
    // json, xml, multiport-form / text-plain

    @PostMapping(value = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam) {

        return searchParam;
    }

    @PutMapping("/putMethod")
    public void put() {

    }

    @PatchMapping("/patchMethod")
    public void patch() {

    }

}
