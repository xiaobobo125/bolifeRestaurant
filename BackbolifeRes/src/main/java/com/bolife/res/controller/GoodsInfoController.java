package com.bolife.res.controller;

import com.alibaba.fastjson.JSONObject;
import com.bolife.res.entity.Goods;
import com.bolife.res.servicce.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/26 10:42
 * @Description:
 */
@Controller
public class GoodsInfoController {

    @Autowired(required = false)
    private GoodsService goodsService;

    @ResponseBody
    @RequestMapping("/good")
    public Map<String,Object> getGoodInfo(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        Map<String, String[]> parameterMap = request.getParameterMap();
        if(parameterMap == null){
            return null;
        }
        String[] foods = parameterMap.get("food");
        List<Goods> goodsByGtId = goodsService.getGoodsByGtId(foods[0]);
        if(goodsByGtId.size()>6){
            goodsByGtId = goodsByGtId.subList(0,6);
        }
        if(goodsByGtId == null || goodsByGtId.size() < 3) {
            List<Goods> allGoods = goodsService.getAllGoods();
            if(allGoods.size()>6){
                allGoods = allGoods.subList(0,6);
            }
            jsonObject.put("foodList", allGoods);
        }else{
            jsonObject.put("foodList",goodsByGtId);
        }
        return jsonObject;
    }
}
