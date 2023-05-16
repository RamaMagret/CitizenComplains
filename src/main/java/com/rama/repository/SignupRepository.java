package com.rama.repository;

import com.rama.model.Signup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SignupRepository extends JpaRepository <Signup,String> {
}
