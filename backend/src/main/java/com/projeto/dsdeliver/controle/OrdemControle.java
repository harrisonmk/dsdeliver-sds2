
package com.projeto.dsdeliver.controle;

import com.projeto.dsdeliver.dto.OrdemDTO;
import com.projeto.dsdeliver.servico.OrdemServico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "orders")
public class OrdemControle {
    
    @Autowired
    OrdemServico ordemServico;

    
    
    @GetMapping
    public ResponseEntity<List<OrdemDTO>> findAll() {

        List<OrdemDTO> list = ordemServico.findAll();

        return ResponseEntity.ok().body(list);
    }

    
}
