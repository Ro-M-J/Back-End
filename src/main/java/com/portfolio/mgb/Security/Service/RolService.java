
package com.portfolio.mgb.Security.Service;

import com.portfolio.mgb.Security.Enums.RolNombre;
import com.portfolio.mgb.Security.Repository.iRolRepository;
//import com.portfolio.mgb.Security.Entity.Rol;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.mgb.Security.Entity.Rol;


//clase rol service con funciones
@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
      return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save (Rol rol){
      irolRepository.save(rol);
    
    }

}
