package com.ivillarroelr.TIHI14evdiag.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ItemDTO implements Serializable {
    private String title;
    private int price;
    private String currency;
    private String country;
    private int category_id;
}
