package com.github.nettybook.ch7.junit;

import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class Snippet {
    @Test
    public void testZeroLengthString() {
//        Server hsqlServer = null;
//        Connection connection = null;
//        ResultSet rs = null;
//
//        hsqlServer = new Server();
//        hsqlServer.setLogWriter(null);
//        hsqlServer.setSilent(true);
//        hsqlServer.setDatabaseName(0, "iva");
//        hsqlServer.setDatabasePath(0, "file:ivadb");
//
//        hsqlServer.start();
//
//        // making a connection
//        try {
//            Class.forName("org.hsqldb.jdbcDriver");
//            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/iva", "sa", ""); // can
//                                                                                                    // through
//                                                                                                    // sql
//                                                                                                    // exception
//            connection.prepareStatement("drop table barcodes if exists;").execute();
//            connection.prepareStatement("create table barcodes (id integer, barcode varchar(20) not null);").execute();
//            connection.prepareStatement("insert into barcodes (id, barcode)" + "values (1, '12345566');").execute();
//
//            // query from the db
//            rs = connection.prepareStatement("select id, barcode  from barcodes;").executeQuery();
//            rs.next();
//            System.out.println(String.format("ID: %1d, Name: %1s", rs.getInt(1), rs.getString(2)));
//
//        }
//        catch (SQLException e2) {
//            e2.printStackTrace();
//        }
//        catch (ClassNotFoundException e2) {
//            e2.printStackTrace();
//        }
//
//        hsqlServer.stop();
//        hsqlServer = null;
    }
}
