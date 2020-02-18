package com.sdy;

import java.sql.*;

public class JDBC {
    public static void main(String[] args) throws Exception {

        // 1. 注册驱动，但是不建议使用
        // 理由：1、导致驱动被注册两次；2、强烈依赖数据库的驱动jar
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        // 解决：使用反射！
        Class.forName("com.mysql.jdbc.Driver");
        // 2. 建立连接
        // URL:SUN公司与数据库厂商之间的一种协议。
        // jdbc:mysql://localhost:3306/day06
        // 协议 子协议  IP :端口号 数据库
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1997218*");
        // 3. 获取操作数据库的预处理对象
//        Statement statement = conn.createStatement();
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        // 获取结果集
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }

        String sql = "select * from account where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,"aaa");
        ResultSet resultSet = ps.executeQuery();


        rs.close();
        pstm.close();
        conn.close();

    }
}
