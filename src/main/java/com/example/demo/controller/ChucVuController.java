package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;

import com.example.demo.model.Chucvu;
import com.example.demo.payload.ApiResponse;
import com.example.demo.repository.ChucVuRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Api(value = "Thêm, lấy chức vụ, update trạng thái chức vụ")
public class ChucVuController {

    @Autowired
    ChucVuRepository chucVuRepository;

    @GetMapping("/chucvu")
    public List<Chucvu> getAllChucVu() {
        return chucVuRepository.findAll();
    }
    @PutMapping("/updateChucVu")
    public ResponseEntity<Object> updateTrangThai(@RequestHeader(value = "cvma") Long cvma,
                                                  @RequestHeader(value = "trangthai")Boolean trangthai)
    {
        Optional<Chucvu> cvopt = chucVuRepository.findById(cvma);
        Chucvu cv  = cvopt.get();
        cv.setCvTrangthai(trangthai);
        chucVuRepository.save(cv);
        return ResponseEntity.ok().body(new ApiResponse(true,"sửa trạng thái thành công"));
    }
    @PostMapping("/themChucVu")
    public ResponseEntity<Object> themChucVu(
            @RequestHeader(value = "tenchucvu") String tenchucvu){
        Chucvu cv = new Chucvu(tenchucvu);
        chucVuRepository.save(cv);
        return ResponseEntity.ok().body(new ApiResponse(true,"Thêm thành công"));
    }
}

