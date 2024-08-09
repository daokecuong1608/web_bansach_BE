package cuong.sv.web_bansach_BE.service;

import cuong.sv.web_bansach_BE.dao.HinhThucGiaoHangRepository;
import cuong.sv.web_bansach_BE.entity.HinhThucGiaoHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service //xử lý các logic bên ngoài
public class HinhThucGiaoHangService {

    @Autowired
    private HinhThucGiaoHangRepository hinhThucGiaoHangRepository;

    public ResponseEntity<?> themHinhThucGiaoHang(HinhThucGiaoHang hinhThucGiaoHang){
        if (hinhThucGiaoHangRepository.existsByTenHinhThucGiaoHang(hinhThucGiaoHang.getTenHinhThucGiaoHang())){
            return ResponseEntity.badRequest().body("Tên hình thức giao hàng đã tồn tại.");
        }
        HinhThucGiaoHang addHinhThucGiaoHang = hinhThucGiaoHangRepository.save(hinhThucGiaoHang);
        return ResponseEntity.ok("Thêm hình thức giao hàng thành công.");
    }
}
