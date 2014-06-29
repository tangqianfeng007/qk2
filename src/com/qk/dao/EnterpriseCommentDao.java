package com.qk.dao;

import com.qk.bean.CfbCommentBean;
import com.qk.bean.EnterpriseCommentBean;
import com.qk.bean.User;

import java.util.List;

public interface EnterpriseCommentDao {

    public Integer getEnterpriseCommentBeanCount(Integer userId);

    public List<EnterpriseCommentBean> getEnterpriseCommentByUserID(Integer pageNumber, Integer pageSize, Integer userId);

    public Integer insertEnterpriseComment(EnterpriseCommentBean enterpriseCommentBean);
}
