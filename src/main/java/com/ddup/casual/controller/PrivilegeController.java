package com.ddup.casual.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ddup.casual.dto.req.PrivilegeReq;
import com.ddup.casual.dto.req.PrivilegeReq.QueryList;

@RestController
@RequestMapping(value = "/pri", produces = "application/json;charset=UTF-8", method = { RequestMethod.GET,
		RequestMethod.PUT })
public class PrivilegeController {
	
	@RequestMapping(value = "/list")
    public String queryList(@Validated(QueryList.class) PrivilegeReq dtoReq, Errors errors){
		
		return null;
	}
}
