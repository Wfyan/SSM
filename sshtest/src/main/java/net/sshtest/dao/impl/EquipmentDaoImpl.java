package net.sshtest.dao.impl;

import net.sshtest.dao.EquipmentDao;
import net.sshtest.entity.Equipment;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/*标注为数据访问组件
* 配置声明式事务管理
* */
@Repository
public class EquipmentDaoImpl implements EquipmentDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * 获取所有的器材信息
     * @return
     */
    public List<Equipment> getAllEquipments(){
        String HQL = "from Equipment";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL);
        return query.list();
    }
    /**
     * 获取所有的器材信息(状态)
     * @return
     */
    @Override
    public List<Equipment> getEquipments(String HQL) {
        Query query = sessionFactory.getCurrentSession().createQuery(HQL);
        return query.list();
    }

    /**
     * 通过id获得一个器材信息
     * @param id
     * @return
     */
    public Equipment getEquipment(String id){
        String HQL = "from Equipment where e_id =?";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL).setString(0,id);
        return (Equipment)query.uniqueResult();
    }

    /**
     * 获取某个类别下的所有器材信息
     * @param name
     * @return
     */
    public List<Equipment> getEquipmentsByKind(String name){
        String HQL = "from Equipment where kind =?";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL).setString(0,name);
        return query.list();
    }

    /**
     * 添加器材
     * @param e
     */
    public void addEquipment(Equipment e){
        sessionFactory.getCurrentSession().save(e);
    }

    /**
     * 根据id删除器材
     * @param id
     * @return
     */
    public boolean deleteEquipment(String id,String state){
        String HQL = "update Equipment e set e.state=? where e_id =?";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL).setString(0,state).setString(1,id);
        return (query.executeUpdate()>0);
    }

    @Override
    public boolean defendEquipment(String id) {
        String HQL = "update Equipment e set e.state=2 where e_id =?";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL).setString(0,id);
        return (query.executeUpdate()>0);
    }

    @Override
    public boolean rentEquipment(String id) {
        String HQL = "update Equipment e set e.state=1 where e_id =?";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL).setString(0,id);
        return (query.executeUpdate()>0);
    }

    /**
     * 更改信息
     * @param e
     * @return
     */
    public void updateEquipment(Equipment e){
        sessionFactory.getCurrentSession().update(e);
    }

    /**
     * 获取总数目
     * @return
     */
    @Override
    public int length() {
        String HQL = "select count(*) from Equipment";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL);
        return ((Number)query.iterate().next()).intValue();
    }

    public boolean resetEquipment(String id) {
        String HQL = "update Equipment e set e.state=0 where e_id =?";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL).setString(0,id);
        return (query.executeUpdate()>0);
    }
}
