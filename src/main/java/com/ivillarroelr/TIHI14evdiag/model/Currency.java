package com.ivillarroelr.TIHI14evdiag.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "currency")
@EqualsAndHashCode(exclude = {"items"})
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int currency_id;

    @Column(length = 3, nullable = false)
    private String shortname;

    @Column(length = 100, nullable = false)
    private String longname;

    @Column(length = 10)
    private String symbol;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy="currency_id")
    @Fetch(value= FetchMode.SELECT)
    private Set<Item> items;
}
