/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conu.conuwebserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrador
 */
public class Vitrina {
    private String nombres;
    private String apellidos;
    private String telefono;
    private String empresa;
    private String direccion;
    private String correo;
    
    public Vitrina(){
        
    }

    public Vitrina(String nombres, String apellidos, String telefono, String empresa, String direccion, String correo){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.empresa = empresa;
        this.direccion = direccion;
        this.correo = correo;
    }
    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    public void insertar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
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
//        try {
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(connectionString);
            String insertSql = "INSERT INTO VITRINA (nombres, apellidos, telefono, empresa, direccion, correo) VALUES ('"+nombres+"', '"+apellidos+"', '"+telefono+"', '"+empresa+"', '"+direccion+"', '"+correo+"');";
            prepsInsertProduct = connection.prepareStatement(insertSql,Statement.RETURN_GENERATED_KEYS);
            prepsInsertProduct.execute();
            // Retrieve the generated key from the insert.  
            resultSet = prepsInsertProduct.getGeneratedKeys();
            // Print the ID of the inserted row.  
            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));
            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
            // Close the connections after the data has been handled.  
            if (prepsInsertProduct != null) {
//                try {
                    prepsInsertProduct.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }
            if (resultSet != null) {
//                try {
                    resultSet.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }
            if (statement != null) {
//                try {
                    statement.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }
            if (connection != null) {
//                try {
                    connection.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }
//        }
    }
}
