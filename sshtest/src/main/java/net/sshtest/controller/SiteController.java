package net.sshtest.controller;

import net.sshtest.entity.Site;
import net.sshtest.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/site")
@Controller
public class SiteController {
    @Autowired
    private SiteService SiteService;

    /**
     * api/getAll => 获取所有器材信息
     * alles
     * @return
     */
    @RequestMapping(value = "getAll",method = RequestMethod.GET)
    @ResponseBody
    public Map getAllSites(){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            map.put("status",0);
            map.put("alles",SiteService.getAllSites());
        }catch (Exception e){
            map.put("status",1);
            map.put("errorMassage","未知错误");
            e.printStackTrace();
        }
        return map;
    }

    /**
     * api/getBySome => 支持多种查询模式
     * id优先级最高，根据ID查找/根据状态查找/根据器材类型查找/器材类型+状态查找/所有
     * alles
     * @return
     */
    @RequestMapping(value = "getBySome",method = RequestMethod.GET)
    @ResponseBody
    public Map getSites(@RequestParam("e_id") String e_id,@RequestParam("kind") String kind,@RequestParam("state") String state){
        Map<String,Object> map = new HashMap<String,Object>();
        String s = "from Site where ";
        if(e_id.equals("undefined")||e_id.equals("")){
            if(!(kind.equals("undefined")|| kind.equals(""))){
                s+="site_type='"+kind+"'";
                if(!state.equals("undefined")){
                    s+=" and state="+state;
                }
            }else if(!state.equals("undefined")){
                    s+="state="+state;
                }else{
                    s="from Site";
            }
        }else{
            s=s+"site_id='"+e_id+"'"; //id优先级最高
        }
        System.out.println(s);
        try{
            map.put("status",0);
            map.put("alles",SiteService.getSites(s));
        }catch (Exception e){
            map.put("status",1);
            map.put("errorMassage","未知错误");
            e.printStackTrace();
        }
        return map;
    }
    /**
     * api/get/1 1为器材ID参数 =》 通过ID获取某个器材的信息
     */
    @RequestMapping(value = "get/{eid}",method = RequestMethod.GET)
    @ResponseBody
    public Map getSite(@PathVariable String eid){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            map.put("status",0);
            map.put("alles",SiteService.getSite(eid));
        }catch (Exception e){
            map.put("status",1);
            map.put("errorMassage","未知错误");
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void addSite(@RequestBody Site eq,HttpServletResponse response){
    SiteService.addSite(eq);
        String result = "{\"result\":1}";
        response.setContentType("application/json");
        try {
            PrintWriter out = response.getWriter();
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping( value =  "updateSite",method = RequestMethod.POST)
    @ResponseBody
    public void updateSite(@RequestBody Site eq,HttpServletResponse response){
        SiteService.updateSite(eq);
        String result = "{\"result\":1}";
        response.setContentType("application/json");
        try {
            PrintWriter out = response.getWriter();
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/del",method = RequestMethod.GET)
    @ResponseBody
    public void delSite(@RequestParam("e_id") String id,@RequestParam("state") String state,HttpServletResponse response){
        String result = "{\"result\":0}";
        //调用
        if(SiteService.deleteSite(id,state)){
            result = "{\"result\":1}";
        }
        response.setContentType("application/json");
        try {
            PrintWriter out = response.getWriter();
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * api/length => 获取总数目
     * alles
     * @return
     */
    @RequestMapping(value = "length",method = RequestMethod.GET)
    @ResponseBody
    public Map length(){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            map.put("status",0);
            map.put("len",SiteService.length());
        }catch (Exception e){
            map.put("status",1);
            map.put("errorMassage","未知错误");
            e.printStackTrace();
        }
        return map;
    }

}
