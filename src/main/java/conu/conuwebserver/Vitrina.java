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
import java.util.HashSet;
import java.util.Set;

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
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement prepsInsertProduct = null;
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        Class.forName(driver).newInstance();
        connection = DriverManager.getConnection(connectionString);
        String insertSql = "INSERT INTO VITRINA (nombres, apellidos, telefono, empresa, direccion, correo) VALUES ('"+nombres+"', '"+apellidos+"', '"+telefono+"', '"+empresa+"', '"+direccion+"', '"+correo+"');";
        prepsInsertProduct = connection.prepareStatement(insertSql,Statement.RETURN_GENERATED_KEYS);
        prepsInsertProduct.execute();
        resultSet = prepsInsertProduct.getGeneratedKeys();
        while (resultSet.next()) {
            System.out.println("Generated: " + resultSet.getString(1));
        } 
        if (prepsInsertProduct != null) {
            prepsInsertProduct.close();
        }
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
                statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
    
    public static Set<Vitrina> getAll() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        String connectionString
        = "jdbc:sqlserver://proyectoconu.database.windows.net:1433;"
        + "database=BaseDatosBackend;"
        + "user=adminBD@proyectoconu;"
        + "password=Ab1234567890.;"
        + "encrypt=false;"
        + "trustServerCertificate=false;"
        + "hostNameInCertificate=*.database.windows.net;"
        + "loginTimeout=30;";

        // Declare the JDBC objects.  
        Connection connection = null;  
        Statement statement = null;   
        ResultSet resultSet = null;  
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        Class.forName(driver).newInstance();
        connection = DriverManager.getConnection(connectionString);  

        // Create and execute a SELECT SQL statement.  
        String selectSql = "SELECT id, nombres, apellidos, telefono, empresa, direccion, correo FROM VITRINA";  
        statement = connection.createStatement();  
        resultSet = statement.executeQuery(selectSql);  

            // Print results from select statement  
        Set<Vitrina> vitrinas = new HashSet<>();
        Vitrina vitrina;
        while (resultSet.next()){  
            vitrina = new Vitrina(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
            vitrinas.add(vitrina);
        }  
            // Close the connections after the data has been handled.  
        if (resultSet != null)  { resultSet.close(); }  
        if (statement != null) { statement.close(); } 
        if (connection != null)  { connection.close(); }  
        
        return vitrinas;
    }
}
