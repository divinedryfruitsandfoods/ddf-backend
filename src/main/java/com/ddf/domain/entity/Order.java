package com.ddf.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;

    private String orderBy;

    private String orderPlacedDate;

    private int totalOrderPrice;

    @OneToOne
    @JoinColumn(name = "shipping_id")
    private Shipping shipping;

    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable=false)
    private Product product;

//    private Payment payment;
}
