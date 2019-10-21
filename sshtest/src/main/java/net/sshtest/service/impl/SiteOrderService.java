package net.sshtest.service.impl;

import net.sshtest.dao.impl.SiteOrderDaoImpl;
import net.sshtest.entity.SiteOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class SiteOrderService {
    @Autowired
    private SiteOrderDaoImpl siteOrderDaoImpl;

    public SiteOrder getSiteOrder(SiteOrder siteOrder){return siteOrderDaoImpl.getSiteOrder(siteOrder);}

    public List<SiteOrder> getallSiteOrder(){return siteOrderDaoImpl.getallSiteOrder();}

    public SiteOrder getSiteOrderByuserid(int userid) {return siteOrderDaoImpl.getSiteOrderByuserid(userid);}

}
