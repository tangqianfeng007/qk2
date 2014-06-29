package com.qk.dao.impl;


import com.qk.bean.QkNewsBean;
import com.qk.bean.RfpInfoBean;
import com.qk.dao.NewsDao;
import com.qk.dao.RfpInfoDao;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RfpInfoDaoImp implements RfpInfoDao {

    private DataSource dataSource;

    public RfpInfoDaoImp(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /*
     * 根据id查找所有信息
     */
    @Override
    public RfpInfoBean infoFindById(int id) {
        RfpInfoBean rfpInfoBean = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        String sql = "select t1.*,t2.user_name from rfp_info t1, t_user t2 where rfp_info_id = ? and t1.user_id=t2.user_id";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                rfpInfoBean = new RfpInfoBean();
                rfpInfoBean.setRfpInfoId(resultSet.getInt("rfp_info_id"));
                rfpInfoBean.setUserId(resultSet.getInt("user_id"));
                rfpInfoBean.setRfpInfoTitle(resultSet.getString("rfp_info_title"));
                rfpInfoBean.setRfpInfoKey(resultSet.getString("rfp_info_key"));
                rfpInfoBean.setRfpInfoContent(resultSet.getString("rfp_info_content"));
                rfpInfoBean.setRfpInfoType(resultSet.getString("rfp_info_type"));
                rfpInfoBean.setRfpInfoPosted(resultSet.getString("rfp_info_posted"));
                rfpInfoBean.setRfpInfoRemark(resultSet.getString("rfp_info_remark"));
                rfpInfoBean.setUserName(resultSet.getString("user_name"));
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
        return rfpInfoBean;
    }

    @Override
    public int getCount() {
        int count = 0;
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        String sql = "select count(*) as countNum from rfp_info";
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
    public Integer getMyCount(Integer userId) {
        int count = 0;
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        String sql = "select count(*) as countNum from rfp_info where user_id=" + userId;
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
    public List<RfpInfoBean> getList(Integer pageNumber, Integer pageSize) {
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        List<RfpInfoBean> list = new ArrayList<RfpInfoBean>();
        String sql = "SELECT * FROM (" +
                "SELECT ROWNUM AS rn, t.* FROM   (" +
                "SELECT t1.*,t2.user_name FROM rfp_info t1, t_user t2 where t1.user_id=t2.user_id ORDER BY rfp_info_posted DESC) t) " +
                "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                RfpInfoBean rfpInfoBean = new RfpInfoBean();

                rfpInfoBean.setRfpInfoId(resultSet.getInt("rfp_info_id"));
                rfpInfoBean.setUserId(resultSet.getInt("user_id"));
                rfpInfoBean.setRfpInfoTitle(resultSet.getString("rfp_info_title"));
                rfpInfoBean.setRfpInfoKey(resultSet.getString("rfp_info_key"));
                rfpInfoBean.setRfpInfoContent(resultSet.getString("rfp_info_content"));
                rfpInfoBean.setRfpInfoType(resultSet.getString("rfp_info_type"));
                rfpInfoBean.setRfpInfoPosted(resultSet.getString("rfp_info_posted"));
                rfpInfoBean.setRfpInfoRemark(resultSet.getString("rfp_info_remark"));
                rfpInfoBean.setUserName(resultSet.getString("user_name"));
                list.add(rfpInfoBean);
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
    public List<RfpInfoBean> getMyList(Integer userId, Integer pageNumber, Integer pageSize) {
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        List<RfpInfoBean> list = new ArrayList<RfpInfoBean>();
        String sql = "SELECT * FROM (" +
                "SELECT ROWNUM AS rn, t.* FROM   (" +
                "SELECT t1.*,t2.user_name FROM rfp_info t1, t_user t2 where t1.user_id=t2.user_id and t1.user_id=? ORDER BY rfp_info_posted DESC) t) " +
                "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                RfpInfoBean rfpInfoBean = new RfpInfoBean();

                rfpInfoBean.setRfpInfoId(resultSet.getInt("rfp_info_id"));
                rfpInfoBean.setUserId(resultSet.getInt("user_id"));
                rfpInfoBean.setRfpInfoTitle(resultSet.getString("rfp_info_title"));
                rfpInfoBean.setRfpInfoKey(resultSet.getString("rfp_info_key"));
                rfpInfoBean.setRfpInfoContent(resultSet.getString("rfp_info_content"));
                rfpInfoBean.setRfpInfoType(resultSet.getString("rfp_info_type"));
                rfpInfoBean.setRfpInfoPosted(resultSet.getString("rfp_info_posted"));
                rfpInfoBean.setRfpInfoRemark(resultSet.getString("rfp_info_remark"));
                rfpInfoBean.setUserName(resultSet.getString("user_name"));
                list.add(rfpInfoBean);
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
    public Integer deleteRfp(Integer rfpId) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        int status = 0;
        if (rfpId != null && rfpId > 0) {

            String sqlMember = "delete from vt_member where vt_id=( select vt_id from virtual_team where rfp_info_id=" + rfpId + ")";
            String sqlTeam = "delete from virtual_team where rfp_info_id=" + rfpId + "";
            String sqlComment = "delete from rfp_info_comment where rfp_info_id=" + rfpId + "";
            String sqlRfp = "delete from rfp_info where rfp_info_id=" + rfpId + "";
            Statement statement = null;
            try {
                connection = dataSource.getConnection();
                connection.setAutoCommit(false);
                statement = connection.createStatement();

                statement.executeUpdate(sqlMember); //删除队员
                statement.executeUpdate(sqlTeam); //删除团队
                statement.executeUpdate(sqlComment); //删除评论
                statement.executeUpdate(sqlRfp); //删除rfp

                connection.commit();//提交JDBC事务
                connection.setAutoCommit(true);// 恢复JDBC事务的默认提交方式
                status = 1;      //成功
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
        } else {
            status = -1;//参数有为空值
        }
        return status;

    }

    @Override
    public int addRfp(RfpInfoBean rfpInfoBean) {
        Connection connection = null;
        int status = 0;
        PreparedStatement preparedStatement=null;
        if (rfpInfoBean != null && rfpInfoBean.getUserId() != null && rfpInfoBean.getUserId() > 0) {
            String sql = "INSERT INTO rfp_info(rfp_info_id,user_id,rfp_info_title,rfp_info_key,rfp_info_content,rfp_info_type,rfp_info_posted,rfp_info_remark) VALUES (RFP_INFO_seq.NEXTVAL,?,?,?,?,?,?,?)";
            try {
                connection = dataSource.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, rfpInfoBean.getUserId());
                preparedStatement.setString(2, rfpInfoBean.getRfpInfoTitle());
                preparedStatement.setString(3, rfpInfoBean.getRfpInfoKey());
                preparedStatement.setString(4, rfpInfoBean.getRfpInfoContent());
                preparedStatement.setString(5, rfpInfoBean.getRfpInfoType());
                preparedStatement.setString(6, rfpInfoBean.getRfpInfoPosted());
                preparedStatement.setString(7, rfpInfoBean.getRfpInfoRemark());

                status = preparedStatement.executeUpdate();
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
        } else {
            status = -1;//参数有为空值
        }

        return status;
    }

    @Override
    public int updateRfp(RfpInfoBean rfpInfoBean) {
        Connection connection = null;
        int status = 0;
        PreparedStatement preparedStatement=null;
        if (rfpInfoBean != null && rfpInfoBean.getRfpInfoId() != null && rfpInfoBean.getRfpInfoId() > 0) {
            String sql = "UPDATE rfp_info SET rfp_info_title=?,rfp_info_key=?,rfp_info_content=?,rfp_info_type=?,rfp_info_remark=? where rfp_info_id = ?";
            try {
                connection = dataSource.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, rfpInfoBean.getRfpInfoTitle());
                preparedStatement.setString(2, rfpInfoBean.getRfpInfoKey());
                preparedStatement.setString(3, rfpInfoBean.getRfpInfoContent());
                preparedStatement.setString(4, rfpInfoBean.getRfpInfoType());
                preparedStatement.setString(5, rfpInfoBean.getRfpInfoRemark());
                preparedStatement.setInt(6, rfpInfoBean.getRfpInfoId());
                status = preparedStatement.executeUpdate();
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
        } else {
            status = -1;//参数有为空值
        }
        return status;
    }
}
