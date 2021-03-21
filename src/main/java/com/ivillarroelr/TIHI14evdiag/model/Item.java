package com.ivillarroelr.TIHI14evdiag.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Item {

    @Id
    private int ID;

    @Column(length = 100, nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category_id;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private char symbol;

    @ManyToOne
    @JoinColumn(name="currency_id", nullable=false)
    private Currency currency_id;

    @ManyToOne
    @JoinColumn(name="country_id", nullable=false)
    private Country country_id;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime modified_at;
}
