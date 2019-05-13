package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.payload.ApiResponse;
import com.example.demo.repository.*;
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
@Api(value = "API thêm, lấy nhân viên, update trạng thái nhân viên")
public class NhanVienController {
    @Autowired
    NhanVienRepository nhanVienRepository;

    @Autowired
    DonViTrucThuocRepository donViTrucThuocRepository;

    @Autowired
    ChucVuRepository chucVuRepository;

    @Autowired
    LoaiNhanVienRepository loaiNhanVienRepository;

    @Autowired
    KhoaRepository khoaRepository;

    @GetMapping("/layDanhSachNhanVien")
    public List<Nhanvien> getAllNhanVien(){
        return nhanVienRepository.findAll();
    }

    @PutMapping("/updateNhanVien")
    public ResponseEntity<Object> updateTrangThai(@RequestHeader(value = "manhanvien") Long manhanvien,
                                                  @RequestHeader(value = "trangthai")Boolean trangthai)
    {
        Optional<Nhanvien> nvopt = nhanVienRepository.findById(manhanvien);
        Nhanvien nv  = nvopt.get();
        nv.setNvTrangthai(trangthai);
        nhanVienRepository.save(nv);
        return ResponseEntity.ok().body(new ApiResponse(true,"sửa trạng thái thành công"));
    }
    @PostMapping("/themNhanVien")
    public ResponseEntity<Object> themKhoa( @RequestHeader(value = "machucvu") Long machucvu,
                                            @RequestHeader(value = "dvtt") String dvtt,
                                            @RequestHeader(value = "makhoa") Long makhoa,
                                            @RequestHeader(value = "maloainhanvien") Long maloainhanvien ,
                                            @RequestHeader(value = "nvTen") String nvTen,
                                            @RequestHeader(value = "nvNamSinh") @DateTimeFormat(pattern = "dd-MM-yyyy") Date nvNamSinh,
                                            @RequestHeader(value = "nvSDT") String nvSDT,
                                            @RequestHeader(value = "nvEmail") String nvEmail,
                                            @RequestHeader(value = "nvTenDangNhap") String nvTenDangNhap,
                                            @RequestHeader(value = "nvMatKhau") String nvMatKhau,
                                            @RequestHeader(value = "nvChungChi") String nvChungChi){
        Optional<Donvitructhuoc> otpDv = donViTrucThuocRepository.findById(dvtt);
        Optional<Chucvu> otpCV = chucVuRepository.findById(machucvu);
        Optional<Loainhanvien> otpLNV = loaiNhanVienRepository.findById(maloainhanvien);
        Optional<Khoa> otpK = khoaRepository.findById(makhoa);
        Donvitructhuoc dv = otpDv.get();
        Chucvu cv = otpCV.get();
        Loainhanvien lnv = otpLNV.get();
        Khoa k = otpK.get();
        Nhanvien nv = new Nhanvien(cv,dv,k,lnv,nvTen,nvNamSinh,nvSDT,nvEmail,nvTenDangNhap, nvMatKhau,nvChungChi);
        nhanVienRepository.save(nv);
        return ResponseEntity.ok().body(new ApiResponse(true,"Thêm thành công"));
    }
}
