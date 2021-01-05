package com.projeto.dsdeliver.servico;

import com.projeto.dsdeliver.dto.OrdemDTO;
import com.projeto.dsdeliver.dto.ProdutoDTO;
import com.projeto.dsdeliver.modelo.Ordem;
import com.projeto.dsdeliver.modelo.OrderStatus;
import com.projeto.dsdeliver.modelo.Produto;
import com.projeto.dsdeliver.repositorio.OrdemRepositorio;
import com.projeto.dsdeliver.repositorio.ProdutoRepositorio;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdemServico {

    @Autowired
    private OrdemRepositorio ordemRepositorio;

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    //LISTAGEM
    @Transactional(readOnly = true) //apenas para operacao de leitura
    public List<OrdemDTO> findAll() {

        List<Ordem> ordens = ordemRepositorio.findOrdersWithProducts();

        return ordens.stream().map(x -> new OrdemDTO(x)).collect(Collectors.toList());

    }

    
    //INSERT
    @Transactional(readOnly = false) //apenas para operacao de escrita
    public OrdemDTO insert(OrdemDTO dto) {

        Ordem ordem = new Ordem(null, dto.getEndereco(), dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PENDENTE);

        for (ProdutoDTO p : dto.getProdutos()) {

            Produto produto = produtoRepositorio.getOne(p.getId());
            ordem.getProdutos().add(produto);

        }

        ordem = ordemRepositorio.save(ordem);
        
        return new OrdemDTO(ordem);

    }

    
    
    //UPDATE
   @Transactional(readOnly = false) //apenas para operacao de escrita
   public OrdemDTO setDelivered(Long id){
       
     Ordem ordem = ordemRepositorio.getOne(id);
     ordem.setStatus(OrderStatus.ENTREGUE);
     ordem = ordemRepositorio.save(ordem);
     
     return new OrdemDTO(ordem);
       
   }
    
    
    
}
