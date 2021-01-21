package com.projeto.dsdeliver.controle;

import com.projeto.dsdeliver.dto.OrdemDTO;
import com.projeto.dsdeliver.servico.OrdemServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@Tag( name = "Api Rest Ordens")
@RestController
@RequestMapping(value = "/orders")
public class OrdemControle {

    @Autowired
    OrdemServico ordemServico;

    
    @Operation(summary="Retorna uma lista de ordens") 
    @GetMapping
    public ResponseEntity<List<OrdemDTO>> findAll() {

        List<OrdemDTO> list = ordemServico.findAll();

        return ResponseEntity.ok().body(list);
    }

    
    @Operation(summary="salva uma ordem") 
    @PostMapping
    public ResponseEntity<OrdemDTO> insert(@RequestBody OrdemDTO dto) {

        dto = ordemServico.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);

    }

    
    @Operation(summary="atualiza status da ordem") 
    @PutMapping("/{id}/delivered")
    public ResponseEntity<OrdemDTO> setDelivered(@PathVariable Long id) {

        OrdemDTO dto = ordemServico.setDelivered(id);

        return ResponseEntity.ok().body(dto);
    }

    
    
    
}
