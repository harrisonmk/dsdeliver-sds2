package com.projeto.dsdeliver.dto;

import com.projeto.dsdeliver.modelo.Produto;
import java.io.Serializable;

public class ProdutoDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private Double preco;

    private String descricao;

    private String imagemUri;

    public ProdutoDTO(Long id, String nome, Double preco, String descricao, String imagemUri) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.imagemUri = imagemUri;
    }

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.descricao = produto.getDescricao();
        this.imagemUri = produto.getImageUri();
    }

    
    public ProdutoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagemUri() {
        return imagemUri;
    }

    public void setImagemUri(String imagemUri) {
        this.imagemUri = imagemUri;
    }

    
    
    
    
    
}
