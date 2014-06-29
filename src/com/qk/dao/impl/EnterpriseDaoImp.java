package com.qk.dao.impl;

import com.qk.bean.EnterpriseCommentBean;
import com.qk.dao.EnterpriseDao;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-12
 * Time: 下午7:23
 * To change this template use File | Settings | File Templates.
 */
public class EnterpriseDaoImp implements EnterpriseDao {

    private DataSource dataSource;

    public EnterpriseDaoImp(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int getCount(int userid) {
        PreparedStatement preparedStatement=null;
        int count = 0;
        ResultSet resultSet = null;
        Connection connection = null;
        String sql = null;
        if (userid > 0) {
            sql = "select count(*) as countNum from enterprise_comment where EC_ENTERPRISE_ID=?";
        } else {
            sql = "select count(*) as countNum from enterprise_comment";
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
    public List<EnterpriseCommentBean> getList(Integer pageNumber, Integer pageSize, int userid) {
        PreparedStatement preparedStatement=null;
        ResultSet resultSet = null;
        Connection connection = null;
        List<EnterpriseCommentBean> list = new ArrayList<EnterpriseCommentBean>();
        String sql = null;
        if (userid > 0) {
            sql = "SELECT * FROM (" +
                    "SELECT ROWNUM AS rn, t.* FROM   (" +
                    "SELECT t1.*,t2.USER_NAME FROM ENTERPRISE_COMMENT t1,T_USER t2 where t1.EC_EXPERTS_ID=t2.USER_ID AND EC_ENTERPRISE_ID=" + userid + " ORDER BY EC_POSTED DESC) t) " +
                    "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        } else {
            sql = "SELECT * FROM (" +
                    "SELECT ROWNUM AS rn, t.* FROM   (" +
                    "SELECT * FROM enterprise_comment ORDER BY EC_POSTED DESC) t) " +
                    "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        }
        System.out.println(sql);
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EnterpriseCommentBean enterpriseCommentBean = new EnterpriseCommentBean();
                enterpriseCommentBean.setEcId(resultSet.getInt("ec_id"));
                enterpriseCommentBean.setEcTitle(resultSet.getString("ec_title"));
                enterpriseCommentBean.setEcExpertsId(resultSet.getInt("EC_EXPERTS_ID"));
                enterpriseCommentBean.setEcContent(resultSet.getString("EC_CONTENT"));
                enterpriseCommentBean.setEcPosted(resultSet.getString("ec_posted"));
                enterpriseCommentBean.setEcRamark(resultSet.getString("ec_ramark"));
                enterpriseCommentBean.setEcEnterpriseId(resultSet.getInt("EC_ENTERPRISE_ID"));
                enterpriseCommentBean.setUserName(resultSet.getString("USER_NAME"));
                list.add(enterpriseCommentBean);
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
    public List<EnterpriseCommentBean> getExpertCommentsList(Integer pageNumber, Integer pageSize, int userId) {
        PreparedStatement preparedStatement=null;
        ResultSet resultSet = null;
        Connection connection = null;
        List<EnterpriseCommentBean> list = new ArrayList<EnterpriseCommentBean>();
        String sql = null;
        sql = "SELECT * FROM (" +
                "SELECT ROWNUM AS rn, t.* FROM   (" +
                "SELECT t1.*,t2.USER_NAME FROM ENTERPRISE_COMMENT t1,T_USER t2 where t1.EC_EXPERTS_ID=t2.USER_ID AND EC_EXPERTS_ID=" + userId + " ORDER BY EC_POSTED DESC) t) " +
                "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        System.out.println(sql);
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EnterpriseCommentBean enterpriseCommentBean = new EnterpriseCommentBean();
                enterpriseCommentBean.setEcId(resultSet.getInt("ec_id"));
                enterpriseCommentBean.setEcTitle(resultSet.getString("ec_title"));
                enterpriseCommentBean.setEcExpertsId(resultSet.getInt("EC_EXPERTS_ID"));
                enterpriseCommentBean.setEcContent(resultSet.getString("EC_CONTENT"));
                enterpriseCommentBean.setEcPosted(resultSet.getString("ec_posted"));
                enterpriseCommentBean.setEcRamark(resultSet.getString("ec_ramark"));
                enterpriseCommentBean.setEcEnterpriseId(resultSet.getInt("EC_ENTERPRISE_ID"));
                enterpriseCommentBean.setUserName(resultSet.getString("USER_NAME"));
                list.add(enterpriseCommentBean);
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
    public EnterpriseCommentBean infoFindById(int id) {
        PreparedStatement preparedStatement=null;
        EnterpriseCommentBean qkNewsBean = null;
        ResultSet resultSet = null;
        Connection connection = null;
        String sql = "select * from ENTERPRISE_COMMENT where EC_ID = ?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                qkNewsBean = new EnterpriseCommentBean();
                qkNewsBean.setEcId(resultSet.getInt("ec_id"));
                qkNewsBean.setEcTitle(resultSet.getString("ec_title"));
                qkNewsBean.setEcExpertsId(resultSet.getInt("EC_EXPERTS_ID"));
                qkNewsBean.setEcContent(resultSet.getString("EC_CONTENT"));
                qkNewsBean.setEcPosted(resultSet.getString("ec_posted"));
                qkNewsBean.setEcRamark(resultSet.getString("ec_ramark"));
                qkNewsBean.setEcEnterpriseId(resultSet.getInt("EC_ENTERPRISE_ID"));

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

    @Override
    public Integer deleteEnterpriseCommentBean(Integer id) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        int key = -1;
        String sql = "delete from ENTERPRISE_COMMENT t1 where t1.EC_ID=" + id;
        ResultSet resultSet = null;
        try {
            System.out.println(sql);
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            key = statement.executeUpdate(sql);
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
        return key;
    }
}
