package com.xcy.area.controller;

import com.xcy.area.pojo.Province;
import com.xcy.area.service.ProvinceService;
import com.xcy.area.utils.JedisClient;
import com.xcy.area.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@Controller
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    ProvinceService provinceService;

    @Autowired
    JedisPool jedisPool;

    @RequestMapping("/showIndex")
    public String showIndex(){
        return "html/index";
    }

    @RequestMapping(value = "/getProvince",produces="text/plain;charset=utf-8")
    @ResponseBody
    public String getProvince(){
        Jedis jedis = jedisPool.getResource();
        String provinceListJsonStr = jedis.get("province:");
        if(provinceListJsonStr == null || provinceListJsonStr.equals("")){
            List<Province> provinceList = provinceService.getProvince();
            provinceListJsonStr = JsonUtils.objectToJson(provinceList);
            jedis.set("province:",provinceListJsonStr);
            System.out.println("从mysql数据库中取数据");
        }
        jedis.close();
        return provinceListJsonStr;
    }

    @RequestMapping(value = "/getChildCity",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getChildCity(int id){
        List<Province> proviceList = provinceService.getChildCity(id);
        System.out.println("级别二：市区");
        return JsonUtils.objectToJson(proviceList);
    }
}
