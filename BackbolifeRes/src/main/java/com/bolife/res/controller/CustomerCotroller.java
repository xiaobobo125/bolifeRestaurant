package com.bolife.res.controller;

import com.alibaba.fastjson.JSONObject;
import com.bolife.res.util.HttpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/24 16:48
 * @Description:
 */
@Controller
@RequestMapping("/customer")
public class CustomerCotroller {

    @RequestMapping("/getopenid")
    private Map<String,Object> getOpenId(HttpServletResponse response, HttpServletRequest request,Map<String,Object> data){
        JSONObject jsonObject = new JSONObject();
        Map<String, String[]> parameterMap = request.getParameterMap();
        if(parameterMap == null){
            return null;
        }
        String[] code = parameterMap.get("code");
        String[] appid = parameterMap.get("appid");
        String secret = "497897a95225df460d8d3dd99befaba7";
        String wx_url = "https://api.weixin.qq.com/sns/jscode2session?appid="+ appid[0] +"&secret=" + secret + "&js_code="+ code[0] + "&grant_type=authorization_code";
        String result = "";
        try {
            result = HttpUtil.doGet(wx_url,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("用户的openid为："+result);
        return  null;
    }
}
