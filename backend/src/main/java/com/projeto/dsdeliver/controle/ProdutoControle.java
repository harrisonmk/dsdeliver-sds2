package com.projeto.dsdeliver.controle;

import com.projeto.dsdeliver.dto.ProdutoDTO;
import com.projeto.dsdeliver.servico.ProdutoServico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "products")
public class ProdutoControle {

    @Autowired
    ProdutoServico produtoServico;

    
    
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll() {

        List<ProdutoDTO> list = produtoServico.findAll();

        return ResponseEntity.ok().body(list);
    }

    
    
    
    
}
