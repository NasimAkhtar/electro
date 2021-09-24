package com.example.electro.repository;

import com.example.electro.entity.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Repository
public interface ApplianceRepo extends JpaRepository<Appliance, Long> {

    @Modifying
    @Query("update Appliance app set app.lastOnline = ?1 where app.aid = ?2")
    @Transactional
    int updateLastOnline(Timestamp status, String aid);
}
