package com.example.demo.controller;


import com.example.demo.model.Donvitructhuoc;
import com.example.demo.payload.ApiResponse;
import com.example.demo.payload.MyApiResponse;

import com.example.demo.repository.DonViTrucThuocRepository;
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
@Api(value = "API thêm, lấy đơn vị, update trạng thái đơn vị")
public class DonViTrucThuocController {
    @Autowired
    DonViTrucThuocRepository donViTrucThuocRepository;

//    @GetMapping("/donvitructhuoc")
//    public List<Donvitructhuoc> getAllDonVi() {
//        return donViTrucThuocRepository.findAll();
//    }
    @RequestMapping(value = "/donvitructhuoc", method = RequestMethod.GET)
    public ResponseEntity<List<Donvitructhuoc>> getAllKhoa(){
        List<Donvitructhuoc> donvitructhuocList = donViTrucThuocRepository.findAll();

        return new ResponseEntity<List<Donvitructhuoc>>(donvitructhuocList, HttpStatus.OK);
    }
    @PutMapping("/updateDVTT")
    public ResponseEntity<Object> updateTrangThai(@RequestHeader(value = "madvtt") String madvtt,
                                                  @RequestHeader(value = "trangthai")Boolean trangthai)
    {
        Optional<Donvitructhuoc> dvttopt = donViTrucThuocRepository.findById(madvtt);
        Donvitructhuoc dvtt  = dvttopt.get();
        dvtt.setDvttTrangthai(trangthai);
        donViTrucThuocRepository.save(dvtt);
        return ResponseEntity.ok().body(new ApiResponse(true,"sửa trạng thái thành công"));
    }
    @PostMapping("/themDVTT")
    public ResponseEntity<Object> themDVTT(
            @RequestHeader(value = "madvtt") String madvtt,
            @RequestHeader(value = "tendvtt") String tendvtt,
            @RequestHeader(value = "diachi") String diachi,
            @RequestHeader(value = "sdt") String sdt){
        Donvitructhuoc dvtt = new Donvitructhuoc(madvtt,tendvtt,diachi,sdt);
        donViTrucThuocRepository.save(dvtt);
        return ResponseEntity.ok().body(new ApiResponse(true,"Thêm thành công"));
    }
}
