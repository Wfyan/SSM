package net.sshtest.dao.impl;

import net.sshtest.dao.EquipmentOrderDao;
import net.sshtest.entity.EquipmentOrder;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;

/*标注为数据访问组件
* 配置声明式事务管理
* */
@Repository
public class EquipmentOrderDaoImpl implements EquipmentOrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * 获取所有的器材订单信息
     * @return
     */
    @Override
    public List getAllEquipmentOrders() {
        String HQL = "from EquipmentOrder";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL);
        return query.list();
    }
    /**
     * 通过id获得一个器材订单信息
     * @param id
     * @return
     */
    @Override
    public List getEquipmentOrder(String id) {
        String HQL = "from EquipmentOrder where order_id =?";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL).setString(0,id);
        return query.list();
    }

    @Override
    public List<EquipmentOrder> getEquipmentsBy(String HQL) {
        Query query = sessionFactory.getCurrentSession().createQuery(HQL);
        return query.list();
    }

    @Override
    public boolean addEquipmentOrder(String order_id,String e_id, Double total, int userid, long rent_time, long end_time) {
        long cha = (end_time-rent_time)/1000/60/60;
        String SQL = "INSERT INTO equipmentorder (`order_id`, `e_id`,`userid`, `rent_time`, `end_time`, `use_time`, `total`) VALUES " +
                "('"+order_id+"', '"+e_id+"', '"+userid+"', '"+new Time(rent_time)+"','"+new Time(end_time)+"','"+cha+"','"+total+"')";
        Query query = sessionFactory.getCurrentSession().createSQLQuery(SQL);
        return (query.executeUpdate()>0);
    }


    /**
     * 根据id删除
     * @param id
     * @return
     */
    @Override
    public boolean deleteEquipmentOrder(String id,String state) {
        String HQL = "update EquipmentOrder e set e.state=? where order_id =?";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL).setString(0,state).setString(1,id);
        return (query.executeUpdate()>0);
    }

    /**
     * 更改器材信息
     * @param e
     * @return
     */
    @Override
    public void updateEquipmentOrder(EquipmentOrder e) { sessionFactory.getCurrentSession().update(e);}

    @Override
    public int length() {
        String HQL = "select count(*) from EquipmentOrder";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL);
        return ((Number)query.iterate().next()).intValue();
    }
}
