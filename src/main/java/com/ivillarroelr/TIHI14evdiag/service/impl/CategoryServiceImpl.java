package com.ivillarroelr.TIHI14evdiag.service.impl;

import com.ivillarroelr.TIHI14evdiag.model.Category;
import com.ivillarroelr.TIHI14evdiag.repo.ICategoryRepo;
import com.ivillarroelr.TIHI14evdiag.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService<Category> {

    @Autowired
    private ICategoryRepo repo;

    @Override
    public Category readById(Integer id) {
        Optional<Category> op = repo.findById(id);
        return op.orElseGet(Category::new);
    }
}
