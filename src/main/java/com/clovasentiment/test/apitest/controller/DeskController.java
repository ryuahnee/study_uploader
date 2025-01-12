package com.clovasentiment.test.apitest.controller;

import com.clovasentiment.test.apitest.dto.RestResponse;
import com.clovasentiment.test.apitest.entity.DeskEntity;
import com.clovasentiment.test.apitest.service.DeskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeskController {

    private final DeskService deskService;
    RestResponse<Object> restResponse = new RestResponse<>();

    public DeskController(DeskService deskService) {
        this.deskService = deskService;
    }

    @ResponseBody
    @GetMapping("/search-desk")
    public ResponseEntity deskSearch(@RequestParam("member-number") int memberNumber){
        DeskEntity desks =  deskService.selectByMember((long) memberNumber);
        restResponse = RestResponse.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message(memberNumber + "의 desk조회")
                .data(desks)
                .build();
        return new ResponseEntity<>(restResponse, restResponse.getHttpStatus());
    }
}
