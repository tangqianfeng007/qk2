package com.qk.dao.impl;


import com.qk.bean.User;
import com.qk.dao.UserDao;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private DataSource dataSource;

    public UserDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public User regCheck(String username) {
        Connection connection = null;
        User user = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement=null;
        String sql = "SELECT * FROM t_user WHERE user_name=?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("user_name"));
                user.setRole_id(resultSet.getInt("role_id"));
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
        return user;
    }

    @Override
    public User loginCheck(String username, String password) {
        Connection connection = null;
        User user = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement=null;
        String sql = "SELECT * FROM t_user WHERE user_name=? AND user_psd=?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("user_name"));
                user.setRole_id(resultSet.getInt("role_id"));
                user.setAddress(resultSet.getString("user_address"));
                user.setEmail(resultSet.getString("user_email"));
                user.setPhone(resultSet.getString("user_phone"));
                user.setPostalcode(resultSet.getString("user_postalcode"));
                user.setType(resultSet.getString("user_type"));
                user.setIntroduce(resultSet.getString("user_introduce"));
                user.setPassword(resultSet.getString("user_psd"));
                user.setReal_name(resultSet.getString("USER_REAL_NAME"));
                user.setStatus(resultSet.getString("user_status"));
            }
        } catch (Exception e) {

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
        return user;
    }

    @Override
    public User register(User userIn) {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        User user = null;
        if (userIn != null) {
            String sql = "SELECT * FROM t_user WHERE user_name=?";
            ResultSet resultSet = null;
            try {
                connection = dataSource.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, userIn.getUsername());
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    user = null;
                } else {
                    String username = userIn.getUsername();
                    String password = userIn.getPassword();
                    String email = userIn.getEmail();
                    String phone = userIn.getPhone();
                    int role_id = userIn.getRole_id();
                    String address = userIn.getAddress();

                    String city = userIn.getCity();
                    String province = userIn.getProvince();
                    String postalcode = userIn.getPostalcode();
                    String type = userIn.getType();
                    String introduce = userIn.getIntroduce();
                    String active_code = userIn.getActive_code();
                    String status = userIn.getStatus();
                    String remark = userIn.getRemark();
                    String real_name = userIn.getReal_name();
                    String headerPicUrl = userIn.getHeaderPicUrl();

                    sql = "INSERT INTO t_user (user_id,role_id,user_name,user_psd,user_email,user_real_name, user_phone, user_address, user_city, user_province, " +
                            "user_postalcode, user_type,user_introduce,user_active_code,user_code,user_status,user_remark,user_pic_url) VALUES (T_USER_seq.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    preparedStatement.setInt(1, role_id);
                    preparedStatement.setString(2, username);
                    preparedStatement.setString(3, password);
                    preparedStatement.setString(4, email);

                    preparedStatement.setString(5, real_name);
                    preparedStatement.setString(6, phone);
                    preparedStatement.setString(7, address);
                    preparedStatement.setString(8, city);

                    preparedStatement.setString(9, province);
                    preparedStatement.setString(10, postalcode);
                    preparedStatement.setString(11, type);
                    preparedStatement.setString(12, introduce);

                    preparedStatement.setString(13, active_code);
                    preparedStatement.setString(14, "");
                    preparedStatement.setString(15, "1");
                    preparedStatement.setString(16, remark);
                    preparedStatement.setString(17, headerPicUrl);

                    preparedStatement.execute();
                    user = userIn;
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
        }
        return user;
    }

    @Override
    public int update(User userIn) {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        int flag = 0;
        String sql = "UPDATE t_user SET USER_ACTIVE_CODE = ?,USER_REAL_NAME=?,USER_PSD=?,USER_PHONE=?,USER_ADDRESS=?,USER_POSTALCODE=?,USER_TYPE=?," +
                "USER_INTRODUCE=? WHERE user_id=?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            int id = userIn.getId();
            String password = userIn.getPassword();
            String phone = userIn.getPhone();
            String address = userIn.getAddress();
            String postalcode = userIn.getPostalcode();
            String type = userIn.getType();
            String introduce = userIn.getIntroduce();
            String active_code = userIn.getActive_code();
            String real_name = userIn.getReal_name();
            preparedStatement.setString(1, active_code);
            preparedStatement.setString(2, real_name);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, postalcode);
            preparedStatement.setString(7, type);
            preparedStatement.setString(8, introduce);
            preparedStatement.setInt(9, id);
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
    public boolean deleteById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        String sql = "DELETE  FROM t_user WHERE user_id=?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            return preparedStatement.execute();
        } catch (SQLException e) {
            return false;
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
    public List expertTopTen() {
        Connection connection = null;
        ResultSet resultSet = null;
        List list = new ArrayList();
        PreparedStatement preparedStatement=null;
        String sql = "select user_id,user_name, (pub_count*0.6+event_count*0.2+news_count*0.2) hot_value from (select a.user_id, a.user_name, count(DISTINCT b.pub_id) pub_count, COUNT(DISTINCT c.event_id) event_count\n" +
                ",count(DISTINCT d.news_id) news_count from t_user a, publications b, event c, qk_news d WHERE a.user_id= b.user_id and a.user_id = c.user_id\n" +
                "and a.user_id= d.user_id and a.role_id=3  GROUP by a.user_id, a.user_name) where ROWNUM <= 5  order by hot_value desc";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("user_name"));
                user.setHot_value(resultSet.getDouble("hot_value"));
                list.add(user);
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
    public User infoFindById(int id) {
        Connection connection = null;
        ResultSet resultSet = null;
        User user = null;
        String sql = "select * from t_user where user_id=?";
        PreparedStatement preparedStatement=null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("user_name"));
                user.setAddress(resultSet.getString("user_address"));
                user.setEmail(resultSet.getString("user_email"));
                user.setPhone(resultSet.getString("user_phone"));
                user.setPostalcode(resultSet.getString("user_postalcode"));
                user.setType(resultSet.getString("user_type"));
                user.setIntroduce(resultSet.getString("user_introduce"));
                user.setPassword(resultSet.getString("user_psd"));
                user.setReal_name(resultSet.getString("USER_REAL_NAME"));
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
        return user;
    }

    @Override
    public int getCount() {
        int count = 0;
        ResultSet resultSet = null;
        Connection connection = null;
        String sql = "select count(*) as countNum from t_user where user_status=?";
        PreparedStatement preparedStatement=null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "3");
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
    public int getCount2() {
        int count = 0;
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        String sql = "select count(*) as countNum from t_user where user_status=?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "1");
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
    public int getCount3(String nameIndex) {
        int count = 0;
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        String sql = "select count(*) as countNum from t_user where user_status=? and role_id=? and  user_name like '%" + nameIndex + "%'";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "3");
            preparedStatement.setInt(2, 3);
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
    public int getCount4(String nameIndex) {
        int count = 0;
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        String sql = "select count(*) as countNum from t_user where user_status=? and role_id=? and  user_name like '%" + nameIndex + "%'";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "3");
            preparedStatement.setInt(2, 2);
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
    public List<User> getList(Integer pageNumber, Integer pageSize) {
        ResultSet resultSet = null;
        Connection connection = null;
        List<User> list = new ArrayList<User>();
        PreparedStatement preparedStatement=null;
        String sql = "SELECT * FROM (" +
                "SELECT ROWNUM AS rn, t.* FROM   (" +
                "SELECT * FROM t_user where user_status=? and role_id=?  ORDER BY user_id DESC) t) " +
                "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "3");
            preparedStatement.setInt(2, 3);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("user_name"));
                user.setAddress(resultSet.getString("user_address"));
                user.setEmail(resultSet.getString("user_email"));
                user.setPhone(resultSet.getString("user_phone"));
                user.setPostalcode(resultSet.getString("user_postalcode"));
                user.setType(resultSet.getString("user_type"));
                user.setIntroduce(resultSet.getString("user_introduce"));
                list.add(user);
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
    public List<User> getInactiveList(Integer pageNumber, Integer pageSize) {
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        List<User> list = new ArrayList<User>();
        String sql = "SELECT * FROM (" +
                "SELECT ROWNUM AS rn, t.* FROM   (" +
                "SELECT * FROM t_user  where user_status=? ORDER BY user_id DESC) t)" +
                "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "1");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("user_name"));
                user.setAddress(resultSet.getString("user_address"));
                user.setEmail(resultSet.getString("user_email"));
                user.setPhone(resultSet.getString("user_phone"));
                user.setPostalcode(resultSet.getString("user_postalcode"));
                user.setType(resultSet.getString("user_type"));
                user.setIntroduce(resultSet.getString("user_introduce"));
                user.setType(resultSet.getString("user_type"));
                list.add(user);
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
    public List<User> getSeekList(Integer pageNumber, Integer pageSize, String nameIndex) {
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        List<User> list = new ArrayList<User>();
        String sql = "SELECT * FROM (" +
                "SELECT ROWNUM AS rn, t.* FROM   (" +
                "SELECT * FROM t_user where  user_status=? and role_id=? and user_name like '%" + nameIndex + "%'  ORDER BY user_id DESC) t) " +
                "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "3");
            preparedStatement.setInt(2, 3);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("user_name"));
                user.setAddress(resultSet.getString("user_address"));
                user.setEmail(resultSet.getString("user_email"));
                user.setPhone(resultSet.getString("user_phone"));
                user.setPostalcode(resultSet.getString("user_postalcode"));
                user.setType(resultSet.getString("user_type"));
                user.setIntroduce(resultSet.getString("user_introduce"));
                list.add(user);
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
    public List<User> getSeekListForEnterprise(Integer pageNumber, Integer pageSize, String nameIndex) {
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        List<User> list = new ArrayList<User>();
        String sql = "SELECT * FROM (" +
                "SELECT ROWNUM AS rn, t.* FROM   (" +
                "SELECT * FROM t_user where  user_status=? and role_id=? and user_name like '%" + nameIndex + "%'  ORDER BY user_id DESC) t) " +
                "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "3");
            preparedStatement.setInt(2, 2);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("user_name"));
                user.setAddress(resultSet.getString("user_address"));
                user.setEmail(resultSet.getString("user_email"));
                user.setPhone(resultSet.getString("user_phone"));
                user.setPostalcode(resultSet.getString("user_postalcode"));
                user.setType(resultSet.getString("user_type"));
                user.setIntroduce(resultSet.getString("user_introduce"));
                list.add(user);
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
    public void setStatus(int id, String lv) {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        String sql = "update t_user set user_status=? where user_id = ?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lv);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
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
    }

    @Override
    public User checkEmailCode(String emailCode) {
        Connection connection = null;
        ResultSet resultSet = null;
        User user = null;
        PreparedStatement preparedStatement=null;
        String sql = "select * from t_user where USER_ACTIVE_CODE=?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, emailCode);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("user_name"));
                user.setRole_id(resultSet.getInt("role_id"));
                user.setAddress(resultSet.getString("user_address"));
                user.setEmail(resultSet.getString("user_email"));
                user.setPhone(resultSet.getString("user_phone"));
                user.setPostalcode(resultSet.getString("user_postalcode"));
                user.setType(resultSet.getString("user_type"));
                user.setIntroduce(resultSet.getString("user_introduce"));
                user.setPassword(resultSet.getString("user_psd"));
                user.setReal_name(resultSet.getString("USER_REAL_NAME"));
                user.setStatus(resultSet.getString("user_status"));
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
        return user;
    }
}
