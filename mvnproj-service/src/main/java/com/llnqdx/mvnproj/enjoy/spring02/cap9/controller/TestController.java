package com.llnqdx.mvnproj.enjoy.spring02.cap9.controller;

import com.llnqdx.mvnproj.enjoy.spring02.cap9.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {
    @Autowired
    private TestService testService;
}
