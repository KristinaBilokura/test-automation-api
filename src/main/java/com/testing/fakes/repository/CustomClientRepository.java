package com.testing.fakes.repository;

import com.testing.fakes.entity.CustomClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomClientRepository extends JpaRepository<CustomClient, Long> {
}
