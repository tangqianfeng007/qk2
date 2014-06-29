package com.qk.dao.impl;


import com.qk.dao.BitResultDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BitResultDaoImpl implements BitResultDao {

    private DataSource dataSource;

    public BitResultDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Boolean insertBitResultBycfbIdAnduserId(Integer cfb_id, Integer cfb_user) {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        boolean flag = false;
        String sql = "update callforbit set cfb_user=?,cfb_status=? where cfb_id=?";
        ResultSet resultSet = null;
        try {
            System.out.println(sql);
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cfb_user);
            preparedStatement.setString(2, "1");
            preparedStatement.setInt(3, cfb_id);
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
}
