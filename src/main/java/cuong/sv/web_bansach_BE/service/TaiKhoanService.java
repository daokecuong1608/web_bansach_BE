package cuong.sv.web_bansach_BE.service;

import cuong.sv.web_bansach_BE.dao.NguoiDungRepository;
import cuong.sv.web_bansach_BE.entity.NguoiDung;
import cuong.sv.web_bansach_BE.entity.ThongBao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service // xử lý các logic(phục vụ bên trên server)
public class TaiKhoanService {

    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    //ResponseEntity là một lớp đại diện cho toàn bộ phản hồi HTTP, bao gồm mã trạng thái, tiêu đề và nội dung
    //Nó cung cấp một cách linh hoạt để tùy chỉnh phản hồi HTTP từ các phương thức trong controller.
    public ResponseEntity<?> dangKyNguoiDung(NguoiDung nguoiDung) {
        //kiểm tra tên đăng nhập đã tồn tại hay chưa
        if (nguoiDungRepository.existsByTenDangNhap(nguoiDung.getTenDangNhap())) {
            return ResponseEntity.badRequest().body(new ThongBao("Tên đăng nhập đã tồn tại."));
        }
        //kiểm tra email đăng nhập đã tồn tại hay chưa
        if (nguoiDungRepository.existsByTenDangNhap(nguoiDung.getEmail())) {
            return ResponseEntity.badRequest().body(new ThongBao("Email đã tồn tại."));
        }
        //lưu người dùng vào cơ sở dữ liệu
        NguoiDung nguoiDung_daDangKy = nguoiDungRepository.save(nguoiDung);
        return ResponseEntity.ok("Đăng ký thành công");

    }
}
