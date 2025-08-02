package org.myfinanceapp.financeapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    public enum TransactionType {
    INCOME,
    EXPENSE
}

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double amount;
    private String date;
    private TransactionType type;
    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
