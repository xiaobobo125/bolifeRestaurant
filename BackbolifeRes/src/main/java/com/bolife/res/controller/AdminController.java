package com.bolife.res.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bolife.res.entity.Goods;
import com.bolife.res.entity.GoodsType;
import com.bolife.res.entity.SysCus;
import com.bolife.res.servicce.GoodsService;
import com.bolife.res.servicce.GoodsTypeService;
import com.bolife.res.servicce.SysCusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/24 15:52
 * @Description:
 */
@Controller
public class AdminController {
    @Autowired(required = false)
    private SysCusService sysCusService;

    @Autowired(required = false)
    private GoodsTypeService goodsTypeService;

    @Autowired(required = false)
    private GoodsService goodsService;

    @ResponseBody
    @RequestMapping("/admin")
    public Map<String, Object> getSysCus(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<SysCus> allSysCus = sysCusService.getAllSysCus();
        jsonObject.put("datalist",allSysCus);
        return jsonObject;
    }
    @ResponseBody
    @RequestMapping("/foodadmin")
    public Map<String, Object> getFoods(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<GoodsType> allGoodsType = goodsTypeService.getAllGoodsType();
        for (GoodsType goodsType : allGoodsType) {
            List<Goods> goodsByGtId = goodsService.getGoodsByGtId(goodsType.getGtId());
            goodsType.setGoods(goodsByGtId);
        }
        jsonObject.put("datalist",allGoodsType);
        return jsonObject;
    }
    @ResponseBody
    @RequestMapping("/admin/subtract")
    public Map<String, Object> subtractAdmin(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        String cusid = request.getParameter("cusid");
        sysCusService.delete(cusid);
        List<SysCus> allSysCus = sysCusService.getAllSysCus();
        jsonObject.put("datalist",allSysCus);
        return jsonObject;
    }
    @ResponseBody
    @RequestMapping("/admin/add")
    public Map<String, Object> addAdmin(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        String admin = request.getParameter("admin");
        JSONObject json = JSONArray.parseObject(admin);
        String cusid = (String) json.get("cusid");
        String name = (String) json.get("name");
        sysCusService.insertCus(cusid,name);
        List<SysCus> allSysCus = sysCusService.getAllSysCus();
        jsonObject.put("datalist",allSysCus);
        return jsonObject;
    }
}
