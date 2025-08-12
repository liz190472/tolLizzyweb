/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Elizabeth
 * 
 */
import java.sql.*;
import java.math.BigDecimal; // Importamos la clase BigDecimal


public class ProductosDAO {

    public void insertarProducto(Connection conexion, String referencia, BigDecimal gramos, String tamanio, String color, BigDecimal valorUnitario, int estado) throws SQLException {
        
        String sql = "INSERT INTO productos (ean, referencia, gramos, tamano, color, valorUnitario, estado) VALUES ('7703347542028', 'toallaHoteleraLisa', 550, '70X140',75.000, 1)";
            try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, referencia);
            pstmt.setBigDecimal(2, gramos); // Usamos setBigDecimal para gramos
            pstmt.setString(3, tamanio);
            pstmt.setString(4, color);
            pstmt.setBigDecimal(5, valorUnitario); // Usamos setBigDecimal para valorUnitario
            pstmt.setInt(6, estado);
            pstmt.executeUpdate();
            System.out.println("Producto insertado con éxito.\n");
        }
    }
}