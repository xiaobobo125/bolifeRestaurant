package com.bolife.res.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bolife.res.entity.Goods;
import com.bolife.res.entity.GoodsType;
import com.bolife.res.servicce.GoodsService;
import com.bolife.res.servicce.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/26 10:42
 * @Description:
 */
@Controller
public class GoodsInfoController {

    @Autowired(required = false)
    private GoodsService goodsService;

    @Autowired(required = false)
    private GoodsTypeService goodsTypeService;

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

    @ResponseBody
    @RequestMapping("/foodadmin/getGoodType")
    private Map<String,Object> getGoodType(){
        JSONObject jsonObject = new JSONObject();
        List<GoodsType> allGoodsType = goodsTypeService.getAllGoodsType();
        jsonObject.put("goodstypes",allGoodsType);
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping("/foodadmin/addGoodType")
    private Map<String,Object> addGOodType(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String newtypename = request.getParameter("newtypename");
        String gtid = request.getParameter("gtid");
        goodsTypeService.addType(newtypename,gtid);
        jsonObject.put("ok",123);
        return jsonObject;
    }
    @ResponseBody
    @RequestMapping("/foodadmin/addGoods")
    private Map<String,Object> addGoods(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String foodinfo = request.getParameter("foodinfo");
        Goods goods = JSONArray.parseObject(foodinfo, Goods.class);
        goods.setGState(1);
        goods.setGId(UUID.randomUUID().toString());
        goods.setGCount(0);
        System.out.println(goods);
        goodsService.insert(goods);
        jsonObject.put("code",200);
        return jsonObject;
    }
    @ResponseBody
    @RequestMapping("/foodadmin/alert")
    private Map<String,Object> alert(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String foodinfo = request.getParameter("foodinfo");
        Goods goods = JSONArray.parseObject(foodinfo, Goods.class);
        System.out.println(goods);
        goodsService.update(goods);
        jsonObject.put("code",200);
        return jsonObject;
    }
    @ResponseBody
    @RequestMapping("/foodadmin/uninstall")
    private Map<String,Object> uninstall(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String goodId = request.getParameter("foodinfo");
        Goods goodsById = goodsService.getGoodsById(goodId);
        goodsById.setGState(-1);
        System.out.println(goodsById);
        goodsService.update(goodsById);
        jsonObject.put("code",200);
        return jsonObject;
    }


}
