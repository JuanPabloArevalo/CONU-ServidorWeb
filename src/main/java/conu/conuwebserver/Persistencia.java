/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conu.conuwebserver;

import java.sql.*;

/**
 *
 * @author Administrador
 */
public class Persistencia {

    public Persistencia() {
        String connectionString
                = "jdbc:sqlserver://proyectoconu.database.windows.net:1433;"
                + "database=BaseDatosBackend;"
                + "user=adminBD@proyectoconu;"
                + "password=Ab1234567890.;"
                + "encrypt=false;"
                + "trustServerCertificate=false;"
                + "hostNameInCertificate=*.database.windows.net;"
                + "loginTimeout=30;";
        System.out.println("conu.conuwebserver.Persistencia.<init>()"+connectionString);
        // Declare the JDBC objects.  
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement prepsInsertProduct = null;
String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(connectionString);

            // Create and execute an INSERT SQL prepared statement.  
            String insertSql = "INSERT INTO VITRINA (id, Nombre) VALUES "
                    + "(1, 'Junan');";
            prepsInsertProduct = connection.prepareStatement(
                    insertSql,
                    Statement.RETURN_GENERATED_KEYS);
            prepsInsertProduct.execute();

            // Retrieve the generated key from the insert.  
            resultSet = prepsInsertProduct.getGeneratedKeys();

            // Print the ID of the inserted row.  
            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the connections after the data has been handled.  
            if (prepsInsertProduct != null) {
                try {
                    prepsInsertProduct.close();
                } catch (Exception e) {
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception e) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                }
            }
        }
    }
}
