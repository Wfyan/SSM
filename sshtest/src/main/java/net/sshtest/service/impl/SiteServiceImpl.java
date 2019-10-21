package net.sshtest.service.impl;

import net.sshtest.dao.SiteDao;
import net.sshtest.entity.Site;
import net.sshtest.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class SiteServiceImpl implements SiteService {
    @Autowired
    private SiteDao dao;

    /**
     * 获取所有
     * @return
     */
    public List<Site> getAllSites(){
        return dao.getAllSites();
    }

    @Override
    public List<Site> getSites(String HQL) {
        return dao.getSites(HQL);
    }

    /**
     * 通过id获得一个器材信息
     * @param id
     * @return
     */
    public Site getSite(String id){
        return dao.getSite(id);
    }

    /**
     * 获取某个类别下的所有器材信息
     * @param name
     * @return
     */
    public List<Site> getSitesByKind(String name){
        List<Site> list = dao.getSitesByKind(name);
        return list;
    }

    /**
     * 添加器材
     * @param e
     */
    public void addSite(Site e){
        dao.addSite(e);
    }

    @Override
    public boolean deleteSite(String id,String state) {
        return dao.deleteSite(id,state);
    }

    @Override
    public boolean defendSite(String id) {
        return dao.defendSite(id);
    }

    @Override
    public boolean rentSite(String id) {
        return dao.rentSite(id);
    }

    /**
     * 更改器材信息（主要是状态信息）
     * @param e
     * @return
     */
    public void updateSite(Site e){ dao.updateSite(e); }

    /**
     * 获取器材总数目
     * @return
     */
    @Override
    public int length() {
        return dao.length();
    }

    public boolean resetSite(String id) {
        return dao.resetSite(id);
    }
}
