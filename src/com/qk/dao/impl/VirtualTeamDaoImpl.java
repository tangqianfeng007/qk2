package com.qk.dao.impl;


import com.qk.bean.RfpInfoBean;
import com.qk.bean.User;
import com.qk.bean.VirtualTeamBean;
import com.qk.bean.VtMemberBean;
import com.qk.dao.BitResultDao;
import com.qk.dao.VirtualTeamDao;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VirtualTeamDaoImpl implements VirtualTeamDao {

    private DataSource dataSource;

    public VirtualTeamDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public VirtualTeamBean infoFindById(Integer id) {
        if (id != null && id > 0) {
            VirtualTeamBean obj = null;
            ResultSet resultSet = null;
            Connection connection = null;
            String sql = "select * from virtual_team where vt_id = ?";
            PreparedStatement preparedStatement=null;
            try {
                connection = dataSource.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    obj = new VirtualTeamBean();
                    obj.setRfpInfoId(resultSet.getInt("rfp_info_id"));
                    obj.setVtId(resultSet.getInt("vt_id"));
                    obj.setVtName(resultSet.getString("vt_name"));
                    obj.setVtNote(resultSet.getString("vt_note"));
                    obj.setVtCreateTime(resultSet.getString("vt_create_time"));
                    obj.setVtStatus(resultSet.getString("vt_status"));
                    obj.setVtRemark(resultSet.getString("vt_remark"));
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
            return obj;
        } else {
            return null;
        }

    }

    @Override
    public Map<String, Object> getByRfpId(Integer id) {
        int status = 0;
        List<VtMemberBean> memberList = new ArrayList<VtMemberBean>();
        VirtualTeamBean virtualTeamBean = new VirtualTeamBean();
        Map<String, Object> map = new HashMap<String, Object>();
        if (id != null && id > 0 && memberList != null && virtualTeamBean != null) {
            ResultSet resultSet = null;
            Connection connection = null;
            String sql = "select t1.*, t2.*,t3.user_name from virtual_team t1,vt_member t2,t_user t3 where  t1.vt_id=t2.vt_id(+) and t1.rfp_info_id = ? and t2.user_id = t3.user_id(+)";
            PreparedStatement preparedStatement=null;
            try {
                connection = dataSource.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    if (virtualTeamBean.getVtId() == null || virtualTeamBean.getRfpInfoId() == null)//团队信息对象只需要装载一次
                    {
                        virtualTeamBean = new VirtualTeamBean();
                        virtualTeamBean.setRfpInfoId(resultSet.getInt("rfp_info_id"));
                        virtualTeamBean.setVtId(resultSet.getInt("vt_id"));
                        virtualTeamBean.setVtName(resultSet.getString("vt_name"));
                        virtualTeamBean.setVtNote(resultSet.getString("vt_note"));
                        virtualTeamBean.setVtCreateTime(resultSet.getString("vt_create_time"));
                        virtualTeamBean.setVtStatus(resultSet.getString("vt_status"));
                        virtualTeamBean.setVtRemark(resultSet.getString("vt_remark"));
                        status = 1;//成功
                    }

                    VtMemberBean memberBean = new VtMemberBean();
                    memberBean.setUserId(resultSet.getInt("user_id"));
                    memberBean.setUserName(resultSet.getString("user_name"));
                    memberBean.setVtId(resultSet.getInt("vt_id"));
                    memberBean.setVtMemberRemark(resultSet.getString("vt_member_remark"));
                    if (memberBean.getUserId() != null && memberBean.getUserId() > 0) {
                        memberList.add(memberBean);
                    }
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
        } else {
            status = -1;//参数有为空值
        }
        map.put("memberList", memberList);
        map.put("virtualTeamBean", virtualTeamBean);
        map.put("status", status);
        return map;
    }

    @Override
    public int insertTeam(VirtualTeamBean virtualTeamBean, User user) {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        int status = 0;
        if (virtualTeamBean != null && virtualTeamBean.getRfpInfoId() != null) {
            String sql = "INSERT INTO virtual_team(vt_id,rfp_info_id,vt_name,vt_note,vt_create_time,vt_status,vt_remark) VALUES (VIRTUAL_TEAM_seq.NEXTVAL,?,?,?,?,?,?)";
            try {
                connection = dataSource.getConnection();
                String ids[] = {"vt_id"};
                preparedStatement = connection.prepareStatement(sql, ids);
                preparedStatement.setInt(1, virtualTeamBean.getRfpInfoId());
                preparedStatement.setString(2, virtualTeamBean.getVtName());
                preparedStatement.setString(3, virtualTeamBean.getVtNote());
                preparedStatement.setString(4, virtualTeamBean.getVtCreateTime());
                preparedStatement.setString(5, virtualTeamBean.getVtStatus());
                preparedStatement.setString(6, virtualTeamBean.getVtRemark());

                status = preparedStatement.executeUpdate();
                //把创建者加入到团队中
                ResultSet rs = preparedStatement.getGeneratedKeys();
                int key = 0;
                if (rs.next()) {
                    key = rs.getInt(1);
                    if (key > 0) {
                        preparedStatement = connection.prepareStatement("insert into vt_member(vt_id,user_id,vt_member_remark) values (?,?,?)");
                        preparedStatement.setInt(1, key);
                        preparedStatement.setInt(2, user.getId());
                        preparedStatement.setString(3, "创建者");
                        status = preparedStatement.executeUpdate();
                    }
                    rs.close();
                }
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
    public int deleteTeam(Integer teamId) {
        Connection connection = null;
        int status = 0;
        if (teamId != null && teamId > 0) {

            String sql1 = "delete from vt_member where vt_id=" + teamId; //先删除成员
            String sql = "delete from virtual_team where vt_id=" + teamId;  //删除团队信息
            Statement statement = null;
            try {
                connection = dataSource.getConnection();
                connection.setAutoCommit(false);
                statement = connection.createStatement();

                statement.executeUpdate(sql1);
                statement.executeUpdate(sql);

                connection.commit();//提交JDBC事务
                connection.setAutoCommit(true);// 恢复JDBC事务的默认提交方式
                status = 1;      //成功

            } catch (SQLException e) {
                try {
                    connection.rollback();//回滚JDBC事务
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
                status = 0;//失败
            } finally {
                try {
                    statement.close();
                    connection.close();
                } catch (Exception e) {

                }
            }
        } else {
            status = -1;//参数有为空值
        }
        return status;
    }

    @Override
    public int updateTeam(VirtualTeamBean virtualTeamBean) {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        int status = 0;
        if (virtualTeamBean != null && virtualTeamBean.getVtId() != null && virtualTeamBean.getVtId() > 0) {
            String sql = "UPDATE virtual_team SET vt_name=?,vt_note=?,vt_remark=? where vt_id = ?";
            try {
                connection = dataSource.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, virtualTeamBean.getVtName());
                preparedStatement.setString(2, virtualTeamBean.getVtNote());
                preparedStatement.setString(3, virtualTeamBean.getVtRemark());
                preparedStatement.setInt(4, virtualTeamBean.getVtId());

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
    public int addOneMember(VtMemberBean memberBean, User user) {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        int status = 0;
        if (memberBean != null && memberBean.getVtId() != null && memberBean.getUserId() != null) {

            String sql = "insert into vt_member(vt_id,user_id,vt_member_remark) values (?,?,?)";
            try {
                connection = dataSource.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, memberBean.getVtId());
                preparedStatement.setInt(2, memberBean.getUserId());
                if (user.getId() == memberBean.getUserId()) {
                    memberBean.setVtMemberRemark("创建者");
                } else {
                    memberBean.setVtMemberRemark("成员");
                }
                preparedStatement.setString(3, memberBean.getVtMemberRemark());
                status = preparedStatement.executeUpdate(); //1成功，0 失败

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
    public int delOneMember(Integer teamId, Integer memberId, User user) {
        Connection connection = null;
        int status = 0;
        PreparedStatement preparedStatement=null;
        if (teamId != null && memberId != null) {

            if (user.getId() == memberId) {
                return -10;//是团队创建者，不能删除
            }
            String sql = "delete from vt_member where vt_id=? and user_id=?";
            try {
                connection = dataSource.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, teamId);
                preparedStatement.setInt(2, memberId);
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
    public int outTeam(Integer teamId, Integer userId) {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        int status = 0;
        if (teamId != null && userId != null) {

            String sql = "delete from vt_member where vt_id=? and user_id=?";
            try {
                connection = dataSource.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, teamId);
                preparedStatement.setInt(2, userId);
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
    public int updateMember(Integer teamId, List<Integer> memberIdList, User user) {
        Connection connection = null;
        int status = 0;
        if (teamId != null && memberIdList != null) {
            Statement statement = null;
            try {
                connection = dataSource.getConnection();
                connection.setAutoCommit(false);
                statement = connection.createStatement();
                statement.executeUpdate("delete vt_member where vt_id=" + teamId); //删除原队员
                for (Integer mid : memberIdList) {
                    //如果这个人不是团队的创建者
                    if (user.getId() != mid) {
                        statement.executeUpdate("insert into vt_member (vt_id,user_id,vt_member_remark) values (" + teamId + " , " + mid + " , '成员')");
                    }
                }
                //将创建者加入
                statement.executeUpdate("insert into vt_member (vt_id,user_id,vt_member_remark) values (" + teamId + " , " + user.getId() + " , '创建者')");
                connection.commit();//提交JDBC事务
                connection.setAutoCommit(true);// 恢复JDBC事务的默认提交方式
                status = 1;      //成功

            } catch (SQLException e) {
                try {
                    connection.rollback();//回滚JDBC事务
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
                status = 0;//失败
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
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
    public List<VirtualTeamBean> getMyTeamByUserId(Integer pageNumber, Integer pageSize, Integer userId) {
        ArrayList<VirtualTeamBean> list = new ArrayList<VirtualTeamBean>();
        if (userId != null && userId > 0) {
            VirtualTeamBean obj = null;
            ResultSet resultSet = null;
            Connection connection = null;
            PreparedStatement preparedStatement=null;
            String sql = "SELECT * FROM (" +
                    "SELECT ROWNUM AS rn, t.* FROM   (" +
                    "SELECT * FROM virtual_team where rfp_info_id in (select rfp_info_id from rfp_info where user_id=?) ORDER BY vt_create_time DESC) t) " +
                    "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
            try {
                connection = dataSource.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, userId);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    obj = new VirtualTeamBean();
                    obj.setRfpInfoId(resultSet.getInt("rfp_info_id"));
                    obj.setVtId(resultSet.getInt("vt_id"));
                    obj.setVtName(resultSet.getString("vt_name"));
                    obj.setVtNote(resultSet.getString("vt_note"));
                    obj.setVtCreateTime(resultSet.getString("vt_create_time"));
                    obj.setVtStatus(resultSet.getString("vt_status"));
                    obj.setVtRemark(resultSet.getString("vt_remark"));

                    list.add(obj);
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
            return list;
        }

        return list;
    }

    @Override
    public Integer getCount(Integer userId) {
        int count = 0;
        if (userId != null && userId > 0) {
            PreparedStatement preparedStatement=null;
            ResultSet resultSet = null;
            Connection connection = null;
            String sql = "select count(*) as countNum from virtual_team where  rfp_info_id in (select rfp_info_id from rfp_info where user_id=?)";
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
        }

        return count;
    }

    @Override
    public List<VirtualTeamBean> getMyJoinTeam(Integer pageNumber, Integer pageSize, Integer userId) {
        ArrayList<VirtualTeamBean> list = new ArrayList<VirtualTeamBean>();
        if (userId != null && userId > 0) {
            VirtualTeamBean obj = null;
            ResultSet resultSet = null;
            Connection connection = null;
            PreparedStatement preparedStatement=null;
            String sql = "SELECT * FROM (" +
                    "SELECT ROWNUM AS rn, t.* FROM   (" +
                    "SELECT t1.* FROM virtual_team t1 where t1.vt_id in (select vt_id from vt_member where user_id=? and vt_member_remark !='创建者') ORDER BY vt_create_time DESC) t) " +
                    "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
            try {
                connection = dataSource.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, userId);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    obj = new VirtualTeamBean();
                    obj.setRfpInfoId(resultSet.getInt("rfp_info_id"));
                    obj.setVtId(resultSet.getInt("vt_id"));
                    obj.setVtName(resultSet.getString("vt_name"));
                    obj.setVtNote(resultSet.getString("vt_note"));
                    obj.setVtCreateTime(resultSet.getString("vt_create_time"));
                    obj.setVtStatus(resultSet.getString("vt_status"));
                    obj.setVtRemark(resultSet.getString("vt_remark"));

                    list.add(obj);
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

        return list;
    }
}
