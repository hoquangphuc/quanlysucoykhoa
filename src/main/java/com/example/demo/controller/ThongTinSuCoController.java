package com.example.demo.controller;

import com.example.demo.model.ThongtinSuco;
import com.example.demo.repository.ThongTinSuCoRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "API lấy thông tin sự cố")
public class ThongTinSuCoController {
    @Autowired
    ThongTinSuCoRepository thongTinSuCoRepository;

    @GetMapping("/layThongTinSuCo")
    public List<ThongtinSuco> getAllThongTinSuCo(){
        return thongTinSuCoRepository.findAll();
    }
}
