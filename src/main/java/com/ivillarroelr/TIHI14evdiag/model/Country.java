package com.ivillarroelr.TIHI14evdiag.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Country {

    @Id
    private int ID;

    @Column(length = 100, nullable = false)
    private String longname;

    @Column(length = 3, nullable = false)
    private String shortname;

    @OneToMany(mappedBy="country_id")
    private Set<Item> items;
}
