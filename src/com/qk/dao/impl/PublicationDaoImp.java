package com.qk.dao.impl;

import com.qk.bean.PublicationsBean;
import com.qk.dao.PublicationDao;

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
 * Time: 下午8:53
 * To change this template use File | Settings | File Templates.
 */
public class PublicationDaoImp implements PublicationDao {

    private DataSource dataSource;

    public PublicationDaoImp(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List publicationsTopTen() {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        ResultSet resultSet = null;
        List list = new ArrayList();
        String sql = "select  * from PUBLICATIONS  where ROWNUM <= 5  order by PUB_COUNT desc";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PublicationsBean publicationsBean = new PublicationsBean();
                publicationsBean.setPubId(resultSet.getInt("pub_id"));
                publicationsBean.setPubCount(resultSet.getInt("pub_count"));
                publicationsBean.setPubTitle(resultSet.getString("pub_title"));
                list.add(publicationsBean);
            }
        } catch (SQLException e) {
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
    public PublicationsBean infoFindById(int id) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        ResultSet resultSet = null;
        PublicationsBean publicationsBean = null;
        String sql = "select * from publications where pub_id = ?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                publicationsBean = new PublicationsBean();
                publicationsBean.setPubId(resultSet.getInt("pub_id"));
                publicationsBean.setUserId(resultSet.getInt("user_id"));
                publicationsBean.setPubTitle(resultSet.getString("pub_title"));
                publicationsBean.setPubType(resultSet.getString("pub_type"));
                publicationsBean.setPubIntroduce(resultSet.getString("pub_introduce"));
                publicationsBean.setPubDate(resultSet.getString("pub_date"));
                publicationsBean.setPubPrice(resultSet.getString("pub_price"));
                publicationsBean.setPubPosted(resultSet.getString("pub_posted"));
                publicationsBean.setPubCount(resultSet.getInt("pub_count"));
                publicationsBean.setPubRemark(resultSet.getString("pub_remark"));
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
        return publicationsBean;
    }

    @Override
    public void updateClickCount(int offset, int id) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        String sql = "update publications set pub_count= pub_count+? WHERE pub_id=?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, offset);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
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

    @Override
    public List<PublicationsBean> getList(Integer pageNumber, Integer pageSize, int userid) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        List<PublicationsBean> list = new ArrayList<PublicationsBean>();
        String sql = null;
        ResultSet resultSet = null;
        if (userid > 0) {
            sql = "SELECT * FROM (" +
                    "SELECT ROWNUM AS rn, t.* FROM   (" +
                    "SELECT t1.*,t2.USER_NAME FROM publications t1,t_user t2 where t1.user_id=t2.user_id and  t1.user_id=" + userid + " ORDER BY pub_posted DESC) t) " +
                    "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        } else {
            sql = "SELECT * FROM (" +
                    "SELECT ROWNUM AS rn, t.* FROM   (" +
                    "SELECT t1.*,t2.USER_NAME FROM publications t1,t_user t2 where t1.user_id=t2.user_id ORDER BY pub_posted DESC) t) " +
                    "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        }
        try {
            connection = dataSource.getConnection();
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PublicationsBean obj = new PublicationsBean();

                Integer pubId = resultSet.getInt("pub_id");
                Integer userId = resultSet.getInt("user_id");
                String pubTitle = resultSet.getString("pub_title");
                String pubType = resultSet.getString("pub_type");
                String pubIntroduce = resultSet.getString("pub_introduce");

                String pubDate = resultSet.getString("pub_date");
                String pubPrice = resultSet.getString("pub_price");
                String pubPosted = resultSet.getString("pub_posted");
                Integer pubCount = resultSet.getInt("pub_count");
                String pubRemark = resultSet.getString("pub_remark");
                String USER_NAME = resultSet.getString("USER_NAME");

                obj.setPubId(pubId);
                obj.setUserId(userId);
                obj.setPubTitle(pubTitle);
                obj.setPubType(pubType);
                obj.setPubIntroduce(pubIntroduce);
                obj.setPubDate(pubDate);

                obj.setPubPrice(pubPrice);
                obj.setPubPosted(pubPosted);
                obj.setPubCount(pubCount);
                obj.setPubRemark(pubRemark);
                obj.setUsername(USER_NAME);

                list.add(obj);
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
    public int getCount(int userid) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        int count = 0;
        ResultSet resultSet = null;
        String sql = null;
        if (userid > 0) {
            sql = "select count(*) as countNum from publications where user_id=" + userid;
        } else {
            sql = "select count(*) as countNum from publications";
        }
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
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
    public int insertPub(PublicationsBean publicationsBean) {
        PreparedStatement preparedStatement=null;
        int key = -1;
        String sql = "insert into publications values(PUBLICATIONS_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, publicationsBean.getUserId());
            preparedStatement.setString(2, publicationsBean.getPubTitle());
            preparedStatement.setString(3, publicationsBean.getPubType());
            preparedStatement.setString(4, publicationsBean.getPubIntroduce());
            preparedStatement.setString(5, publicationsBean.getPubDate());
            preparedStatement.setString(6, publicationsBean.getPubPrice());
            preparedStatement.setString(7, publicationsBean.getPubPosted());
            preparedStatement.setInt(8, publicationsBean.getPubCount());
            preparedStatement.setString(9, publicationsBean.getPubRemark());
            key = preparedStatement.executeUpdate();
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
        return key;
    }

    @Override
    public int updatePubs(PublicationsBean publicationsBean) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        int flag = 0;
        String sql = "UPDATE publications SET user_id=?,pub_title=?,pub_type=?,pub_introduce=?,pub_date=?,pub_price=?," +
                "pub_posted=?,pub_count=?,pub_remark=? WHERE pub_id=?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, publicationsBean.getUserId());
            preparedStatement.setString(2, publicationsBean.getPubTitle());
            preparedStatement.setString(3, publicationsBean.getPubType());
            preparedStatement.setString(4, publicationsBean.getPubIntroduce());
            preparedStatement.setString(5, publicationsBean.getPubDate());
            preparedStatement.setString(6, publicationsBean.getPubPrice());
            preparedStatement.setString(7, publicationsBean.getPubPosted());
            preparedStatement.setInt(8, publicationsBean.getPubCount());
            preparedStatement.setString(9, publicationsBean.getPubRemark());
            preparedStatement.setInt(10, publicationsBean.getPubId());
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
    public void deletePubs(int id) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        String sql = "DELETE  FROM publications WHERE pub_id=?";
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
