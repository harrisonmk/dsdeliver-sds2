package com.projeto.dsdeliver.controle;

import com.projeto.dsdeliver.dto.ProdutoDTO;
import com.projeto.dsdeliver.servico.ProdutoServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag( name = "Api Rest Produtos")
@RestController
@RequestMapping(value = "/products")
public class ProdutoControle {

    @Autowired
    ProdutoServico produtoServico;

    
    @Operation(summary="Retorna uma lista de produtos") 
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll() {

        List<ProdutoDTO> list = produtoServico.findAll();

        return ResponseEntity.ok().body(list);
    }

    
    
    
    
}
