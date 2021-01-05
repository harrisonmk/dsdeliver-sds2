
package com.projeto.dsdeliver.servico;

import com.projeto.dsdeliver.dto.OrdemDTO;
import com.projeto.dsdeliver.modelo.Ordem;
import com.projeto.dsdeliver.repositorio.OrdemRepositorio;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdemServico {
    
    @Autowired
    private OrdemRepositorio ordemRepositorio;
    
    @Transactional(readOnly = true) //apenas para operacao de leitura
    public List<OrdemDTO> findAll(){
        
     List<Ordem> ordens = ordemRepositorio.findOrdersWithProducts();
     
     return ordens.stream().map(x -> new OrdemDTO(x)).collect(Collectors.toList());
        
    }
      
    
}
