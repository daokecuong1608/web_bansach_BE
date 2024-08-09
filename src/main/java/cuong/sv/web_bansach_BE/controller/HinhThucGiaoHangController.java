package cuong.sv.web_bansach_BE.controller;

import cuong.sv.web_bansach_BE.entity.HinhThucGiaoHang;
import cuong.sv.web_bansach_BE.service.HinhThucGiaoHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HinhThucGiaoHangController {
    @Autowired
    private HinhThucGiaoHangService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/them-hinh-thuc-giao-hang")
    public ResponseEntity<?> themTheLoai(@Validated @RequestBody HinhThucGiaoHang hinhThucGiaoHang) {
        ResponseEntity<?> response = service.themHinhThucGiaoHang(hinhThucGiaoHang);
        return response;
    }
    //RequestBody : chuyển đổi dữ liệu JSON từ request body thành đối tượng Java tương ứng.
    //Validated : kiểm tra tính hợp lệ của đối tượng or tham số truyền vào
}
