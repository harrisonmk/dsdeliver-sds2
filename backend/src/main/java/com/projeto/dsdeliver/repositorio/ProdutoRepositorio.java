
package com.projeto.dsdeliver.repositorio;

import com.projeto.dsdeliver.modelo.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepositorio extends JpaRepository<Produto,Long> {
    
  //Ordena pelo nome do produto em ordem crescente  
  List<Produto> findAllByOrderByNomeAsc();  
    
}
