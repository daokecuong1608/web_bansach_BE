package cuong.sv.web_bansach_BE.controller;


import cuong.sv.web_bansach_BE.entity.TheLoai;
import cuong.sv.web_bansach_BE.service.TheLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class TheLoaiController {

    @Autowired
    private TheLoaiService theLoaiService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/them-the-loai")
    public ResponseEntity<?> themTheLoai(@Validated @RequestBody TheLoai theLoai) {
        ResponseEntity<?> response = theLoaiService.themTheLoai(theLoai);
        return response;
    }
    //RequestBody : chuyển đổi dữ liệu JSON từ request body thành đối tượng Java tương ứng.
    //Validated : kiểm tra tính hợp lệ của đối tượng or tham số truyền vào
}
