package com.ivillarroelr.TIHI14evdiag.repo;

import com.ivillarroelr.TIHI14evdiag.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICountryRepo extends JpaRepository<Country, Integer> {
    @Query(value = "SELECT * FROM Country WHERE SHORTNAME=?1",nativeQuery = true)
    Country readByShortname(String shortname);
}
