package net.sshtest.service;

import net.sshtest.entity.Equipment;

import java.util.List;

public interface EquipmentService {
    //获取所有器材信息
    List<Equipment> getAllEquipments();
    //获取所有器材信息(状态)
    List<Equipment> getEquipments(String HQL);
    //获取某个器材
    Equipment getEquipment(String id);
    //获取类别下的所有器材
    List<Equipment> getEquipmentsByKind(String name);
    //添加
    void addEquipment(Equipment e);
    //删除
    boolean deleteEquipment(String id,String state);
    //维护
    boolean defendEquipment(String id);
    //租用
    boolean rentEquipment(String id);
    //zc
    boolean resetEquipment(String id);
    //修改
    void updateEquipment(Equipment e);
    //count
    int length();
}
