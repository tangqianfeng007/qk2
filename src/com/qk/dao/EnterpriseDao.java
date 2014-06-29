package com.qk.dao;

import com.qk.bean.EnterpriseCommentBean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-12
 * Time: 下午7:21
 * To change this template use File | Settings | File Templates.
 */
public interface EnterpriseDao {
    public int getCount(int userId);

    public List<EnterpriseCommentBean> getList(Integer pageNumber, Integer pageSize, int userId);

    public List<EnterpriseCommentBean> getExpertCommentsList(Integer pageNumber, Integer pageSize, int userId);

    public EnterpriseCommentBean infoFindById(int id);

    public Integer deleteEnterpriseCommentBean(Integer id);
}
