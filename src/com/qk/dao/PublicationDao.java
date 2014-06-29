package com.qk.dao;

import com.qk.bean.EventBean;
import com.qk.bean.PublicationsBean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-5
 * Time: 下午8:51
 * To change this template use File | Settings | File Templates.
 */
public interface PublicationDao {
    public List publicationsTopTen();

    public PublicationsBean infoFindById(int id);

    public void updateClickCount(int offset, int id);

    public List<PublicationsBean> getList(Integer pageNumber, Integer pageSize, int userid);

    public int getCount(int useid);

    public int insertPub(PublicationsBean publicationsBean);

    public int updatePubs(PublicationsBean publicationsBean);

    public void deletePubs(int id);
}
