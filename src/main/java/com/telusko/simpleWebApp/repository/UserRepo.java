package com.telusko.simpleWebApp.repository;

import com.telusko.simpleWebApp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {

    public Users findByName(String name);
}
