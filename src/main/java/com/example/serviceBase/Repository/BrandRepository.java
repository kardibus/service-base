package com.example.serviceBase.Repository;

import com.example.serviceBase.Entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Long> {
}
