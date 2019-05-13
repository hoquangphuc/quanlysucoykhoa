package com.example.demo.repository;


import com.example.demo.model.Loainhanvien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoaiNhanVienRepository extends JpaRepository<Loainhanvien, Long> {
    Optional<Loainhanvien> findById(Long id);
}
