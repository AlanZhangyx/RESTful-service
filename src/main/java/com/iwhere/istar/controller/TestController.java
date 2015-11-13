package com.iwhere.istar.controller;

import com.iwhere.base.controller.BaseController;
import com.iwhere.lib.exception.IWException;
import com.iwhere.istar.dto.req.TestReq;
import com.iwhere.istar.dto.resp.TestListDetailResp;
import com.iwhere.istar.dto.resp.TestResp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

import java.util.ArrayList;

/**
 * 测试Controller
 * <p/>
 * <br>
 * <strong>copyright</strong>： 2015, 成都都在哪网讯科技有限公司<br>
 * <strong>Time </strong>: 2015/10/28 13:50<br>
 * <strong>History</strong>：<br>
 * Editor　　　version　　　Time　　　　　Operation　　　　　　　Description<br>
 *
 * @author hewei
 * @version : 1.0.0
 */
@Controller
@RequestMapping("iaddress/test")
public class TestController extends BaseController {

    /**
     * 测试获取普通返回
     *
     * @param req 请求参数
     * @return
     * @author hewei
     */
    @RequestMapping("getJsonResp")
    public
    @ResponseBody
    TestResp getJsonResp(TestReq req) {
        TestResp resp = new TestResp();
        resp.setAddressId(req.getAddressId());

        ArrayList<TestListDetailResp> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TestListDetailResp detailResp = new TestListDetailResp();
            detailResp.setPhotoId(Long.valueOf(i));

            list.add(detailResp);
        }

        resp.setList(list);
        return resp;
    }

    /**
     * 测试后台验证
     *
     * @param req 请求参数
     * @return
     */
    @RequestMapping("getValiResp")
    public
    @ResponseBody
    TestResp getValiResp(@Valid TestReq req) {
        return null;
    }

    /**
     * 测试业务异常
     *
     * @return
     */
    @RequestMapping("getYwException")
    public
    @ResponseBody
    TestResp getYwException() {
        throw new IWException(5001, "业务异常！");
    }

    /**
     * 测试国际化
     *
     * @param req 请求参数
     * @return
     */
    @RequestMapping("getI18n")
    public
    @ResponseBody
    TestResp getI18n(@Valid TestReq req) {
        return null;
    }

    /**
     * 测试国际化内部调用
     *
     * @return
     */
    @RequestMapping("getI18n00")
    public
    @ResponseBody
    TestResp getI18n00() {
        // 国际化异常信息
        throw new IWException("error.iaddress.test.ex.test");
    }
}
