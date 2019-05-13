package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;

import com.example.demo.model.Loainhanvien;
import com.example.demo.payload.ApiResponse;
import com.example.demo.repository.LoaiNhanVienRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Api(value = "API thêm, lấy loại nhân viên, update trạng thái nhân viên")
public class LoaiNhanVienController {

    @Autowired
    LoaiNhanVienRepository lnvRepository;

    @GetMapping("/loainhanvien")
    public List<Loainhanvien> getAllLoaiNhanVien(){
        return lnvRepository.findAll();
    }
    @PutMapping("/updateLoaiNhanVien")
    public ResponseEntity<Object> updateTrangThai(@RequestHeader(value = "lnvma") Long lnvma,
                                       @RequestHeader(value = "trangthai")Boolean trangthai)
    {
        Optional<Loainhanvien> lnvopt = lnvRepository.findById(lnvma);
        Loainhanvien lnv  = lnvopt.get();
        lnv.setLnvTrangthai(trangthai);
        lnvRepository.save(lnv);
        return ResponseEntity.ok().body(new ApiResponse(true,"sửa trạng thái thành công"));
    }
    @PostMapping("/themLoaiNhanVien")
    public ResponseEntity<Object> themLoaiNhanVien(
                                        @RequestHeader(value = "tenloainhanvien") String tenloainhanvien){
        Loainhanvien lnv = new Loainhanvien(tenloainhanvien);
        lnvRepository.save(lnv);
        return ResponseEntity.ok().body(new ApiResponse(true,"Thêm thành công"));
    }

}
