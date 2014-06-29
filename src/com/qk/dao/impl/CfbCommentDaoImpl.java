package com.qk.dao.impl;


import com.qk.bean.CfbCommentBean;
import com.qk.bean.User;
import com.qk.dao.CfbCommentDao;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CfbCommentDaoImpl implements CfbCommentDao {

    private DataSource dataSource;

    public CfbCommentDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Integer getCfbCommentCount(Integer cfbId) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        int count = 0;
        String sql = "select count(*) as countNum from cfb_comment WHERE cfb_id=?";
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cfbId);
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
    public List<CfbCommentBean> getCfbCommentBycfbId(Integer pageNumber, Integer pageSize, Integer cfbId) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        ResultSet resultSet = null;
        List<CfbCommentBean> list = new ArrayList<CfbCommentBean>();

        String sql = "SELECT * FROM (SELECT ROWNUM AS rn, t.* FROM (SELECT * FROM " +
                "(select t2.*, t3.user_name,t1.cfb_status from callforbit t1, cfb_comment t2,t_user t3  " +
                "WHERE t2.user_id= t3.user_id AND t1.cfb_id=t2.cfb_id and t2.cfb_id=?) " +
                "ORDER BY cfb_c_posted asc) t )  WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        try {
            connection = dataSource.getConnection();
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cfbId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CfbCommentBean cfbCommentBean = new CfbCommentBean();

                Integer cfbCId = resultSet.getInt("cfb_c_id");
                Integer userId = resultSet.getInt("user_id");
                String cfbCContent = resultSet.getString("cfb_c_content");
                String cfbCPosted = resultSet.getString("cfb_c_posted");
                String cfbCRemark = resultSet.getString("cfb_c_remark");
                String username = resultSet.getString("user_name");
                String cfb_status = resultSet.getString("cfb_status");

                cfbCommentBean.setCfbCId(cfbCId);
                cfbCommentBean.setUserId(userId);
                cfbCommentBean.setCfbCContent(cfbCContent);
                cfbCommentBean.setCfbCPosted(cfbCPosted);
                cfbCommentBean.setCfbCRemark(cfbCRemark);
                cfbCommentBean.setUsername(username);
                cfbCommentBean.setCfbId(cfbId);
                cfbCommentBean.setCfbStatus(cfb_status.trim());

                list.add(cfbCommentBean);
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
    public Boolean insertCfbCommentBycfbIdAnduserID(CfbCommentBean cfbCommentBean) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        boolean flag = false;
        String sql = "insert into cfb_comment(cfb_c_id,cfb_id,user_id,cfb_c_content,cfb_c_posted,cfb_c_remark) values (CFB_COMMENT_seq.NEXTVAL,?,?,?,?,?)";
        ResultSet resultSet = null;
        try {
            System.out.println(sql);
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cfbCommentBean.getCfbId());
            preparedStatement.setInt(2, cfbCommentBean.getUserId());
            preparedStatement.setString(3, cfbCommentBean.getCfbCContent());
            preparedStatement.setString(4, cfbCommentBean.getCfbCPosted());
            preparedStatement.setString(5, cfbCommentBean.getCfbCRemark());
            flag = preparedStatement.execute();
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
        return flag;
    }

    @Override
    public Integer getCfbCommentCountByUser(Integer cfbId, User user) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        int count = 0;
        String sql = "select count(*) as countNum from cfb_comment WHERE cfb_id=?";
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cfbId);
//            preparedStatement.setInt(2,user.getId());
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
    public List<CfbCommentBean> getCfbCommentBycfbIdAndUser(Integer pageNumber, Integer pageSize, Integer cfbId, User user) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        ResultSet resultSet = null;
        List<CfbCommentBean> list = new ArrayList<CfbCommentBean>();

        String sql = "SELECT * FROM (SELECT ROWNUM AS rn, t.* FROM (SELECT * FROM " +
                "(select t2.*, t3.user_name,t1.cfb_status from callforbit t1, cfb_comment t2,t_user t3  " +
                "WHERE t2.user_id= t3.user_id and t1.cfb_id=t2.cfb_id AND t2.cfb_id=? AND t1.user_id=?) " +
                "ORDER BY cfb_c_posted asc) t )  WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        try {
            connection = dataSource.getConnection();
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cfbId);
            preparedStatement.setInt(2, user.getId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CfbCommentBean cfbCommentBean = new CfbCommentBean();

                Integer cfbCId = resultSet.getInt("cfb_c_id");
                Integer userId = resultSet.getInt("user_id");
                String cfbCContent = resultSet.getString("cfb_c_content");
                String cfbCPosted = resultSet.getString("cfb_c_posted");
                String cfbCRemark = resultSet.getString("cfb_c_remark");
                String username = resultSet.getString("user_name");
                String cfb_status = resultSet.getString("cfb_status");

                cfbCommentBean.setCfbCId(cfbCId);
                cfbCommentBean.setUserId(userId);
                cfbCommentBean.setCfbCContent(cfbCContent);
                cfbCommentBean.setCfbCPosted(cfbCPosted);
                cfbCommentBean.setCfbCRemark(cfbCRemark);
                cfbCommentBean.setUsername(username);
                cfbCommentBean.setCfbId(cfbId);
                cfbCommentBean.setCfbStatus(cfb_status.trim());

                list.add(cfbCommentBean);
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
}
