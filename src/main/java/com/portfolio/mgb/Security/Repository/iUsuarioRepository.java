
package com.portfolio.mgb.Security.Repository;

import com.portfolio.mgb.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//inteface usaurio repo
@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario ,Integer> {
    Optional<Usuario>findByNombreUsuario(String nombreUsuario);
    boolean existsByNombreUsuario(String nombreUusario); 
    boolean existsByEmail(String nombreUusario); 

   // public boolean exitsByNombreUsuario(String nombreUsuario);

   // public boolean exitsByEmail(String email);
}
