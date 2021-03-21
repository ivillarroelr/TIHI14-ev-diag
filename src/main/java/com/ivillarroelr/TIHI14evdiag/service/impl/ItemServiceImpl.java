package com.ivillarroelr.TIHI14evdiag.service.impl;

import com.ivillarroelr.TIHI14evdiag.model.Item;
import com.ivillarroelr.TIHI14evdiag.repo.IItemRepo;
import com.ivillarroelr.TIHI14evdiag.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements IItemService<Item> {

    @Autowired
    private IItemRepo repo;

    @Override
    public Item save(Item item) {
        return repo.save(item);
    }

    @Override
    public Item modify(Item item) {
        return repo.save(item);
    }

    @Override
    public List<Item> listAll() {
        return repo.findAll();
    }

    @Override
    public Page<Item> listAllPaginable(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Item readById(Integer id) {
        Optional<Item> op = repo.findById(id);
        return op.orElseGet(Item::new);
    }

    @Override
    public boolean delete(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
