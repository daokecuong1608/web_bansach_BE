package cuong.sv.web_bansach_BE.dao;

import cuong.sv.web_bansach_BE.entity.ChiTietDonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "chi-tiet-don-hang")//đánh dấu tập hơp tiêu chuẩn để thực hiện các thao tác cơ bản trên csdl
public interface ChiTietDonHangRepository extends JpaRepository<ChiTietDonHang , Long> {
}
