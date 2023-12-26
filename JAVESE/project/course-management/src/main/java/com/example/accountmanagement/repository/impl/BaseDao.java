package com.example.accountmanagement.repository.impl;

//import com.example.accountmanagement.exception.AccountException;
import com.example.accountmanagement.exception.AccountException;
import com.example.accountmanagement.mapper.RowMapper;
import com.example.accountmanagement.repository.Dao;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BaseDao<T> implements Dao<T> {
    private Connection con;
    private PreparedStatement ps;


    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String dbName = "accountjdbc";
        String userName = "root";
        String password = "minhdang2804";

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://" + hostName + ":3306/" + dbName + "?useSSL=false", userName, password);
    }

    private void setParameter(PreparedStatement ps, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof Long) {
                    ps.setLong(index, (Long) parameter);
                } else if (parameter instanceof String) {
                    ps.setString(index, (String) parameter);
                } else if (parameter instanceof Integer) {
                    ps.setInt(index, (Integer) parameter);
                } else if (parameter instanceof Timestamp) {
                    ps.setTimestamp(index, (Timestamp) parameter);
                } else if (parameter instanceof Date) {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String strDate = dateFormat.format(parameter);
                    ps.setDate(index, java.sql.Date.valueOf(strDate));
                } else if (parameter instanceof Double) {
                    ps.setDouble(index, (Double) parameter);
                }else if (parameter instanceof Boolean) {
                    ps.setBoolean(index, (Boolean) parameter);
                }else if (parameter instanceof java.util.Date) {
                    ps.setDate(index, new Date(((java.util.Date)parameter).getTime()));
                } else {
                    ps.setString(index, null);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> list = new ArrayList<>();
        con = null;
        ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            setParameter(ps, parameters);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rowMapper.mapRow(rs));
            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new AccountException(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Boolean insert(String sql, Object... parameters) {
        this.con = null;
        this.ps = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            setParameter(ps, parameters);
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Boolean update(String sql, Object... parameters) {
        con = null;
        ps = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            setParameter(ps, parameters);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Boolean delete(String sql, Object... parameters) {
        con = null;
        ps = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            setParameter(ps, parameters);
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}