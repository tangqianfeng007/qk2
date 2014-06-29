package com.qk.dao;

import com.qk.bean.QkNewsBean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-5
 * Time: 下午7:06
 * To change this template use File | Settings | File Templates.
 */
public interface NewsDao {
    public QkNewsBean infoFindById(int id);

    public List newsTopTen();

    public int getCount(int userid);

    public List<QkNewsBean> getList(Integer pageNumber, Integer pageSize, int userid);

    public Integer insertNews(QkNewsBean qkNewsBean);

    public int updateNews(QkNewsBean qkNewsBean);

    public void deleteNews(int id);
}
