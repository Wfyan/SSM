package net.sshtest.service.impl;

import net.sshtest.dao.EquipmentDao;
import net.sshtest.entity.Equipment;
import net.sshtest.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentDao dao;

    /**
     * 获取所有
     * @return
     */
    public List<Equipment> getAllEquipments(){
        return dao.getAllEquipments();
    }

    @Override
    public List<Equipment> getEquipments(String HQL) {
        return dao.getEquipments(HQL);
    }

    /**
     * 通过id获得一个器材信息
     * @param id
     * @return
     */
    public Equipment getEquipment(String id){
        return dao.getEquipment(id);
    }

    /**
     * 获取某个类别下的所有器材信息
     * @param name
     * @return
     */
    public List<Equipment> getEquipmentsByKind(String name){
        List<Equipment> list = dao.getEquipmentsByKind(name);
        return list;
    }

    /**
     * 添加器材
     * @param e
     */
    public void addEquipment(Equipment e){
        dao.addEquipment(e);
    }

    @Override
    public boolean deleteEquipment(String id,String state) {
        return dao.deleteEquipment(id,state);
    }

    @Override
    public boolean defendEquipment(String id) {
        return dao.defendEquipment(id);
    }

    @Override
    public boolean rentEquipment(String id) {
        return dao.rentEquipment(id);
    }

    /**
     * 更改器材信息（主要是状态信息）
     * @param e
     * @return
     */
    public void updateEquipment(Equipment e){ dao.updateEquipment(e); }

    /**
     * 获取器材总数目
     * @return
     */
    @Override
    public int length() {
        return dao.length();
    }

    public boolean resetEquipment(String id) {
        return dao.resetEquipment(id);
    }
}
