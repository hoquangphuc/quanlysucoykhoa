package com.example.demo.repository;

import com.example.demo.model.Phong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhongRepository extends JpaRepository<Phong, Long> {
}
