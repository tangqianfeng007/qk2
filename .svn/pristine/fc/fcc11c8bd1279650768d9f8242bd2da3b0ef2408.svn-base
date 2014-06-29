package com.qk.dao;

import com.qk.bean.CallforbitAndUserBean;
import com.qk.bean.CallforbitBean;
import com.qk.bean.User;

import java.util.List;

public interface CallforbitDao {
    public List<CallforbitBean> getAllCallforbitBean(Integer pageNumber, Integer pageSize);

    public Integer getCallforbitCount();

    public CallforbitBean getCallforbitBycfbId(Integer cfbId);

    public List<CallforbitBean> getAllCallforbitBeanByUser(Integer pageNumber, Integer pageSize, User user);

    public Integer getCallforbitCountByUser(User user);

    public Integer insertCallforbit(CallforbitBean callforbitBean);

    public Integer editCallforbit(CallforbitBean callforbitBean);

    public Integer deleteCallforbit(CallforbitBean callforbitBean);

    public List<CallforbitBean> getAllCallforbitBeanByUserAndStatus(Integer pageNumber, Integer pageSize, User user);

    public List<CallforbitBean> getAllCallforbitBeanByStatus(Integer pageNumber, Integer pageSize, User user, String noticeType);

    public CallforbitAndUserBean getCallforbitBycfbIdAndStatus(Integer cfbId);

    public CallforbitAndUserBean getCallforbitByStatus(Integer cfbId);

    public Integer getCallforbitCountByUserAndStatus(User user);
}
