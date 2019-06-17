package com.example.serviceBase.Repository;

import com.example.serviceBase.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
}
