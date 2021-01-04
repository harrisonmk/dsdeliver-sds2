
package com.projeto.dsdeliver.repositorio;

import com.projeto.dsdeliver.modelo.Ordem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrdemRepositorio extends JpaRepository<Ordem,Long> {
    
}
