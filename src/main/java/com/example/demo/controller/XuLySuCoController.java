package com.example.demo.controller;

import com.example.demo.model.XulySuco;
import com.example.demo.repository.XuLySuCoRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "API lấy xử lý sự cố")
public class XuLySuCoController {
    @Autowired
    XuLySuCoRepository xuLySuCoRepository;

    @GetMapping("/layXuLySuCo")
    public List<XulySuco> getAllXuLySuCo(){
        return xuLySuCoRepository.findAll();
    }
}
