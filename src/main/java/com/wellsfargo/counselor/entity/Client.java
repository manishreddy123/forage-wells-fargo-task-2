package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private FinancialAdvisor financialAdvisor;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Portfolio portfolio;

    public Client() {}

    public Client(String name, String email, String phone, FinancialAdvisor financialAdvisor) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.financialAdvisor = financialAdvisor;
    }

    // Getters and Setters
}
