package com.company.bdclass;

import com.company.Reactors;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBProvider {
    DBBuilder builder;
    Connection conn;
    Statement stat;

    public DBProvider(DBBuilder builder) {
        this.builder = builder;
    }

    public void connect() throws SQLException {
        String FullPath = "C:\\Влад\\Мифи\\Laba4-1.0\\" + builder.getDBName() + ".accdb";
        conn = DriverManager.getConnection("jdbc:ucanaccess://" + FullPath, "", "");
        System.err.println(conn.getClientInfo().toString());
        stat = conn.createStatement();
    }

    public void getAll(String s, ArrayList<Reactors> Re) throws SQLException {
        String SQLQuery = getQuery(1, s);
        boolean A = stat.execute(SQLQuery);
        ResultSet res = stat.getResultSet();
        builder.handle(res, s, Re);
    }

    public void close() throws SQLException {
        conn.close();
    }

    private String getQuery(int qId, String s) {
        String SQLQuery;
        switch (qId) {
            case (1) -> SQLQuery = builder.getAllQuery(s);
            default -> {
                System.err.println("Не верный идентификатор запроса");
                SQLQuery = null;
                throw new Error("Не верный идентификатор запроса");
            }
        }
        return SQLQuery;
    }
}
