
package com.projeto.dsdeliver.servico;

import com.projeto.dsdeliver.dto.ProdutoDTO;
import com.projeto.dsdeliver.modelo.Produto;
import com.projeto.dsdeliver.repositorio.ProdutoRepositorio;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoServico {
    
    
    @Autowired
    private ProdutoRepositorio produtoRepositorio;
    
    @Transactional(readOnly = true) //apenas para operacao de leitura
    public List<ProdutoDTO> findAll(){
        
     List<Produto> produtos = produtoRepositorio.findAllByOrderByNomeAsc();
     
     return produtos.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
        
    }
    
    
}
