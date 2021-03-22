package com.ivillarroelr.TIHI14evdiag.repo;

import com.ivillarroelr.TIHI14evdiag.model.Country;
import com.ivillarroelr.TIHI14evdiag.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICurrencyRepo extends JpaRepository<Currency, Integer> {
    @Query(value = "SELECT * FROM Currency WHERE SHORTNAME=?1",nativeQuery = true)
    Currency readByShortname(String shortname);

    @Query(value = "SELECT symbol FROM Currency WHERE SHORTNAME=?1",nativeQuery = true)
    String getSymbolByShortname(String shortname);
}
