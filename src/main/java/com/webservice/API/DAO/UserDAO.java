package com.webservice.API.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservice.API.Model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
}
