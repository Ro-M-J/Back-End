/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mgb.Security.Controller;

import org.springframework.http.HttpStatus;
//mensaje q se teinen q imprimir si funciona, lo podemos ver nosotros por pantalla
public class Mensaje {
 
     private String mensaje;
     
    
    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje=mensaje;
    }

    public Mensaje(String noexiste_id, HttpStatus httpStatus) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    

    
    
}
