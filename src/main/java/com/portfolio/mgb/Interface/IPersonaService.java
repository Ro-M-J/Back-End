
package com.portfolio.mgb.Interface;

import com.portfolio.mgb.Entity.Persona;
import java.util.List;

public interface IPersonaService {
     //traer una persona
    public List<Persona> getPersona();
    
    //guardar un objeto de tipo persona
    public void savePersona(Persona persona);
    
    //eliminar usuario
    public void deletePersona(Long id);
            
    //buscar persona por id
            
    public Persona findPersona(Long  id);        
}
