package com.ivillarroelr.TIHI14evdiag.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int item_id;

    @Column(length = 100, nullable = false)
    private String title;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category_id;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false, length = 10)
    private String symbol;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="currency_id", nullable=false)
    private Currency currency_id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="country_id", nullable=false)
    private Country country_id;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime modified_at;
}
