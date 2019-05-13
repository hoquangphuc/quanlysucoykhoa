package com.example.demo.controller;

import com.example.demo.model.YeucauHotro;
import com.example.demo.repository.YeuCauHoTroRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "API lấy yêu cầu hỗ trợ")
public class YeuCauHoTroController {
    @Autowired
    YeuCauHoTroRepository yeuCauHoTroRepository;

    @GetMapping("/layYeuCauHoTro")
    public List<YeucauHotro> getAllYeuCauHoTro(){
        return yeuCauHoTroRepository.findAll();
    }
}

