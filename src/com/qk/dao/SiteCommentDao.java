package com.qk.dao;

import com.qk.bean.SiteCommentBean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-6
 * Time: 上午10:28
 * To change this template use File | Settings | File Templates.
 */
public interface SiteCommentDao {
    public List commentTopTen();

    public SiteCommentBean infoFindById(int id);

    public void updateClickCount(int offset, int id);

    public int getCount(int id);

    public List<SiteCommentBean> getList(Integer pageNumber, Integer pageSize, int id);

    public Integer insertSiteCommentBean(SiteCommentBean siteCommentBean);

    public Integer deleteCommentBean(Integer scId);
}
