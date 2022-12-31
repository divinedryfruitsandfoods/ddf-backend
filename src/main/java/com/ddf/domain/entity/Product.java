package com.ddf.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int id;

    private String productName;

    private String productImageUrl;

    private String productDescription;

    private int productPrice;

    private String quality;

    private String quantity;

    private String flavour;

    private int weight;

    private String weightType;

    private String form;

    private String createdBy;

    private String updatedBy;

    private String updatedOn;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval=true)
    List<Order> orders;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval=true)
    List<Review> reviews;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable=false)
    private Category category;
}
