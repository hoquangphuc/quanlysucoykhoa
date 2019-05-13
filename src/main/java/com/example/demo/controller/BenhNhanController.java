package com.example.demo.controller;

import com.example.demo.model.Benhnhan;
import com.example.demo.model.Donvitructhuoc;
import com.example.demo.payload.ApiResponse;
import com.example.demo.repository.BenhNhanRepository;
import com.example.demo.repository.DonViTrucThuocRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Api(value = "API thêm, lấy bệnh nhân, update trạng thái nhân viên")
public class BenhNhanController {
    @Autowired
    BenhNhanRepository benhNhanRepository;

    @Autowired
    DonViTrucThuocRepository donViTrucThuocRepository;

    @GetMapping("/layDanhSachBenhNhan")
    public List<Benhnhan> getAllBenhNhan(){
        return benhNhanRepository.findAll();
    }
    @PutMapping("/updateBenhNhan")
    public ResponseEntity<Object> updateTrangThai(@RequestHeader(value = "mabenhnhan") String mabenhnhan,
                                                  @RequestHeader(value = "trangthai")Boolean trangthai)
    {
        Optional<Benhnhan> bnopt = benhNhanRepository.findById(mabenhnhan);
        Benhnhan bn  = bnopt.get();
        bn.setBnTrangthai(trangthai);
        benhNhanRepository.save(bn);
        return ResponseEntity.ok().body(new ApiResponse(true,"sửa trạng thái thành công"));
    }
    @PostMapping("/themBenhNhan")
    public ResponseEntity<Object> themKhoa( @RequestHeader(value = "mabenhnhan") String mabenhnhan,
                                            @RequestHeader(value = "dvtt") String dvtt,
                                            @RequestHeader(value = "bnTen") String bnTen,
                                            @RequestHeader(value = "bnTuoi") Integer bnTuoi ,
                                            @RequestHeader(value = "bnGioiTinh") Boolean bnGioitinh,
                                            @RequestHeader(value = "bnBHYT") String bnBHYT,
                                            @RequestHeader(value = "bnCMND") String bnCMND,
                                            @RequestHeader(value = "bnDiaChi") String bnDiaChi,
                                            @RequestHeader(value = "bnNgayTiepNhan") @DateTimeFormat(pattern = "dd-MM-yyyy") Date bnNgayTiepNhan){
        Optional<Donvitructhuoc> otpDv = donViTrucThuocRepository.findById(dvtt);
        Donvitructhuoc dv = otpDv.get();
        Benhnhan bn = new Benhnhan(mabenhnhan,dv,bnTen,bnTuoi,bnGioitinh,bnBHYT,bnCMND,bnDiaChi,bnNgayTiepNhan);
        benhNhanRepository.save(bn);
        return ResponseEntity.ok().body(new ApiResponse(true,"Thêm thành công"));
    }
}
