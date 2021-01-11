package com.projeto.dsdeliver.dto;

import com.projeto.dsdeliver.modelo.Ordem;
import com.projeto.dsdeliver.modelo.OrderStatus;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrdemDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Long id;

    private String endereco;

    private Double latitude;

    private Double longitude;

    private Instant momento;

    private OrderStatus status;
    
    private Double total;

    private List<ProdutoDTO> produtos = new ArrayList<>();

    public OrdemDTO(Long id, String endereco, Double latitude, Double longitude, Instant momento, OrderStatus status,Double total) {
        this.id = id;
        this.endereco = endereco;
        this.latitude = latitude;
        this.longitude = longitude;
        this.momento = momento;
        this.status = status;
        this.total = total;
    }

    public OrdemDTO(Ordem ordem) {
        this.id = ordem.getId();
        this.endereco = ordem.getEndereco();
        this.latitude = ordem.getLatitude();
        this.longitude = ordem.getLongitude();
        this.momento = ordem.getMomento();
        this.status = ordem.getStatus();
        this.total = ordem.getTotal();
        produtos = ordem.getProdutos().stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
    }

    public OrdemDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

 
    
    

}
