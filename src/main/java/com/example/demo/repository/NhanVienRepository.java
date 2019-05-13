package com.example.demo.repository;

import com.example.demo.model.Nhanvien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NhanVienRepository extends JpaRepository<Nhanvien, Long> {
}
