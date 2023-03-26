/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.mgb.Repository;

import com.portfolio.mgb.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author user
 */
public interface RExperiencia extends JpaRepository<Experiencia,Integer> {
    
    public Optional<Experiencia> findByNombreE(String nombreE );
    public boolean existsByNombreE(String nombreE);
    
    
    
    
}
