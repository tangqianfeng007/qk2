package com.qk.dao.impl;


import com.qk.bean.CallforbitAndUserBean;
import com.qk.bean.CallforbitBean;
import com.qk.bean.User;
import com.qk.common.Tools;
import com.qk.dao.CallforbitDao;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CallforbitDaoImpl implements CallforbitDao {

    private DataSource dataSource;

    public CallforbitDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<CallforbitBean> getAllCallforbitBean(Integer pageNumber, Integer pageSize) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        ResultSet resultSet = null;
        List<CallforbitBean> list = new ArrayList<CallforbitBean>();
        String sql = "SELECT * FROM (" +
                "SELECT ROWNUM AS rn, t.* FROM   (" +
                "SELECT * FROM callforbit ORDER BY cfb_posted DESC) t) " +
                "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        try {
            connection = dataSource.getConnection();
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CallforbitBean callforbitBean = new CallforbitBean();
                int cfb_id = resultSet.getInt("cfb_id");
                int user_id = resultSet.getInt("user_id");
                String cfb_title = resultSet.getString("cfb_title");
                String cfb_industy = resultSet.getString("cfb_industy");
                String cfb_posted = resultSet.getString("cfb_posted");
                String cfb_contact = resultSet.getString("cfb_contact");

                callforbitBean.setCfbId(cfb_id);
                callforbitBean.setUserId(user_id);
                callforbitBean.setCfbTitle(cfb_title);
                callforbitBean.setCfbIndusty(cfb_industy);
                callforbitBean.setCfbPosted(cfb_posted);
                callforbitBean.setCfbContact(cfb_contact);
                list.add(callforbitBean);
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
    public Integer getCallforbitCount() {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        int count = 0;
        String sql = "select count(*) as countNum from callforbit";
        ResultSet resultSet = null;
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
    public CallforbitBean getCallforbitBycfbId(Integer cfbId) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        ResultSet resultSet = null;
        CallforbitBean callforbitBean = new CallforbitBean();
        String sql = "select * from callforbit where cfb_Id=" + cfbId;
        try {
            connection = dataSource.getConnection();
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int cfb_id = resultSet.getInt("cfb_id");
                int user_id = resultSet.getInt("user_id");
                int cfb_user = resultSet.getInt("cfb_user");
                String cfb_title = resultSet.getString("cfb_title");
                String cfb_industy = resultSet.getString("cfb_industy");
                String cfb_email = resultSet.getString("cfb_email");
                String cfb_openDate = resultSet.getString("cfb_open_date");
                String cfb_fax = resultSet.getString("cfb_fax");
                String cfb_expDate = resultSet.getString("cfb_exp_date");
                String cfb_details = resultSet.getString("cfb_details");
                String cfb_posted = resultSet.getString("cfb_posted");
                String cfb_contact = resultSet.getString("cfb_contact");
                String cfb_address = resultSet.getString("cfb_address");
                String cfb_phone = resultSet.getString("cfb_phone");
                String cfb_status = resultSet.getString("cfb_status");

                callforbitBean.setCfbId(cfb_id);
                callforbitBean.setUserId(user_id);
                callforbitBean.setCfbUser(user_id);
                callforbitBean.setCfbTitle(cfb_title);
                callforbitBean.setCfbIndusty(cfb_industy);
                callforbitBean.setCfbPosted(cfb_posted);
                callforbitBean.setCfbContact(cfb_contact);
                callforbitBean.setCfbEmail(cfb_email);
                callforbitBean.setCfbOpenDate(cfb_openDate);
                callforbitBean.setCfbExpDate(cfb_expDate);
                callforbitBean.setCfbDetails(cfb_details);
                callforbitBean.setCfbPhone(cfb_phone);
                callforbitBean.setCfbAddress(cfb_address);
                callforbitBean.setCfbStatus(cfb_status);
                callforbitBean.setCfbFax(cfb_fax);
                callforbitBean.setCfbId(cfbId);
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
        return callforbitBean;
    }

    @Override
    public List<CallforbitBean> getAllCallforbitBeanByUser(Integer pageNumber, Integer pageSize, User user) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        ResultSet resultSet = null;
        List<CallforbitBean> list = new ArrayList<CallforbitBean>();
        String sql = "SELECT * FROM (" +
                "SELECT ROWNUM AS rn, t.* FROM   (" +
                "SELECT * FROM callforbit where user_id=? ORDER BY cfb_posted DESC) t) " +
                "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        try {
            connection = dataSource.getConnection();
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CallforbitBean callforbitBean = new CallforbitBean();
                int cfb_id = resultSet.getInt("cfb_id");
                int user_id = resultSet.getInt("user_id");
                String cfb_title = resultSet.getString("cfb_title");
                String cfb_industy = resultSet.getString("cfb_industy");
                String cfbOpenDate = resultSet.getString("cfb_open_date");
                String cfb_contact = resultSet.getString("cfb_contact");

                callforbitBean.setCfbId(cfb_id);
                callforbitBean.setUserId(user_id);
                callforbitBean.setCfbTitle(cfb_title);
                callforbitBean.setCfbIndusty(cfb_industy);
                callforbitBean.setCfbOpenDate(cfbOpenDate);
                callforbitBean.setCfbContact(cfb_contact);
                list.add(callforbitBean);
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
    public Integer getCallforbitCountByUser(User user) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        int count = 0;
        String sql = "select count(*) as countNum from callforbit where user_id=?";
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getId());
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
    public Integer insertCallforbit(CallforbitBean callforbitBean) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        int key = -1;
        String sql = "insert into CALLFORBIT(CFB_ID,USER_ID,CFB_TITLE,CFB_INDUSTY," +
                "CFB_ADDRESS,CFB_PHONE,CFB_FAX,CFB_EMAIL,CFB_OPEN_DATE,CFB_EXP_DATE," +
                "CFB_DETAILS,CFB_POSTED,CFB_STATUS,CFB_FILE_URL,CFB_REMARK) values " +
                "(CALLFORBIT_seq.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        ResultSet resultSet = null;
        try {
            System.out.println(sql);
            connection = dataSource.getConnection();
            String ids[] = {"CFB_ID"};
            preparedStatement = connection.prepareStatement(sql, ids);
            preparedStatement.setInt(1, callforbitBean.getUserId());
            preparedStatement.setString(2, callforbitBean.getCfbTitle());
            preparedStatement.setString(3, callforbitBean.getCfbIndusty());
            preparedStatement.setString(4, callforbitBean.getCfbAddress());
            preparedStatement.setString(5, callforbitBean.getCfbPhone());
            preparedStatement.setString(6, callforbitBean.getCfbFax());
            preparedStatement.setString(7, callforbitBean.getCfbEmail());
            preparedStatement.setString(8, callforbitBean.getCfbOpenDate());
            preparedStatement.setString(9, callforbitBean.getCfbExpDate());

            preparedStatement.setString(10, callforbitBean.getCfbDetails());
            preparedStatement.setString(11, Tools.getNowDate());
            preparedStatement.setString(12, "0");
            preparedStatement.setString(13, "url");

            preparedStatement.setString(14, "备注");
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                key = rs.getInt(1);
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
        return key;
    }

    @Override
    public Integer editCallforbit(CallforbitBean callforbitBean) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        int key = -1;
        String sql = "update CALLFORBIT set CFB_TITLE=?,CFB_INDUSTY=?," +
                "CFB_ADDRESS=?,CFB_PHONE=?,CFB_FAX=?,CFB_EMAIL=?,CFB_OPEN_DATE=?,CFB_EXP_DATE=?," +
                "CFB_DETAILS=? where CFB_ID=?";
        ResultSet resultSet = null;
        try {
            System.out.println(sql);
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, callforbitBean.getCfbTitle());
            preparedStatement.setString(2, callforbitBean.getCfbIndusty());
            preparedStatement.setString(3, callforbitBean.getCfbAddress());
            preparedStatement.setString(4, callforbitBean.getCfbPhone());
            preparedStatement.setString(5, callforbitBean.getCfbFax());
            preparedStatement.setString(6, callforbitBean.getCfbEmail());
            preparedStatement.setString(7, callforbitBean.getCfbOpenDate());
            preparedStatement.setString(8, callforbitBean.getCfbExpDate());

            preparedStatement.setString(9, callforbitBean.getCfbDetails());
            preparedStatement.setInt(10, callforbitBean.getCfbId());

            key = preparedStatement.executeUpdate();
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

    @Override
    public Integer deleteCallforbit(CallforbitBean callforbitBean) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        int key = -1;
        String sql = "delete from cfb_comment t1 where t1.CFB_ID=" + callforbitBean.getCfbId();
        String sql1 = "delete from CALLFORBIT where CFB_ID=" + callforbitBean.getCfbId();
        ResultSet resultSet = null;
        try {
            System.out.println(sql);
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            key = statement.executeUpdate(sql1);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
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

    @Override
    public List<CallforbitBean> getAllCallforbitBeanByUserAndStatus(Integer pageNumber, Integer pageSize, User user) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        ResultSet resultSet = null;
        List<CallforbitBean> list = new ArrayList<CallforbitBean>();
        String sql = "SELECT * FROM (" +
                "SELECT ROWNUM AS rn, t.* FROM   (" +
                "SELECT  t1.* FROM (SELECT a1.USER_REAL_NAME,a2.* " +
                "      FROM t_user a1," +
                "        callforbit a2" +
                "      WHERE a1.user_id= a2.cfb_user and a2.cfb_status='1' ) t1 where t1.user_id=? ORDER BY cfb_posted DESC) t) " +
                "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        try {
            connection = dataSource.getConnection();
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CallforbitBean callforbitBean = new CallforbitBean();
                int cfb_id = resultSet.getInt("cfb_id");
                int user_id = resultSet.getInt("user_id");
                int CFB_USER = resultSet.getInt("CFB_USER");
                String cfb_title = resultSet.getString("cfb_title");
                String cfb_industy = resultSet.getString("cfb_industy");
                String cfbOpenDate = resultSet.getString("cfb_open_date");
                String CFB_POSTED = resultSet.getString("CFB_POSTED");
                String CFB_ADDRESS = resultSet.getString("CFB_ADDRESS");
                String USER_REAL_NAME = resultSet.getString("USER_REAL_NAME");
                String CFB_EXP_DATE = resultSet.getString("CFB_EXP_DATE");

                callforbitBean.setCfbId(cfb_id);
                callforbitBean.setUserId(user_id);
                callforbitBean.setCfbTitle(cfb_title);
                callforbitBean.setCfbIndusty(cfb_industy);
                callforbitBean.setCfbOpenDate(cfbOpenDate);
                callforbitBean.setCfbAddress(CFB_ADDRESS);
                callforbitBean.setUserRealName(USER_REAL_NAME);
                callforbitBean.setCfbPosted(CFB_POSTED);
                callforbitBean.setCfbExpDate(CFB_EXP_DATE);
                list.add(callforbitBean);
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
    public List<CallforbitBean> getAllCallforbitBeanByStatus(Integer pageNumber, Integer pageSize, User user, String noticeType) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        ResultSet resultSet = null;
        List<CallforbitBean> list = new ArrayList<CallforbitBean>();
        String sql = "SELECT * FROM (" +
                "SELECT ROWNUM AS rn, t.* FROM   (" +
                "SELECT  t1.* FROM (SELECT a1.USER_REAL_NAME,a2.* " +
                "      FROM t_user a1," +
                "        callforbit a2" +
                "      WHERE a1.user_id= a2.cfb_user and a2.cfb_status='1' ) t1 ORDER BY cfb_posted DESC) t) " +
                "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        if ("1".equals(noticeType)) {
            sql = "SELECT * FROM (" +
                    "SELECT ROWNUM AS rn, t.* FROM   (" +
                    "SELECT  t1.* FROM (SELECT a1.USER_REAL_NAME,a2.* " +
                    "      FROM t_user a1," +
                    "        callforbit a2" +
                    "      WHERE a1.user_id= a2.cfb_user and a2.cfb_status='1' and a2.cfb_user=?) t1 ORDER BY cfb_posted DESC) t) " +
                    "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        }

        try {
            connection = dataSource.getConnection();
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            if ("1".equals(noticeType)) {
                preparedStatement.setInt(1, user.getId());
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CallforbitBean callforbitBean = new CallforbitBean();
                int cfb_id = resultSet.getInt("cfb_id");
                int user_id = resultSet.getInt("user_id");
                int CFB_USER = resultSet.getInt("CFB_USER");
                String cfb_title = resultSet.getString("cfb_title");
                String cfb_industy = resultSet.getString("cfb_industy");
                String cfbOpenDate = resultSet.getString("cfb_open_date");
                String CFB_POSTED = resultSet.getString("CFB_POSTED");
                String CFB_ADDRESS = resultSet.getString("CFB_ADDRESS");
                String USER_REAL_NAME = resultSet.getString("USER_REAL_NAME");
                String CFB_EXP_DATE = resultSet.getString("CFB_EXP_DATE");

                callforbitBean.setCfbId(cfb_id);
                callforbitBean.setUserId(user_id);
                callforbitBean.setCfbTitle(cfb_title);
                callforbitBean.setCfbIndusty(cfb_industy);
                callforbitBean.setCfbOpenDate(cfbOpenDate);
                callforbitBean.setCfbAddress(CFB_ADDRESS);
                callforbitBean.setUserRealName(USER_REAL_NAME);
                callforbitBean.setCfbPosted(CFB_POSTED);
                callforbitBean.setCfbExpDate(CFB_EXP_DATE);
                list.add(callforbitBean);
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
    public CallforbitAndUserBean getCallforbitBycfbIdAndStatus(Integer cfbId) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        ResultSet resultSet = null;
        CallforbitAndUserBean callforbitAndUserBean = new CallforbitAndUserBean();
        String sql = "select t1.*,t2.* from callforbit t1,t_user t2 where cfb_status='1' AND t1.CFB_USER=t2.USER_ID AND cfb_Id=" + cfbId;
        try {
            connection = dataSource.getConnection();
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int cfb_id = resultSet.getInt("cfb_id");
                int user_id = resultSet.getInt("user_id");
                int cfb_user = resultSet.getInt("cfb_user");
                String cfb_title = resultSet.getString("cfb_title");
                String cfb_industy = resultSet.getString("cfb_industy");
                String cfb_email = resultSet.getString("cfb_email");
                String cfb_openDate = resultSet.getString("cfb_open_date");
                String cfb_fax = resultSet.getString("cfb_fax");
                String cfb_expDate = resultSet.getString("cfb_exp_date");
                String cfb_details = resultSet.getString("cfb_details");
                String cfb_posted = resultSet.getString("cfb_posted");
                String cfb_contact = resultSet.getString("cfb_contact");
                String cfb_address = resultSet.getString("cfb_address");
                String cfb_phone = resultSet.getString("cfb_phone");
                String cfb_status = resultSet.getString("cfb_status");

                callforbitAndUserBean.setId(resultSet.getInt("user_id"));
                callforbitAndUserBean.setUsername(resultSet.getString("user_name"));
                callforbitAndUserBean.setAddress(resultSet.getString("user_address"));
                callforbitAndUserBean.setEmail(resultSet.getString("user_email"));
                callforbitAndUserBean.setPhone(resultSet.getString("user_phone"));
                callforbitAndUserBean.setPostalcode(resultSet.getString("user_postalcode"));
                callforbitAndUserBean.setType(resultSet.getString("user_type"));
                callforbitAndUserBean.setIntroduce(resultSet.getString("user_introduce"));
                callforbitAndUserBean.setReal_name(resultSet.getString("USER_REAL_NAME"));

                callforbitAndUserBean.setCfbId(cfb_id);
                callforbitAndUserBean.setUserId(user_id);
                callforbitAndUserBean.setCfbUser(user_id);
                callforbitAndUserBean.setCfbTitle(cfb_title);
                callforbitAndUserBean.setCfbIndusty(cfb_industy);
                callforbitAndUserBean.setCfbPosted(cfb_posted);
                callforbitAndUserBean.setCfbContact(cfb_contact);
                callforbitAndUserBean.setCfbEmail(cfb_email);
                callforbitAndUserBean.setCfbOpenDate(cfb_openDate);
                callforbitAndUserBean.setCfbExpDate(cfb_expDate);
                callforbitAndUserBean.setCfbDetails(cfb_details);
                callforbitAndUserBean.setCfbPhone(cfb_phone);
                callforbitAndUserBean.setCfbAddress(cfb_address);
                callforbitAndUserBean.setCfbStatus(cfb_status);
                callforbitAndUserBean.setCfbFax(cfb_fax);
                callforbitAndUserBean.setCfbId(cfbId);
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
        return callforbitAndUserBean;
    }

    @Override
    public CallforbitAndUserBean getCallforbitByStatus(Integer cfbId) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        ResultSet resultSet = null;
        CallforbitAndUserBean callforbitAndUserBean = new CallforbitAndUserBean();
        String sql = "select t1.*,t2.* from callforbit t1,t_user t2 where cfb_status='1' AND cfb_Id=" + cfbId;
        try {
            connection = dataSource.getConnection();
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int cfb_id = resultSet.getInt("cfb_id");
                int user_id = resultSet.getInt("user_id");
                int cfb_user = resultSet.getInt("cfb_user");
                String cfb_title = resultSet.getString("cfb_title");
                String cfb_industy = resultSet.getString("cfb_industy");
                String cfb_email = resultSet.getString("cfb_email");
                String cfb_openDate = resultSet.getString("cfb_open_date");
                String cfb_fax = resultSet.getString("cfb_fax");
                String cfb_expDate = resultSet.getString("cfb_exp_date");
                String cfb_details = resultSet.getString("cfb_details");
                String cfb_posted = resultSet.getString("cfb_posted");
                String cfb_contact = resultSet.getString("cfb_contact");
                String cfb_address = resultSet.getString("cfb_address");
                String cfb_phone = resultSet.getString("cfb_phone");
                String cfb_status = resultSet.getString("cfb_status");

                callforbitAndUserBean.setId(resultSet.getInt("user_id"));
                callforbitAndUserBean.setUsername(resultSet.getString("user_name"));
                callforbitAndUserBean.setAddress(resultSet.getString("user_address"));
                callforbitAndUserBean.setEmail(resultSet.getString("user_email"));
                callforbitAndUserBean.setPhone(resultSet.getString("user_phone"));
                callforbitAndUserBean.setPostalcode(resultSet.getString("user_postalcode"));
                callforbitAndUserBean.setType(resultSet.getString("user_type"));
                callforbitAndUserBean.setIntroduce(resultSet.getString("user_introduce"));
                callforbitAndUserBean.setReal_name(resultSet.getString("USER_REAL_NAME"));

                callforbitAndUserBean.setCfbId(cfb_id);
                callforbitAndUserBean.setUserId(user_id);
                callforbitAndUserBean.setCfbUser(user_id);
                callforbitAndUserBean.setCfbTitle(cfb_title);
                callforbitAndUserBean.setCfbIndusty(cfb_industy);
                callforbitAndUserBean.setCfbPosted(cfb_posted);
                callforbitAndUserBean.setCfbContact(cfb_contact);
                callforbitAndUserBean.setCfbEmail(cfb_email);
                callforbitAndUserBean.setCfbOpenDate(cfb_openDate);
                callforbitAndUserBean.setCfbExpDate(cfb_expDate);
                callforbitAndUserBean.setCfbDetails(cfb_details);
                callforbitAndUserBean.setCfbPhone(cfb_phone);
                callforbitAndUserBean.setCfbAddress(cfb_address);
                callforbitAndUserBean.setCfbStatus(cfb_status);
                callforbitAndUserBean.setCfbFax(cfb_fax);
                callforbitAndUserBean.setCfbId(cfbId);
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
        return callforbitAndUserBean;
    }

    @Override
    public Integer getCallforbitCountByUserAndStatus(User user) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        int count = 0;
        String sql = "select count(*) as countNum from callforbit where cfb_status='1' AND user_id=?";
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getId());
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
}
