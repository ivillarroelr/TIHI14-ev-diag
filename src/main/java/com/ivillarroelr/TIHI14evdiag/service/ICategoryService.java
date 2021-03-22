package com.ivillarroelr.TIHI14evdiag.service;

import com.ivillarroelr.TIHI14evdiag.model.Category;

public interface ICategoryService<Object> {
    Category readById(Integer id);
}
