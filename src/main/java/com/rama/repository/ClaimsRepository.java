package com.rama.repository;

import com.rama.model.claims;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimsRepository extends JpaRepository<claims,String> {
}
