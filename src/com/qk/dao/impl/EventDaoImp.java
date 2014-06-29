package com.qk.dao.impl;

import com.qk.bean.EventBean;
import com.qk.dao.EventDao;

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
 * Time: 下午8:12
 * To change this template use File | Settings | File Templates.
 */
public class EventDaoImp implements EventDao {

    private DataSource dataSource;

    public EventDaoImp(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List eventsTopTen() {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        ResultSet resultSet = null;
        List list = new ArrayList();
        String sql = "select  * from event  where ROWNUM <= 5  order by event_count desc";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EventBean eventBean = new EventBean();
                eventBean.setEventId(resultSet.getInt("event_id"));
                eventBean.setEventCount(resultSet.getInt("event_count"));
                eventBean.setEventTitle(resultSet.getString("event_title"));
                list.add(eventBean);
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
        return list;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public EventBean infoFindById(int id) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        ResultSet resultSet = null;
        EventBean eventBean = null;
        String sql = "select * from event WHERE event_id = ?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                eventBean = new EventBean();
                eventBean.setEventId(resultSet.getInt("event_id"));
                eventBean.setUserId(resultSet.getInt("user_id"));
                eventBean.setEventTitle(resultSet.getString("event_title"));
                eventBean.setEventKeywords(resultSet.getString("event_keywords"));
                eventBean.setEventDate(resultSet.getString("event_date"));
                eventBean.setEventPosted(resultSet.getString("event_posted"));
                eventBean.setEventLocation(resultSet.getString("event_location"));
                eventBean.setEventSummary(resultSet.getString("event_summary"));
                eventBean.setEventCount(resultSet.getInt("event_count"));
                eventBean.setEventRemark(resultSet.getString("event_remark"));
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
        return eventBean;
    }

    @Override
    public void updateClickCount(int offset, int id) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        String sql = "update event set event_count= event_count+? WHERE event_id=?";
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
    public int getCount(int userid) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        int count = 0;
        ResultSet resultSet = null;
        String sql = null;
        if (userid > 0) {
            sql = "select count(*) as countNum from event where user_id=" + userid;
        } else {
            sql = "select count(*) as countNum from event";
        }
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt("countNum");
            }
            resultSet.close();
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
    public List<EventBean> getList(Integer pageNumber, Integer pageSize, int useid) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        List<EventBean> list = new ArrayList<EventBean>();
        String sql = null;
        ResultSet resultSet = null;
        if (useid > 0) {
            sql = "SELECT * FROM (" +
                    "SELECT ROWNUM AS rn, t.* FROM   (" +
                    "SELECT t1.*,t2.USER_NAME FROM event t1,t_user t2 where t1.user_id=t2.user_id and t1.user_id=" + useid + " ORDER BY event_posted DESC) t) " +
                    "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        } else {
            sql = "SELECT * FROM (" +
                    "SELECT ROWNUM AS rn, t.* FROM   (" +
                    "SELECT t1.*,t2.USER_NAME FROM event t1,t_user t2 where t1.user_id=t2.user_id ORDER BY event_posted DESC) t) " +
                    "WHERE rn BETWEEN " + ((pageNumber - 1) * pageSize + 1) + " AND " + (pageNumber * pageSize);
        }
        try {
            connection = dataSource.getConnection();
            //System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EventBean obj = new EventBean();

                Integer eventId = resultSet.getInt("event_id");
                Integer userId = resultSet.getInt("user_id");
                String eventTitle = resultSet.getString("event_title");
                String eventKeywords = resultSet.getString("event_keywords");

                String eventDate = resultSet.getString("event_date");
                String eventPosted = resultSet.getString("event_posted");
                String eventLocation = resultSet.getString("event_location");
                String eventSummary = resultSet.getString("event_summary");
                Integer eventCount = resultSet.getInt("event_count");
                String eventRemark = resultSet.getString("event_remark");
                String USER_NAME = resultSet.getString("USER_NAME");


                obj.setEventId(eventId);
                obj.setUserId(userId);
                obj.setEventTitle(eventTitle);
                obj.setEventKeywords(eventKeywords);
                obj.setEventDate(eventDate);
                obj.setEventPosted(eventPosted);

                obj.setEventLocation(eventLocation);
                obj.setEventSummary(eventSummary);
                obj.setEventCount(eventCount);
                obj.setEventRemark(eventRemark);
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
    public Integer insertEvent(EventBean eventBean) {
        PreparedStatement preparedStatement=null;
        int num = -1;
        String sql = "insert into event  values(event_seq.NEXTVAL,?,?,?,?,?,?,?,?,?)";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, eventBean.getUserId());
            preparedStatement.setString(2, eventBean.getEventTitle());
            preparedStatement.setString(3, eventBean.getEventKeywords());
            preparedStatement.setString(4, eventBean.getEventDate());
            preparedStatement.setString(5, eventBean.getEventPosted());
            preparedStatement.setString(6, eventBean.getEventLocation());
            preparedStatement.setString(7, eventBean.getEventSummary());
            preparedStatement.setInt(8, eventBean.getEventCount());
            preparedStatement.setString(9, eventBean.getEventRemark());
            num = preparedStatement.executeUpdate();
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
        return num;
    }

    @Override
    public int updateEvent(EventBean eventBean) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        int flag = 0;
        String sql = "UPDATE event SET user_id=?,event_title=?,event_keywords=?,event_date=?,event_posted=?," +
                "event_location=?,event_summary=?,event_count=?,event_remark=? WHERE event_id=?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, eventBean.getUserId());
            preparedStatement.setString(2, eventBean.getEventTitle());
            preparedStatement.setString(3, eventBean.getEventKeywords());
            preparedStatement.setString(4, eventBean.getEventDate());
            preparedStatement.setString(5, eventBean.getEventPosted());
            preparedStatement.setString(6, eventBean.getEventLocation());
            preparedStatement.setString(7, eventBean.getEventSummary());
            preparedStatement.setInt(8, eventBean.getEventCount());
            preparedStatement.setString(9, eventBean.getEventRemark());
            preparedStatement.setInt(10, eventBean.getEventId());
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
    public void deleteEvents(int id) {
        PreparedStatement preparedStatement=null;
        Connection connection = null;
        String sql = "DELETE  FROM event WHERE event_id=?";
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
