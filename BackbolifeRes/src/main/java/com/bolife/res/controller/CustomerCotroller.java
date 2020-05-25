package com.bolife.res.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bolife.res.entity.CusOrders;
import com.bolife.res.entity.Customer;
import com.bolife.res.entity.SysCus;
import com.bolife.res.servicce.CusOrderService;
import com.bolife.res.servicce.CustomerService;
import com.bolife.res.servicce.SysCusService;
import com.bolife.res.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/24 16:48
 * @Description:
 */
@Controller
@RequestMapping("/customer")
public class CustomerCotroller {

    @Autowired(required = false)
    private CustomerService customerService;

    @Autowired(required = false)
    private CusOrderService cusOrderService;

    @Autowired(required = false)
    private SysCusService sysCusService;

    @ResponseBody
    @RequestMapping(value = "/getopenid",method = RequestMethod.GET)
    private Map<String, Object> getOpenId(HttpServletResponse response, HttpServletRequest request){
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
        if(result != null){
            JSONObject returnData = JSON.parseObject(result);
//            System.out.println(returnData.get("openid"));
            returnData.put("code",200);
            returnData.put("msg","授权成功");
//            System.out.println(returnData);
            return returnData;
        }
        jsonObject.put("code",-1);
        jsonObject.put("errMsg","授权失败");
        return  jsonObject;
    }

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> login(HttpServletResponse response, HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        Map<String, String[]> parameterMap = request.getParameterMap();
        if(parameterMap == null){
            return null;
        }
        String[] nicknames = parameterMap.get("nickname");
        String[] openids = parameterMap.get("openid");
        Customer loginCust = new Customer();
        loginCust.setOpenId(openids[0]);
        Customer customer = customerService.getCustomer(loginCust);
        //如果用户不存在则注册用户
        if(customer == null){
            loginCust.setCusId(UUID.randomUUID().toString());
            loginCust.setNickName(nicknames[0]);
            customerService.regCustomer(loginCust);
            jsonObject.put("code",200);
            jsonObject.put("msg","成功注册！");
            jsonObject.put("isAdmin",false);
        }else{
            //查询用户是否有未完成订单
            List<CusOrders> orderByCus = cusOrderService.getOrderByCus(customer);
            if(orderByCus != null && orderByCus.size() > 0){
                jsonObject.put("isHaveOrder",true);
            }else{
                jsonObject.put("isHaveOrder",false);
            }
//            System.out.println(orderByCus);
            //查询用户是否是管理员
            SysCus sysCusById = sysCusService.getSysCusById(customer.getCusId());
            if (sysCusById != null){
                jsonObject.put("isAdmin",true);
                jsonObject.put("limit",sysCusById.getLimits());
            }else {
                jsonObject.put("isAdmin",false);
                jsonObject.put("limit",false);
            }
            jsonObject.put("code",200);
            jsonObject.put("msg","已注册");
            jsonObject.put("cusid",customer.getCusId());
        }
        return jsonObject;
    }
}
