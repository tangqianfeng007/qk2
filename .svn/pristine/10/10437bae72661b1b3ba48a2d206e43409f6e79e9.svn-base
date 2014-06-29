package com.qk.dao.impl;


import com.qk.bean.CfbCommentBean;
import com.qk.bean.EnterpriseCommentBean;
import com.qk.bean.User;
import com.qk.common.Tools;
import com.qk.dao.CfbCommentDao;
import com.qk.dao.EnterpriseCommentDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnterpriseCommentDaoImpl implements EnterpriseCommentDao {

    private DataSource dataSource;

    public EnterpriseCommentDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Integer getEnterpriseCommentBeanCount(Integer userId) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        int count = 0;
        String sql = "select count(*) as countNum from ENTERPRISE_COMMENT WHERE EC_EXPERTS_ID=?";
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
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
    public List<EnterpriseCommentBean> getEnterpriseCommentByUserID(Integer pageNumber, Integer pageSize, Integer userId) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        ResultSet resultSet = null;
        List<EnterpriseCommentBean> list = new ArrayList<EnterpriseCommentBean>();

        String sql = "SELECT * FROM (SELECT ROWNUM AS rn, t.* FROM (SELECT *" +
                "    FROM (select t1.*,t2.user_name from ENTERPRISE_COMMENT t1,t_user t2 " +
                "  WHERE t1.EC_ENTERPRISE_ID= t2.USER_ID AND t1.EC_EXPERTS_ID   =?)" +
                "    ORDER BY EC_POSTED asc ) t )WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        try {
            connection = dataSource.getConnection();
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EnterpriseCommentBean enterpriseCommentBean = new EnterpriseCommentBean();

                String EC_CONTENT = resultSet.getString("EC_CONTENT");
                String EC_POSTED = resultSet.getString("EC_POSTED");
                String user_name = resultSet.getString("user_name");

                enterpriseCommentBean.setEcContent(EC_CONTENT);
                enterpriseCommentBean.setEcPosted(EC_POSTED);
                enterpriseCommentBean.setUserName(user_name);
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
    public Integer insertEnterpriseComment(EnterpriseCommentBean enterpriseCommentBean) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        Integer num = 0;
        String sql = "insert into ENTERPRISE_COMMENT(EC_ID,EC_ENTERPRISE_ID,EC_EXPERTS_ID,EC_CONTENT,EC_POSTED,EC_TITLE,EC_RAMARK) values (ENTERPRISE_COMMENT_seq.NEXTVAL,?,?,?,?,?,?)";
        ResultSet resultSet = null;
        try {
            System.out.println(sql);
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, enterpriseCommentBean.getEcEnterpriseId());
            preparedStatement.setInt(2, enterpriseCommentBean.getEcExpertsId());
            preparedStatement.setString(3, enterpriseCommentBean.getEcContent());
            preparedStatement.setString(4, enterpriseCommentBean.getEcPosted());
            preparedStatement.setString(5, enterpriseCommentBean.getEcTitle());
            preparedStatement.setString(6, enterpriseCommentBean.getEcRamark());
            num = preparedStatement.executeUpdate();
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
        return num;
    }
}
