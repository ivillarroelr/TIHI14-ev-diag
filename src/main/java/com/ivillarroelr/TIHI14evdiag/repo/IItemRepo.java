package com.ivillarroelr.TIHI14evdiag.repo;

import com.ivillarroelr.TIHI14evdiag.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemRepo extends JpaRepository<Item, Integer> {
    Page<Item> findAll(Pageable pageable);
}