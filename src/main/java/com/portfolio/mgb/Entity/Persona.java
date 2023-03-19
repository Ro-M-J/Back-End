
package com.portfolio.mgb.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

//@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min=1,max=50,message="NO cumple con Longitud")
    private String nombre;
    
    @NotNull
    @Size(min=1,max=50,message="NO cumple con Longitud")
    private String apellido;
    
    
    @Size(min=1,max=50,message="NO cumple con Longitud")
    private String img; //imagen de portada,lo seteo desde angular


 //crear get and set 
    public Long getId(){
    return id;
    }
    public void setId(Long id){
     this.id=id;
    }
    public String getNombre(){
    return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    public String getApellido(){
    return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido=apellido;
    }

    public String getImg(){
    return img;
    }
    public void setImg(String img) {
      this.img=img;
    }
      




}
