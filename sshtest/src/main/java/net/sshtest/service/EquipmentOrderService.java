package net.sshtest.service;

import net.sshtest.entity.EquipmentOrder;

import java.util.List;

public interface EquipmentOrderService {
    //获取所有订单
    List getAllEquipmentOrders();
    //通过订单ID获取
    List getEquipmentOrder(String id);
    //通过用户ID获取
    List<EquipmentOrder> getEquipmentsBy(String HQL);
    //添加订单
    boolean addEquipmentOrder(String order_id,String e_id, Double total, int userid, long rent_time, long end_time);
    //删除
    boolean deleteEquipmentOrder(String id,String state);
    //修改
    void updateEquipmentOrder(EquipmentOrder e);
    //count
    int length();
}
