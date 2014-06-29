package com.qk.dao;

import com.qk.bean.EventBean;
import com.qk.bean.QkNewsBean;

import java.util.List;

public interface EventDao {
    public List eventsTopTen();

    public EventBean infoFindById(int id);

    public void updateClickCount(int offset, int id);

    public int getCount(int userid);

    public List<EventBean> getList(Integer pageNumber, Integer pageSize, int userid);

    public Integer insertEvent(EventBean eventBean);

    public int updateEvent(EventBean eventBean);

    public void deleteEvents(int id);
}
