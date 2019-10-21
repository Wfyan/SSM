package net.sshtest.service.impl;

import net.sshtest.dao.EquipmentOrderDao;
import net.sshtest.entity.EquipmentOrder;
import net.sshtest.service.EquipmentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class EquipmentOrderServiceImpl implements EquipmentOrderService {
    @Autowired
    private EquipmentOrderDao dao;

    /**
     * 获取所有
     * @return
     */
    @Override
    public List getAllEquipmentOrders() {
        return dao.getAllEquipmentOrders();
    }
    /**
     * 通过id获得一个器材订单信息
     * @param id
     * @return
     */
    @Override
    public List getEquipmentOrder(String id) {
        return dao.getEquipmentOrder(id);
    }

    @Override
    public List<EquipmentOrder> getEquipmentsBy(String HQL) {
        return dao.getEquipmentsBy(HQL);
    }

    @Override
    public boolean addEquipmentOrder(String order_id, String e_id, Double total, int userid, long rent_time, long end_time) {
        return dao.addEquipmentOrder(order_id,e_id,total,userid,rent_time,end_time);
    }

    @Override
    public boolean deleteEquipmentOrder(String id,String state) {
        return dao.deleteEquipmentOrder(id,state);
    }

    /**
     * 更改（主要是状态信息）
     * @return
     */
    @Override
    public void updateEquipmentOrder(EquipmentOrder e) { dao.updateEquipmentOrder(e); }

    /**
     * 获取总数目
     * @return
     */
    @Override
    public int length() {
        return dao.length();
    }
}
