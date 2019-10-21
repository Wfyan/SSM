package net.sshtest.controller;

import net.sshtest.entity.SiteOrder;
import net.sshtest.service.impl.SiteOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/siteorder")
@Controller
public class SiteOrderController {
    @Autowired
    private SiteOrderService siteOrderService;


    //通过订单id 查找场地订单的信息
    @RequestMapping(value = "/searchsiteorder",method = RequestMethod.GET)
    @ResponseBody
    public Map searchsiteorder(SiteOrder siteOrder){
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            map.put("sitelist",siteOrderService.getSiteOrder(siteOrder));
        }catch (Exception e){
            map.put("errorMassage","未知错误");
            e.printStackTrace();
        }
        return map;
    }
    //查找所有场地订单信息
    @RequestMapping(value = "searchallsiteorder",method = RequestMethod.GET)
    @ResponseBody
    public Map searchallsiteorder(SiteOrder siteOrder){
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            map.put("sitelist",siteOrderService.getallSiteOrder());
        }catch (Exception e){
            map.put("errorMassage","未知错误");
            e.printStackTrace();
        }
        return map;
    }
    //通过userid查找场地订单信息
    @RequestMapping(value = "/searchsiteorderbyuserid",method = RequestMethod.GET)
    @ResponseBody
    public Map searchsiteorderbyuserid(int userid){
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            map.put("sitelist",siteOrderService.getSiteOrderByuserid(userid));
        }catch (Exception e){
            map.put("errorMassage","未知错误");
            e.printStackTrace();
        }
        return map;
    }

}
