package cuong.sv.web_bansach_BE.controller;

import cuong.sv.web_bansach_BE.entity.Sach;
import cuong.sv.web_bansach_BE.service.SachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SachController {

    @Autowired
    private SachService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/them-sach")
    public ResponseEntity<?> themSach(@Validated @RequestBody Sach sach) {
        ResponseEntity<?> response = service.themSach(sach);
        return response;
    }
}
