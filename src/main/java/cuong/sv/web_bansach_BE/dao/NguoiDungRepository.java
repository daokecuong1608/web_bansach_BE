package cuong.sv.web_bansach_BE.dao;

import cuong.sv.web_bansach_BE.entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "nguoi-dung")
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer> {

    //ktra tên đăng nhập đã tồn tại hay chưa
    public boolean existsByTenDangNhap(String tenDangNhap);

    public boolean existsByEmail(String email);


}
