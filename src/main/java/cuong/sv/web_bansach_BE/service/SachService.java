package cuong.sv.web_bansach_BE.service;

import cuong.sv.web_bansach_BE.dao.SachRepository;
import cuong.sv.web_bansach_BE.entity.Sach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SachService {

    @Autowired
    private SachRepository sachRepository;

    public ResponseEntity<?> themSach(Sach sach) {
        if (sachRepository.existsByTenSach(sach.getTenSach())) {
            ResponseEntity.badRequest().body("Tên sách đã tồn tại");
        }
        if (sachRepository.existsByISBN(sach.getISBN())) {
            ResponseEntity.badRequest().body("ISBN đã tồn tại");
        }
        Sach addSach = sachRepository.save(sach);
        return ResponseEntity.ok("Thêm sách thành công.");
    }
}
