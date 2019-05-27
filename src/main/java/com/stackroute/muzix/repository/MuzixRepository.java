package com.stackroute.muzix.repository;


import com.stackroute.muzix.domain.Muzix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MuzixRepository extends JpaRepository<Muzix,Integer> {

    @Query(value="select * from muzix where track_name=?" ,nativeQuery=true)
    public List<Muzix> searchByName(String trackName);

}
