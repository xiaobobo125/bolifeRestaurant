package com.bolife.res.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bolife.res.entity.*;
import com.bolife.res.servicce.CusOrderService;
import com.bolife.res.servicce.OrderDetailService;
import com.bolife.res.servicce.OverOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 13:29
 * @Description:
 */
@Controller
public class OrderController {
    @Autowired(required = false)
    private OverOrderService overOrderService;

    @Autowired(required = false)
    private CusOrderService cusOrderService;

    @Autowired(required = false)
    private OrderDetailService orderDetailService;

    @ResponseBody
    @RequestMapping(value = "/order/getOrders",method = RequestMethod.GET)
    public Map<String,Object> getOrders(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        Map<String, String[]> parameterMap = request.getParameterMap();
        if(parameterMap == null){
            return null;
        }
        String[] cusids = parameterMap.get("cusid");
        //查询该用户已完成的订单
        List<OverOrder> overOrderList = overOrderService.getOverOrderByCusId(cusids[0]);
        //查询用户未完成的订单
        Customer customer = new Customer();
        customer.setCusId(cusids[0]);
        List<CusOrders> cusOrders = cusOrderService.getOrderByCus(customer);
        Integer totalTime = 0;
        List<List<OrderDetail>> allOrderDetail = new ArrayList<>();
        for(int i = 0;i<cusOrders.size();i++){
            totalTime+=cusOrders.get(i).getOrderTime();
            cusOrders.get(i).setOrderSort(i+1);
            cusOrders.get(i).setOrderTime(totalTime);
            List<OrderDetail> orderDetailByOId = orderDetailService.getOrderDetailByOId(cusOrders.get(i).getOrderId());
            allOrderDetail.add(orderDetailByOId);
        }
        jsonObject.put("overOrder",overOrderList);
        jsonObject.put("order",cusOrders);
        jsonObject.put("orderDetailAll",allOrderDetail);
//        System.out.println(allOrderDetail.get(0).get(0));
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public Map<String,Object> payOrder(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String foodlist = request.getParameter("foodlist");
        String cusid = request.getParameter("cusid");
        List<Goods> goods = JSONArray.parseArray(foodlist, Goods.class);
        CusOrders cusOrders = cusOrderService.saveOrder(goods, cusid);
        orderDetailService.save(goods,cusOrders);
        return  jsonObject;
    }

    @ResponseBody
    @RequestMapping(value = "/order/getOrderAdmin",method = RequestMethod.GET)
    public Map<String,Object> getOrderAdmin(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        List<CusOrders> allOrder = cusOrderService.getAllOrder();
        jsonObject.put("cusOrderArr",allOrder);
        return  jsonObject;
    }

    @ResponseBody
    @RequestMapping(value = "/order/orderAdminCancel",method = RequestMethod.GET)
    public Map<String,Object> orderAdminCancel(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String orderid = request.getParameter("orderid");
        cusOrderService.deleteOrder(orderid);
        jsonObject.put("code",200);
        jsonObject.put("msg","订单取消成功");
        return  jsonObject;
    }
    @ResponseBody
    @RequestMapping(value = "/order/orderAdminOver",method = RequestMethod.GET)
    public Map<String,Object> orderAdminOver(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String orderid = request.getParameter("orderid");
        CusOrders cusOrders = cusOrderService.getORderByOrderId(orderid);
        overOrderService.insertOrder(cusOrders);
        cusOrderService.deleteOrder(orderid);
        jsonObject.put("code",200);
        jsonObject.put("msg","订单已完成！");
        return  jsonObject;
    }
}
