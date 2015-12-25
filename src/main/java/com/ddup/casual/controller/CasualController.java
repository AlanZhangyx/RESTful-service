package com.ddup.casual.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ddup.base.controller.BaseController;
import com.ddup.base.dto.resp.BaseResp;
import com.ddup.casual.dto.req.PrivilegeReq;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping(value = "/casual", produces="application/json;charset=UTF-8", method = {RequestMethod.GET,RequestMethod.PUT})
public class CasualController extends BaseController {

	
    @RequestMapping(value = "/privilege/list")
    public String list(@Valid PrivilegeReq dtoReq, Errors errors){
        //1 数据校验
        if (errors.hasErrors()) {
            List<ObjectError> list = errors.getAllErrors();
            JSONArray errorArray = new JSONArray();
            JSONObject tempJson = null;
            FieldError fieldError = null;
            for (ObjectError objectError : list) {
                fieldError = (FieldError)objectError;
                tempJson = new JSONObject();
                tempJson.put("field", fieldError.getField());
                tempJson.put("errorMsg", fieldError.getDefaultMessage());
                errorArray.add(tempJson);
            }
            //错误
            BaseResp resp = new BaseResp();
            resp.setServer_status(BaseResp.STATUS_ERROR_VALIDATE);
            resp.setServer_error(errorArray.toString());
            return JSONObject.fromObject(resp).toString();
        }
        //2 操作
        Map<String,Object> map = new HashMap<String, Object>();
        /*map.put("userCode", dtoReq.getUserCode());
        map.put("geoLevel", dtoReq.getGeoLevel());
        return homePageService.getUserHomePage(map);*/
        return null;
    }  
}
