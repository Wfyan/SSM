package net.sshtest.dao.impl;

import net.sshtest.dao.SiteDao;
import net.sshtest.entity.Site;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/*标注为数据访问组件
 * 配置声明式事务管理
 * */
@Repository
public class SiteDaoImpl implements SiteDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    @Override
    public List<Site> getAllSites() {
        String HQL = "from Site";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL);
        return query.list();
    }

    @Override
    public List<Site> getSites(String HQL) {
        Query query = sessionFactory.getCurrentSession().createQuery(HQL);
        return query.list();
    }

    @Override
    public Site getSite(String id) {
        String HQL = "from Site where site_id =?";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL).setString(0,id);
        return (Site) query.uniqueResult();
    }

    @Override
    public List<Site> getSitesByKind(String name) {
        String HQL = "from Site where site_type =?";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL).setString(0,name);
        return query.list();
    }

    @Override
    public void addSite(Site e) {
        sessionFactory.getCurrentSession().save(e);
    }

    @Override
    public boolean deleteSite(String id, String state) {
        String HQL = "update Site e set e.state=? where site_id =?";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL).setString(0,state).setString(1,id);
        return (query.executeUpdate()>0);
    }

    @Override
    public boolean defendSite(String id) {
        String HQL = "update Site e set e.state=2 where site_id =?";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL).setString(0,id);
        return (query.executeUpdate()>0);
    }

    @Override
    public boolean rentSite(String id) {
        String HQL = "update Site e set e.state=1 where site_id =?";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL).setString(0,id);
        return (query.executeUpdate()>0);
    }

    @Override
    public boolean resetSite(String id) {
        String HQL = "update Site e set e.state=0 where site_id =?";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL).setString(0,id);
        return (query.executeUpdate()>0);
    }

    @Override
    public void updateSite(Site e) {
        sessionFactory.getCurrentSession().update(e);
    }

    @Override
    public int length() {
        String HQL = "select count(*) from Site";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL);
        return ((Number)query.iterate().next()).intValue();
    }
}
