package com.ddup.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ddup.base.controller.BaseController;

@RestController
@RequestMapping(value = "/user/video", produces="application/json;charset=UTF-8",method = {RequestMethod.GET,RequestMethod.PUT})
public class UserVideoController extends BaseController {

}
