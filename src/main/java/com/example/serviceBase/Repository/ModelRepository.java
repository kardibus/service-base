package com.example.serviceBase.Repository;

import com.example.serviceBase.Entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Long> {
}
