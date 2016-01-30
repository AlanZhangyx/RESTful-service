package com.ddup.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 基础Controller
 *
 * <br>
 * <strong>Time </strong>: 2015年12月15日<br>
 * <strong>History</strong>：<br>
 * Editor　　　version　　　Time　　　　　Operation　　　　　　　Description<br>
 *
 * @author dznzyx
 * @version : 1.0.0
 */
@Controller
public class BaseController {

    // 请求
    @Autowired
    public HttpServletRequest request;
}
