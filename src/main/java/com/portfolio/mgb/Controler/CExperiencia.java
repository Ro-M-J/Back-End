/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mgb.Controler;

import com.portfolio.mgb.Dto.dtoExpericia;
import com.portfolio.mgb.Entity.Experiencia;
import com.portfolio.mgb.Security.Controller.Mensaje;
import com.portfolio.mgb.Service.SExperiencia;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("explab")
@CrossOrigin(origins ="http://localhost:4200")
public class CExperiencia {
    
    @Autowired
    SExperiencia sExperiencia;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>>list(){
    
      List<Experiencia>list=sExperiencia.list();
      
      return new ResponseEntity(list ,HttpStatus.OK);
    }
    
    
    @PostMapping("/create")
    public ResponseEntity<?>create(@RequestBody dtoExpericia dtoexp)
    {
        if(StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity (new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        if(sExperiencia.existsByNombreE(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("Esa experincia Existe"),HttpStatus.BAD_REQUEST);
        //si se repite trabjo solo se pone una vez
        
        Experiencia experiencia =new Experiencia(dtoexp.getNombreE(),dtoexp.getDescripcionE()); 
        sExperiencia.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experincia agregada"),HttpStatus.OK);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id , @RequestBody dtoExpericia dtoexp){
    
          if(!sExperiencia.existsById(id))
              return new ResponseEntity(new Mensaje("El Id NO EXISTE "),HttpStatus.BAD_REQUEST);
          if(!sExperiencia.existsByNombreE(dtoexp.getNombreE()) && sExperiencia.getByNombreE(dtoexp.getNombreE()).get().getId()!= id)
              return new ResponseEntity(new Mensaje("Esa experincia ya existe"),HttpStatus.BAD_REQUEST);
       
          
          if(StringUtils.isBlank(dtoexp.getNombreE()))
              return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"),HttpStatus.OK);
         
          
          Experiencia experiencia=sExperiencia.getOne(id).get();
          experiencia.setNombreE(dtoexp.getNombreE());
          experiencia.setDescripcionE(dtoexp.getDescripcionE());
          
          sExperiencia.save(experiencia);
          
          return new ResponseEntity(new Mensaje ("Experiencia Actualizada"),HttpStatus.OK);
          
        }
    
    public ResponseEntity<?> delete(@PathVariable("id") int id ){
    
        //si no existe ID 
      if(!sExperiencia.existsById(id))
              return new ResponseEntity(new Mensaje("El Id NO EXISTE "),HttpStatus.BAD_REQUEST);
      
      sExperiencia.delete(id);
      
      return new ResponseEntity(new Mensaje("Expeicnia eliminada"),HttpStatus.OK);
    }
    
   
    
    
}
