package com.spring.repositories;

import com.spring.entities.onetomany.MobileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MobileRepository extends JpaRepository<MobileEntity, Integer> {

    @Query("SELECT u FROM MobileEntity u WHERE u.id=:id")
    Optional<MobileEntity> getMobileByUserId(@Param("id") int id);

}
