/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.view1;

import com.data.Conexion;

public class U3_Base_de_datos {

    public static void main(String[] args) {
       
        Conexion miConexion = new Conexion();
        
        miConexion.conectar();
        
    }
}
