package cuong.sv.web_bansach_BE.service;

import cuong.sv.web_bansach_BE.dao.TheLoaiRepository;
import cuong.sv.web_bansach_BE.entity.TheLoai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TheLoaiService {

    @Autowired
    private TheLoaiRepository theLoaiRepository;


    public ResponseEntity<?> themTheLoai(TheLoai theLoai) {
        if (theLoaiRepository.existsByTenTheLoai(theLoai.getTenTheLoai())){
            return ResponseEntity.badRequest().body("Tên thể loại đã tồn tại.");
        }
        TheLoai addTheLoai = theLoaiRepository.save(theLoai);
        return ResponseEntity.ok("Thêm thể loại thành công.");
    }

}
