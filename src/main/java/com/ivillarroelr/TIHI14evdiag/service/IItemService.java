package com.ivillarroelr.TIHI14evdiag.service;

import com.ivillarroelr.TIHI14evdiag.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IItemService<Object> {

    Item save(Item item);
    Item modify(Item item);
    List<Item> listAll();
    Page<Item> listAllPaginable(Pageable pageable);
    Item readById(Integer id);
    boolean delete(Integer id);

}
