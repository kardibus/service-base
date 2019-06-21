package com.example.serviceBase.Repository;

import com.example.serviceBase.Entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users,Long> {
}
