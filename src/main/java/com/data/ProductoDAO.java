/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.data;


import com.model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leo
 */
public class ProductoDAO {
    Conexion miConexion = new Conexion();
    
    public List<Producto> consultar(){
        List<Producto> lista = new ArrayList<>();
        String sql = "select * from productos ORDER BY idProducto;";
        
        try{
        Connection con = miConexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        
        while (rs.next()){
        Producto p = new Producto();
        p.setIdProducto(rs.getInt("idProducto"));
        p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getDouble("precio"));
                p.setCantidad(rs.getInt("cantidad"));

                lista.add(p);
        }
        
        } catch (Exception ex){
        System.out.println("Exception =" + ex.toString());
        }
        
        return lista;
        
    }
    
    public void guardar(Producto producto){
    String sql = "insert into productos (nombre, descripcion, precio, cantidad) values(?,?,?,?);";
    
    try{
    Connection con = miConexion.conectar();
    PreparedStatement ps = con.prepareStatement(sql);
    
    ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getCantidad());

            ps.executeUpdate();
    }catch (SQLException ex) {
    System.out.println("Exception: " + ex.toString());
    }
    }
    
    public void eliminar(int idProducto){
    String sql = "delete from productos where idProducto = ?;";
    
    try{
    Connection con = miConexion.conectar();
    PreparedStatement ps = con.prepareStatement(sql);
    
    ps.setInt(1, idProducto);
    
    ps.executeUpdate();
    
    }catch (SQLException ex){
    System.out.println("Exception: " + ex.toString());
    }
    }
    
    public void actualizar(Producto producto) {
        String sql = "update productos set "
                + "nombre = ?, "
                + "descripcion = ?, "
                + "precio = ?, "
                + "cantidad = ? "
                + "where idProducto = ?";

        try {
            Connection con = miConexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getCantidad());
            ps.setInt(5, producto.getIdProducto());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.toString());
        }
    }
}
