/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.lizzy.tollizzyweb;

/**
 *
 * @author Elizabeth
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TolLizzyApp {

    public static void main(String[] args) {
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/jdbcejemplo";
        Connection conexion = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TolLizzyApp.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            
            // --- C - CREATE (Insertar un nuevo registro) ---
            System.out.println("--- INSERTANDO NUEVO REGISTRO ---");
            statement.executeUpdate("INSERT INTO usuarios (nombre, email) VALUES ('Erikson Romero', 'Erikson_romero29@gmail.com')");
            statement.executeUpdate("INSERT INTO usuarios (nombre, email) VALUES ('Hilda Garzon', 'Hilda_Garzon17@gmail.com')");
            statement.executeUpdate("INSERT INTO usuarios (nombre, email) VALUES ('Diana Poveda', 'Diana_Poveda05@gmail.com')");      
            System.out.println("Registro insertado con éxito.\n");
            
            // --- U - UPDATE (Actualizar el registro con id = 1) ---
            System.out.println("--- ACTUALIZANDO REGISTRO con id = 1 ---");
            String sqlUpdate = "UPDATE usuarios SET nombre = 'Erikson Romero Modificado', email = 'erikson.modificado@example.com' WHERE id = 1";
            int filasActualizadas = statement.executeUpdate(sqlUpdate);
            System.out.println("Filas actualizadas: " + filasActualizadas + "\n");
            
            // --- D - DELETE (Eliminar un registro, el id IN 4Y5) ---
            System.out.println("--- ELIMINANDO REGISTRO NO ACTUALIZADOS");
            String sqlDelete = "DELETE FROM usuarios where id IN(2, 3)";
            int filasEliminadas = statement.executeUpdate(sqlDelete);
            System.out.println("Filas eliminadas: " + filasEliminadas + "\n");
            
            // --- R - READ (Leer todos los registros para ver el resultado final) ---
            System.out.println("--- LEYENDO EL ESTADO FINAL DE LOS REGISTROS ---");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | Nombre: " + rs.getString("nombre") + " | Email: " + rs.getString("email"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TolLizzyApp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Este bloque se ejecuta siempre, asegurando que cerramos los recursos
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
                if (conexion != null) conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(TolLizzyApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}