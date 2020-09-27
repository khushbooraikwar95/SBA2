package com.eval.coronakit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eval.coronakit.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
