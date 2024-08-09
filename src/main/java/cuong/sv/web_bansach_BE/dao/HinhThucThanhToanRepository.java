package cuong.sv.web_bansach_BE.dao;

import cuong.sv.web_bansach_BE.entity.HinhThucThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "hinh-thuc-thanh-toan")
public interface HinhThucThanhToanRepository extends JpaRepository<HinhThucThanhToan , Integer> {

    public  boolean existsByTenHinhThucThanhToan(String tenHinhThucThanhToan);

}
