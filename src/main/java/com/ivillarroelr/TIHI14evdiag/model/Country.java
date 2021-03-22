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
@Table(name = "country")
@EqualsAndHashCode(exclude = {"items"})
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int country_id;

    @Column(length = 100, nullable = false)
    private String longname;

    @Column(length = 3, nullable = false)
    private String shortname;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy="country_id")
    @Fetch(value= FetchMode.SELECT)
    private Set<Item> items;
}
