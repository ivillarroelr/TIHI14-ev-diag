package com.ivillarroelr.TIHI14evdiag.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Category {
    @Id
    private int ID;

    @Column(length = 100, nullable = false)
    private String name;

    @OneToMany(mappedBy="category_id")
    private Set<Item> items;
}
