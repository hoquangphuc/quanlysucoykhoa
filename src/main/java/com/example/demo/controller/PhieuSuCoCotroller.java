package com.example.demo.controller;

import com.example.demo.model.Benhnhan;
import com.example.demo.model.Nhanvien;
import com.example.demo.model.PhieuSuCo;
import com.example.demo.payload.ApiResponse;
import com.example.demo.repository.BenhNhanRepository;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.repository.PhieuSuCoRepository;
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
@Api(value = "API thêm, lấy phiếu sự cố, update trạng thái duyệt phiếu sự cố")
public class PhieuSuCoCotroller {

    @Autowired
    BenhNhanRepository benhNhanRepository;

    @Autowired
    NhanVienRepository nhanVienRepository;

    @Autowired
    PhieuSuCoRepository phieuSuCoRepository;

    @GetMapping("/layDanhSachPhieuSuCo")
    public List<PhieuSuCo> getAllPhieuSuCo(){
        return phieuSuCoRepository.findAll();
    }
    @PutMapping("/duyetPhieu")
    public ResponseEntity<Object> updateTrangThaiDuyet(@RequestHeader(value = "maphieu") Long maphieu,
                                                  @RequestHeader(value = "trangthai")Boolean trangthai)
    {
        Optional<PhieuSuCo> pscopt = phieuSuCoRepository.findById(maphieu);
        PhieuSuCo psc = pscopt.get();
        psc.setPhieuTrangthaiduyet(trangthai);
        phieuSuCoRepository.save(psc);
        return ResponseEntity.ok().body(new ApiResponse(true,"sửa trạng thái duyệt thành công"));
    }
    @PostMapping("/themPhieuSuCo")

    public ResponseEntity<Object> themKhoa( @RequestHeader(value = "mabenhnhan") String mabenhnhan,
                                            @RequestHeader(value = "manhanvien") Long manhanvien,
                                            @RequestHeader(value = "phieuNgaySuCo") @DateTimeFormat(pattern = "dd-MM-yyyy") Date phieuNgaySuCo,
                                            @RequestHeader(value = "phieuMoTa") String phieuMota,
                                            @RequestHeader(value = "phieuDiaDiem") String phieuDiaDiem ,
                                            @RequestHeader(value = "phieuSuCoNT") Boolean phieuSuCoNT,
                                            @RequestHeader(value = "lichsu") String lichsu,
                                            @RequestHeader(value = "phieuGiauTen") Boolean phieuGiauTen,
                                            @RequestHeader(value = "phieuLapHD") Boolean phieuLapHD,
                                            @RequestHeader(value = "bienban") Boolean bienban){
        Optional<Benhnhan> otpBN = benhNhanRepository.findById(mabenhnhan);
        Optional<Nhanvien> otpNV = nhanVienRepository.findById(manhanvien);
        Benhnhan bn = otpBN.get();
        Nhanvien nv = otpNV.get();
        PhieuSuCo psc = new PhieuSuCo(bn,nv,phieuNgaySuCo,phieuMota,phieuDiaDiem,phieuSuCoNT,lichsu,phieuGiauTen,phieuLapHD,bienban);
        phieuSuCoRepository.save(psc);
        return ResponseEntity.ok().body(new ApiResponse(true,"Thêm thành công"));
    }
}
