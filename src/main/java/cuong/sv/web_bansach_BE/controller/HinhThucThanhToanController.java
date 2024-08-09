package cuong.sv.web_bansach_BE.controller;

import cuong.sv.web_bansach_BE.entity.HinhThucThanhToan;
import cuong.sv.web_bansach_BE.service.HinhThucThanhToanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HinhThucThanhToanController {
    @Autowired
    private HinhThucThanhToanService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/them-hinh-thuc-thanh-toan")
    public ResponseEntity<?> themHinhThucThanhToan(@Validated @RequestBody HinhThucThanhToan hinhThucThanhToan){
       ResponseEntity<?> response = service.themHinhThucThanhToan(hinhThucThanhToan);
       return response;
    }
}
