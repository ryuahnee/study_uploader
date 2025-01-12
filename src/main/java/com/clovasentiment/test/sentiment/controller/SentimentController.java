package com.clovasentiment.test.sentiment.controller;

import com.clovasentiment.test.sentiment.service.SentmintService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sentiment")
@RequiredArgsConstructor
public class SentimentController {

    private final SentmintService sentmintService;

    @PostMapping("/review")
    public String review(@RequestParam(value="textValue") String textValue) {
        System.out.println("전송된 텍스트 값: " + textValue);
         sentmintService.semtmints(textValue);
        return "go/no";
    }
}
