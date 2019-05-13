package com.example.demo.controller;

import com.example.demo.model.Khoa;
import com.example.demo.model.Phong;
import com.example.demo.payload.ApiResponse;
import com.example.demo.repository.KhoaRepository;
import com.example.demo.repository.PhongRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Api(value = "API thêm, lấy phòng, update trạng thái phòng")
public class PhongController {
    @Autowired
    KhoaRepository khoaRepository;

    @Autowired
    PhongRepository phongRepository;

    @GetMapping("/phong")
    public List<Phong> getAllPhong(){
        return phongRepository.findAll();
    }



    @PutMapping("/updatePhong")
    public ResponseEntity<Object> updateTrangThai(@RequestHeader(value = "maphong") Long maphong,
                                                  @RequestHeader(value = "trangthai")Boolean trangthai)
    {

        Optional<Phong> phongopt = phongRepository.findById(maphong);
        Phong p  = phongopt.get();
        p.setPhongTrangthai(trangthai);
        phongRepository.save(p);
        return ResponseEntity.ok().body(new ApiResponse(true,"sửa trạng thái thành công"));
    }
    @PostMapping("/themPhong")
    public ResponseEntity<Object> themKhoa( @RequestHeader(value = "makhoa") Long makhoa,
                                            @RequestHeader(value = "tenphong") String tenphong){
        Optional<Khoa> otpKhoa = khoaRepository.findById(makhoa);
        Khoa k = otpKhoa.get();
        Phong p = new Phong(k,tenphong);
        phongRepository.save(p);
        return ResponseEntity.ok().body(new ApiResponse(true,"Thêm thành công"));
    }

}
