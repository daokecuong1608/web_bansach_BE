package cuong.sv.web_bansach_BE.controller;

import cuong.sv.web_bansach_BE.entity.NguoiDung;
import cuong.sv.web_bansach_BE.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//xử lý các yêu cầu từ Restful từ phía client
//trả về kiểu dữ liệu JSON
@RestController
//ánh xạ các phương thức HTTP tới  controller
@RequestMapping("/tai-khoan")
public class TaiKhoanController {
    //tự động  tiêm bean
    @Autowired
    private TaiKhoanService service;

    //cho phép truy cập gọi trực tiếp từ phiá server
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/dang-ky")
    public ResponseEntity<?> dangKyNguoiDung(@Validated @RequestBody NguoiDung nguoiDung) {
        ResponseEntity<?> response = service.dangKyNguoiDung(nguoiDung);
        return response;
    }
    //RequestBody : chuyển đổi dữ liệu JSON từ request body thành đối tượng Java tương ứng.
    //Validated : kiểm tra tính hợp lệ của đối tượng or tham số truyền vào
}
