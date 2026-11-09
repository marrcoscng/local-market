package br.com.market.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

// Table under development

public class Order {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 36, unique = true)
    private UUID orderCode;
    @Column(nullable = false)
    private LocalDateTime orderMoment;

    // Add Customer -> Cliente.

}
