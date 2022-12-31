package com.ddf.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private String flat;
    private String floor;
    private String buildingName;
    private String streetName;
    private String city;
    private String state;
    private int pinCode;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable=false)
    private User user;
    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
