package com.bolife.res.controller;

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

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 15:13
 * @Description:
 */
@Controller
public class MenuController {

    @Autowired(required = false)
    private GoodsTypeService goodsTypeService;

    @Autowired(required = false)
    private GoodsService goodsService;
    @ResponseBody
    @RequestMapping("/menu")
    public Map<String,Object> getMenuInfo(){
        JSONObject jsonObject = new JSONObject();
        List<GoodsType> allGoodsType = goodsTypeService.getAllGoodsType();
        if(allGoodsType != null){
            for(int i = 0 ;i<allGoodsType.size();i++){
                List<Goods> goodsByGtId = goodsService.getGoodsByGtId(allGoodsType.get(i).getGtId());
                allGoodsType.get(i).setGoods(goodsByGtId);
            }
        }
        jsonObject.put("gtlist",allGoodsType);
        return  jsonObject;
    }
}
