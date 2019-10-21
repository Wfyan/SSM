package net.sshtest.controller;

import net.sshtest.common.GenerateId;
import net.sshtest.entity.EquipmentOrder;
import net.sshtest.service.EquipmentOrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/eqOrder")
@Controller
public class EquipmentOrderController {
    @Autowired
    private EquipmentOrderService equipmentOrderService;

    /**
     * eqOrder/getAll => 获取所有器材订单信息
     * @return
     */
    @RequestMapping(value = "getAll",method = RequestMethod.GET)
    @ResponseBody
    public Map getAllEquipmentOrders(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("status",0);
        List list = equipmentOrderService.getAllEquipmentOrders();
        map.put("alles",list);
        return map;
    }

    /**
     * eqOrder/getBySome => 支持多种查询模式
     * id优先级最高，根据ID查找/根据状态查找/根据器材类型查找/器材类型+状态查找/所有
     * alles
     * @return
     */
    @RequestMapping(value = "getBySome",method = RequestMethod.GET)
    @ResponseBody
    public Map getEquipmentOrders(@RequestParam("orderid") String id,@RequestParam("kind") String kind,@RequestParam("userid") String user_id,@RequestParam("state") String state){
        Map<String,Object> map = new HashMap<String,Object>();
        String s = "from EquipmentOrder ";
        int[] select = {0,0,0};
        String[] st = {"","userid = "+user_id+" ","state = "+state};
        if(!(kind.equals("undefined")||kind.equals(""))) select[0]=1;
        if(!(user_id.equals("undefined")||user_id.equals(""))) select[1]=1;
        if(!(state.equals("undefined")||state.equals(""))) select[2]=1;

        if(select[1]==1&&select[2]==1){
            s+="where "+st[1]+"and "+st[2];
        }else{
            for(int i=0;i<select.length;i++){
                if(select[i]==1)s+="where "+st[i];
            }
        }
        System.out.println(s);
        try{
            if(id.equals("undefined")||id.equals("")){
                map.put("alles",equipmentOrderService.getEquipmentsBy(s));
            }else{
                map.put("alles",equipmentOrderService.getEquipmentOrder(id));
            }
            map.put("status",0);
        }catch (Exception e){
            map.put("status",1);
            map.put("errorMassage","未知错误");
            e.printStackTrace();
        }
        return map;
    }

    /**
     * eqOrder/get/1 1为订单ID参数 =》 通过ID获取某个器材订单的信息
     */
    @RequestMapping(value = "get",method = RequestMethod.GET)
    @ResponseBody
    public Map getEquipmentOrder(@RequestParam("oid") String oid){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            map.put("status",0);
            map.put("alles",equipmentOrderService.getEquipmentOrder(oid));
        }catch (Exception e){
            map.put("status",1);
            map.put("errorMassage","未知错误");
            e.printStackTrace();
        }
        return map;
    }
    @Test
    /**
     * eqOrder/add => 添加
     * 通过POST提交表单
     */
    @RequestMapping(value = "add",method = RequestMethod.GET)
    @ResponseBody
    public void addEquipmentOrder(String e_id, Double total, int userid, long rent_time, long end_time, HttpServletResponse response){
        int count = equipmentOrderService.length();
        //将日期对象转化
        //System.out.println(userid+""+total+""+rent_time);
        System.out.println("翻译后的时间："+new Time(rent_time));
        String order_id=e_id;
/*        for(int i=0;i<4-Integer.valueOf(userid).toString().length();i++){
            order_id+=0;
        }
        order_id+=userid;*/
        order_id = new GenerateId().genEquipmentId(order_id,count);
        System.out.println(order_id);
        String result = "{\"result\":0}";
        //调用
        if(equipmentOrderService.addEquipmentOrder(order_id,e_id,total,userid,rent_time,end_time)){
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
     * /api/updateEquipment => 更改器材
     * 通过POST提交表单
     */
    @RequestMapping( value =  "updateEquipment",method = RequestMethod.POST)
    @ResponseBody
    public void updateEquipment(@RequestBody EquipmentOrder eq, HttpServletResponse response){
        equipmentOrderService.updateEquipmentOrder(eq);
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
     * eqOrder/del => 删除
     * alles
     * @return
     */
    @RequestMapping(value = "/del",method = RequestMethod.GET)
    @ResponseBody
    public void delEquipmentOrder(@RequestParam("order_id") String id,@RequestParam("state") String state,HttpServletResponse response){
        String result = "{\"result\":0}";
        //调用
        if(equipmentOrderService.deleteEquipmentOrder(id,state)){
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
     * eqOrder/length => 获取总数目
     * alles
     * @return
     */
    @RequestMapping(value = "length",method = RequestMethod.GET)
    @ResponseBody
    public Map length(){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            map.put("status",0);
            map.put("len",equipmentOrderService.length());
        }catch (Exception e){
            map.put("status",1);
            map.put("errorMassage","未知错误");
            e.printStackTrace();
        }
        return map;
    }
}
