package com.ddup.istar.controller;

import java.util.List;

import javax.validation.Valid;

import net.sf.json.JSONArray;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ddup.base.controller.BaseController;
import com.ddup.istar.dto.req.HomePageReq001;

@RestController
@RequestMapping(produces="application/json;charset=UTF-8",method = {RequestMethod.GET,RequestMethod.PUT})
public class HomePageController extends BaseController {
    
    /**
     * 获取用户主页信息
     * @Title
     * @Description 
     * @param vo
     * @param errors
     * @return
     * @TestUrl
     */
    @RequestMapping(value = "/getUserHomePage")
    public String getUserHomePage(@Valid HomePageReq001 dtoReq, Errors errors){
        //1 数据校验
        if (errors.hasErrors()) {
            List<ObjectError> list = errors.getAllErrors();
            
            JSONArray.fromObject(list);
            
            if (list.size()>0) {
                //return ProcessUtil.error400(list.get(0).getDefaultMessage());
            }
        }
        //2 操作
        return null;
    }    
    
}
