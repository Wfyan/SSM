package net.sshtest.dao;

import net.sshtest.entity.Site;

import java.util.List;

public interface SiteDao {
    //获取所有器材信息
    List<Site> getAllSites();
    //获取所有器材信息(状态)
    List<Site> getSites(String HQL);
    //获取某个器材
    Site getSite(String id);
    //获取类别下的所有器材
    List<Site> getSitesByKind(String name);
    //添加
    void addSite(Site e);
    //删除
    boolean deleteSite(String id, String state);
    //维护
    boolean defendSite(String id);
    //租用
    boolean rentSite(String id);
    //正常
    boolean resetSite(String id);
    //修改
    void updateSite(Site e);
    //count
    int length();
}
