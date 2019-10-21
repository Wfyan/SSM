package net.sshtest.controller;

import net.sshtest.common.GenerateId;
import net.sshtest.entity.Equipment;
import net.sshtest.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api")
@Controller
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    /**
     * api/getAll => 获取所有器材信息
     * alles
     * @return
     */
    @RequestMapping(value = "getAll",method = RequestMethod.GET)
    @ResponseBody
    public Map getAllEquipments(){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            map.put("status",0);
            map.put("alles",equipmentService.getAllEquipments());
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
    public Map getEquipments(@RequestParam("e_id") String e_id,@RequestParam("kind") String kind,@RequestParam("state") String state){
        Map<String,Object> map = new HashMap<String,Object>();
        String s = "from Equipment where ";
        if(e_id.equals("undefined")||e_id.equals("")){
            if(!(kind.equals("undefined")|| kind.equals(""))){
                s+="kind='"+kind+"'";
                if(!state.equals("undefined")){
                    s+=" and state="+state;
                }
            }else if(!state.equals("undefined")){
                    s+="state="+state;
                }else{
                    s="from Equipment";
            }
        }else{
            s=s+"e_id='"+e_id+"'"; //id优先级最高
        }
        System.out.println(s);
        try{
            map.put("status",0);
            map.put("alles",equipmentService.getEquipments(s));
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
    public Map getEquipment(@PathVariable String eid){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            map.put("status",0);
            map.put("alles",equipmentService.getEquipment(eid));
        }catch (Exception e){
            map.put("status",1);
            map.put("errorMassage","未知错误");
            e.printStackTrace();
        }
        return map;
    }
    /**
     * /api/getByKind => 获取名为 球 类别下的所有器材信息
     */
    @RequestMapping(value = "getByKind",method = RequestMethod.GET)
    @ResponseBody
    public Map getEquipmentsByKind(@RequestParam("kind") String name){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            map.put("status",0);
            map.put("alles",equipmentService.getEquipmentsByKind(name));
        }catch (Exception e){
            map.put("status",1);
            map.put("errorMassage","未知错误");
            e.printStackTrace();
        }
        return map;
    }
    /**
     * /api/add => 添加器材
     * 通过POST提交表单
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void addEquipment(@RequestBody Equipment eq,HttpServletResponse response){
        int count = equipmentService.length();
        //将日期对象转化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //System.out.println("我想要的："+sdf.format(eq.getBuy_date()));
        eq.setE_id(new GenerateId().genEquipmentId(sdf.format(eq.getBuy_date()),count));

        equipmentService.addEquipment(eq);
        String result = "{\"result\":1}";
        response.setContentType("application/json");
        try {
            PrintWriter out = response.getWriter();
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * /api/updateEquipment => 更改器材
     * 通过POST提交表单
     */
    @RequestMapping( value =  "updateEquipment",method = RequestMethod.POST)
    @ResponseBody
    public void updateEquipment(@RequestBody Equipment eq,HttpServletResponse response){
        equipmentService.updateEquipment(eq);
        String result = "{\"result\":1}";
        response.setContentType("application/json");
        try {
            PrintWriter out = response.getWriter();
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * api/del => 删除
     * alles
     * @return
     */
    @RequestMapping(value = "/del",method = RequestMethod.GET)
    @ResponseBody
    public void delEquipment(@RequestParam("e_id") String id,@RequestParam("state") String state,HttpServletResponse response){
        String result = "{\"result\":0}";
        //调用
        if(equipmentService.deleteEquipment(id,state)){
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
            map.put("len",equipmentService.length());
        }catch (Exception e){
            map.put("status",1);
            map.put("errorMassage","未知错误");
            e.printStackTrace();
        }
        return map;
    }

    /** ********************************** 以上是接口类型 *************************************** **/
    /* 获取所有器材信息 */
    @RequestMapping("/getAllE")
    public String getAllEquipments(HttpServletRequest request){
        Map<String,Object> map = new HashMap<String,Object>();
        request.setAttribute("alles",equipmentService.getAllEquipments());
        return "/index1";
    }
    /* 通过id获取某个器材信息，跳转到编辑页面 */
    @RequestMapping("/getEquipment")
    public String getEquipment(String id, HttpServletRequest request){
        request.setAttribute("equipment",equipmentService.getEquipment(id));
        return "/editE";
    }
    /* 跳转到查询页面 */
    @RequestMapping("/toSearch")
    public String toSearch(){
        return "/search";
    }
    /* 获取某类别下的所有器材信息 */
    @RequestMapping("/getEquipmentByKind")
    public String getEquipmentsByKind(String name,HttpServletRequest request){
        request.setAttribute("alles",equipmentService.getEquipmentsByKind(name));
        return "index1";
    }
    /* 跳转到添加页面 */
    @RequestMapping("/toAddE")
    public String toAddE(){
        return "/add";
    }
//    /* 添加器材 ， 跳回主页面 */
//    @RequestMapping("/addEquipment")
//    public String addEquipment(Equipment e){
//        equipmentService.addEquipment(e);
//        return "redirect:/api/getAllE";
//    }

}
