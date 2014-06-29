package com.qk.dao.impl;


import com.qk.bean.QkNewsBean;
import com.qk.dao.NewsDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-5
 * Time: 下午7:15
 * To change this template use File | Settings | File Templates.
 */
public class NewsDaoImp implements NewsDao {

    private DataSource dataSource;

    public NewsDaoImp(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /*
     * 根据id查找所有信息
     */
    @Override
    public QkNewsBean infoFindById(int id) {
        PreparedStatement preparedStatement=null  ;
        QkNewsBean qkNewsBean = null;
        ResultSet resultSet = null;
        Connection connection = null;
        String sql = "select * from qk_news where news_id = ?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                qkNewsBean = new QkNewsBean();
                qkNewsBean.setNewsId(resultSet.getInt("news_id"));
                qkNewsBean.setUserId(resultSet.getInt("user_id"));
                qkNewsBean.setNewsTitle(resultSet.getString("news_title"));
                qkNewsBean.setNewsSource(resultSet.getString("NEWS_SOURCE"));
                qkNewsBean.setNewsKeywords(resultSet.getString("NEWS_KEYWORDS"));
                qkNewsBean.setNewsDetails(resultSet.getString("NEWS_DETAILS"));
                qkNewsBean.setNewsPosted(resultSet.getString("NEWS_POSTED"));
                qkNewsBean.setNewsCount(resultSet.getInt("NEWS_COUNT"));
                qkNewsBean.setNewsRemark(resultSet.getString("NEWS_REMARK"));
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if (preparedStatement != null) {
                try {
                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                } catch (Exception e) {

                }
            }
        }
        return qkNewsBean;
    }

    /*
     *  点击量前5的新闻
     */
    @Override
    public List newsTopTen() {
        PreparedStatement preparedStatement=null ;
        ResultSet resultSet = null;
        List list = new ArrayList();
        Connection connection = null;
        String sql = "select  * from qk_news  where ROWNUM <= 5  order by news_count desc";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                QkNewsBean qkNewsBean = new QkNewsBean();
                qkNewsBean = new QkNewsBean();
                qkNewsBean.setNewsId(resultSet.getInt("news_id"));
                qkNewsBean.setUserId(resultSet.getInt("user_id"));
                qkNewsBean.setNewsTitle(resultSet.getString("news_title"));
                qkNewsBean.setNewsSource(resultSet.getString("NEWS_SOURCE"));
                qkNewsBean.setNewsKeywords(resultSet.getString("NEWS_KEYWORDS"));
                qkNewsBean.setNewsDetails(resultSet.getString("NEWS_DETAILS"));
                qkNewsBean.setNewsPosted(resultSet.getString("NEWS_POSTED"));
                qkNewsBean.setNewsCount(resultSet.getInt("NEWS_COUNT"));
                qkNewsBean.setNewsRemark(resultSet.getString("NEWS_REMARK"));
                list.add(qkNewsBean);
            }
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if (preparedStatement != null) {
                try {
                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                } catch (Exception e) {

                }
            }
        }
        return list;
    }

    @Override
    public int getCount(int userid) {
        PreparedStatement preparedStatement=null;
        int count = 0;
        ResultSet resultSet = null;
        Connection connection = null;
        String sql = null;
        if (userid > 0) {
            sql = "select count(*) as countNum from qk_news where user_id=?";
        } else {
            sql = "select count(*) as countNum from qk_news";
        }
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (userid > 0) {
                preparedStatement.setInt(1, userid);
            }
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt("countNum");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                } catch (Exception e) {

                }
            }
        }
        return count;
    }

    @Override
    public List<QkNewsBean> getList(Integer pageNumber, Integer pageSize, int userid) {
        PreparedStatement preparedStatement=null;
        ResultSet resultSet = null;
        Connection connection = null;
        List<QkNewsBean> list = new ArrayList<QkNewsBean>();
        String sql = null;
        if (userid > 0) {
            sql = "SELECT * FROM (" +
                    "SELECT ROWNUM AS rn, t.* FROM   (" +
                    "SELECT t1.*,t2.USER_NAME FROM qk_news t1,t_user t2 where t1.user_id=t2.user_id and t1.user_id=" + userid + "  ORDER BY t1.news_posted DESC) t) " +
                    "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        } else {
            sql = "SELECT * FROM (" +
                    "SELECT ROWNUM AS rn, t.* FROM   (" +
                    "SELECT t1.*,t2.USER_NAME FROM qk_news t1,t_user t2 where t1.user_id=t2.user_id ORDER BY t1.news_posted DESC) t) " +
                    "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        }
        try {
//            System.out.println(sql);
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                QkNewsBean newsBean = new QkNewsBean();
                Integer newsId = resultSet.getInt("news_id");
                Integer userId = resultSet.getInt("user_id");
                String newsTitle = resultSet.getString("news_title");
                String newsSource = resultSet.getString("news_source");
                String newsKeywords = resultSet.getString("news_keywords");

                String newsDetails = resultSet.getString("news_details");
                String newsPosted = resultSet.getString("news_posted");
                Integer newsCount = resultSet.getInt("news_count");
                String newsRemark = resultSet.getString("news_remark");
                String USER_NAME = resultSet.getString("USER_NAME");


                newsBean.setNewsId(newsId);
                newsBean.setUserId(userId);
                newsBean.setNewsTitle(newsTitle);
                newsBean.setNewsSource(newsSource);
                newsBean.setNewsKeywords(newsKeywords);
                newsBean.setNewsDetails(newsDetails);

                newsBean.setNewsPosted(newsPosted);
                newsBean.setNewsCount(newsCount);
                newsBean.setNewsRemark(newsRemark);
                newsBean.setUsername(USER_NAME);
                list.add(newsBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                } catch (Exception e) {

                }
            }
        }
        return list;
    }

    @Override
    public Integer insertNews(QkNewsBean qkNewsBean) {
        PreparedStatement preparedStatement=null;
        Integer flag = -1;
        String sql = "insert into qk_news(news_id,user_id,news_title,news_source,news_keywords,news_details,news_posted,news_count,news_remark" +
                ") values(qk_news_seq.NEXTVAL,?,?,?,?,?,?,?,?)";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, qkNewsBean.getUserId());
            preparedStatement.setString(2, qkNewsBean.getNewsTitle());
            preparedStatement.setString(3, qkNewsBean.getNewsSource());
            preparedStatement.setString(4, qkNewsBean.getNewsKeywords());
            preparedStatement.setString(5, qkNewsBean.getNewsDetails());
            preparedStatement.setString(6, qkNewsBean.getNewsPosted());
            preparedStatement.setInt(7, qkNewsBean.getNewsCount());
            preparedStatement.setString(8, "..");
            flag = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    connection.close();
                } catch (Exception e) {

                }
            }
        }
        return flag;
    }

    @Override
    public int updateNews(QkNewsBean qkNewsBean) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        int flag = -1;
        String sql = "UPDATE qk_news SET user_id=?,news_title=?,news_source=?,news_keywords=?,news_details=?,news_posted=?,news_count=?," +
                "news_remark=?  WHERE NEWS_ID=?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, qkNewsBean.getUserId());
            preparedStatement.setString(2, qkNewsBean.getNewsTitle());
            preparedStatement.setString(3, qkNewsBean.getNewsSource());
            preparedStatement.setString(4, qkNewsBean.getNewsKeywords());
            preparedStatement.setString(5, qkNewsBean.getNewsDetails());
            preparedStatement.setString(6, qkNewsBean.getNewsPosted());
            preparedStatement.setInt(7, qkNewsBean.getNewsCount());
            preparedStatement.setString(8, "..");
            preparedStatement.setInt(9, qkNewsBean.getNewsId());
            flag = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    connection.close();
                } catch (Exception e) {

                }
            }
        }
        return flag;
    }

    @Override
    public void deleteNews(int id) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        String sql = "DELETE  FROM qk_news WHERE news_id=?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {

        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    connection.close();
                } catch (Exception e) {

                }
            }
        }
    }
}
