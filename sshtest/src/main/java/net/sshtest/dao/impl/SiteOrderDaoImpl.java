package net.sshtest.dao.impl;

import net.sshtest.dao.SiteOrderDao;
import net.sshtest.entity.SiteOrder;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class SiteOrderDaoImpl implements SiteOrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    //查找
    public SiteOrder getSiteOrder(SiteOrder siteOrder) {
        System.out.println("通过orderid查找");
        String HQL = "from SiteOrder siteorder where siteorder.sorder_id=?";
        Query query =sessionFactory.getCurrentSession().createQuery(HQL);
        query.setInteger(0,siteOrder.getSorder_id());
        List list = query.list();
        return (SiteOrder)query.uniqueResult();
    }

    //查找所有场地订单
    public List<SiteOrder> getallSiteOrder() {
        String HQL = "from SiteOrder siteorder";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL);
        List list = query.list();
        return query.list();
    }

    //通过userid查找场地订单信息
    public SiteOrder getSiteOrderByuserid(int userid){
        String HQL = "from SiteOrder siteorder where siteorder.userid=?";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL);
        query.setInteger(0,userid);
        List list = query.list();
        return (SiteOrder)query.uniqueResult();

    }


}
