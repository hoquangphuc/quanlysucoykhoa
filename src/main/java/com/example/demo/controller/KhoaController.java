package com.example.demo.controller;

import com.example.demo.model.Donvitructhuoc;
import com.example.demo.model.Khoa;
import com.example.demo.payload.ApiResponse;
import com.example.demo.payload.MyApiResponse;

import com.example.demo.repository.DonViTrucThuocRepository;
import com.example.demo.repository.KhoaRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Api(value = "API thêm, lấy khoa, update trạng thái khoa")
public class KhoaController {
    @Autowired
    KhoaRepository khoaRepository;

    @Autowired
    DonViTrucThuocRepository donViTrucThuocRepository;

//    @RequestMapping(value ="/themKhoa",method = RequestMethod.POST)
//    public MyApiResponse saveKhoa(@Valid @RequestBody Khoa kh){
//        if (khoaRepository.existsKhoaByKhoaMa((long) kh.getKhoaMa())) {
//            return  new MyApiResponse(false,"Đã tồn tại","");
//        }
//        khoaRepository.save(kh);
//        return new MyApiResponse(true,"thành công", null);
//    }
//    @RequestMapping(value = "/layDanhSachKhoa/", method = RequestMethod.GET)
//    public ResponseEntity<List<Khoa>> getAllKhoa(){
//        List<Khoa> khoaList = khoaRepository.findAll();
//
//        return new ResponseEntity<List<Khoa>>(khoaList, HttpStatus.OK);
//    }
    @GetMapping("/khoa")
    public List<Khoa> getAllKhoa(){
        return khoaRepository.findAll();
    }



    @PutMapping("/updateKhoa")
    public ResponseEntity<Object> updateTrangThai(@RequestHeader(value = "khoama") Long khoama,
                      @RequestHeader(value = "trangthai")Boolean trangthai)
    {
//        Optional<Donvitructhuoc> otpDv = donViTrucThuocRepository.findById(dvtt);
//        Donvitructhuoc dv = otpDv.get();
        Optional<Khoa> khoaopt = khoaRepository.findById(khoama);
        Khoa k  = khoaopt.get();
        k.setKhoaTrangthai(trangthai);
        khoaRepository.save(k);
        return ResponseEntity.ok().body(new ApiResponse(true,"sửa trạng thái thành công"));
    }
    @PostMapping("/themKhoa")
    public ResponseEntity<Object> themKhoa( @RequestHeader(value = "dvtt") String dvtt,
                                        @RequestHeader(value = "tenkhoa") String tenkhoa){
        Optional<Donvitructhuoc> otpDv = donViTrucThuocRepository.findById(dvtt);
        Donvitructhuoc dv = otpDv.get();
        Khoa k = new Khoa(dv,tenkhoa);
        khoaRepository.save(k);
        return ResponseEntity.ok().body(new ApiResponse(true,"Thêm thành công"));
    }
}
