package cuong.sv.web_bansach_BE.service;

import cuong.sv.web_bansach_BE.dao.HinhThucGiaoHangRepository;
import cuong.sv.web_bansach_BE.dao.HinhThucThanhToanRepository;
import cuong.sv.web_bansach_BE.entity.HinhThucThanhToan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HinhThucThanhToanService {

    @Autowired
    private HinhThucThanhToanRepository hinhThucThanhToanRepository;

public ResponseEntity<?> themHinhThucThanhToan (HinhThucThanhToan hinhThucThanhToan){
    if (hinhThucThanhToanRepository.existsByTenHinhThucThanhToan(hinhThucThanhToan.getTenHinhThucThanhToan())){
        return ResponseEntity.badRequest().body("Tên hình thức thanh toán đã tồn tại.");
    }
    HinhThucThanhToan addHinhThucThanhToan = hinhThucThanhToanRepository.save(hinhThucThanhToan);
    return ResponseEntity.ok("Thêm hình thức thanh toán thành công.");
}
}
