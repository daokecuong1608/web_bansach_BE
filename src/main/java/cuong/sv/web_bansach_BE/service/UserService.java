package cuong.sv.web_bansach_BE.service;

import cuong.sv.web_bansach_BE.entity.NguoiDung;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

//UserDetailsService => truy xuất thông tin người dùng nhằm xác thực (authentication)
public interface UserService extends UserDetailsService {
    public NguoiDung findByUserName(String tenDangNhap);
}
