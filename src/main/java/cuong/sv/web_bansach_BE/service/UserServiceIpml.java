package cuong.sv.web_bansach_BE.service;

import cuong.sv.web_bansach_BE.dao.NguoiDungRepository;
import cuong.sv.web_bansach_BE.dao.QuyenRepository;
import cuong.sv.web_bansach_BE.entity.NguoiDung;
import cuong.sv.web_bansach_BE.entity.Quyen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.Collator;
import java.util.Collection;
import java.util.stream.Collectors;

@Service// xử lý các logic(phục vụ bên trên server)
public class UserServiceIpml implements UserService {
    private NguoiDungRepository nguoiDungRepository;
    private QuyenRepository quyenRepository;

    @Override
    public NguoiDung findByUserName(String tenDangNhap) {
        return nguoiDungRepository.findByTenDangNhap(tenDangNhap);
    }

    @Autowired
    public UserServiceIpml(NguoiDungRepository nguoiDungRepository, QuyenRepository quyenRepository) {
        this.nguoiDungRepository = nguoiDungRepository;
        this.quyenRepository = quyenRepository;
    }

    // UserDetails(interface) => được sử dụng để lưu trữ thông tin người dùng nhằm mục đích xác thực (authentication).
    //lấy thông tin chi tiết người dùng
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NguoiDung nguoiDung = nguoiDungRepository.findByTenDangNhap(username);
        if (nguoiDung == null) {
            throw new UsernameNotFoundException("Tên đăng nhập không tồn tại.");
        }
//lấy ra thông tin người dùng (authentication).
        User user = new User(nguoiDung.getTenDangNhap(), nguoiDung.getMatKhau(), rolesToAuthorities(nguoiDung.getDanhSachQuyen()));
        return user;
    }
//GrantedAuthority là một giao diện rất quan trọng, được sử dụng để đại diện cho các quyền (authorities) hoặc vai trò (roles) của người dùng
    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Quyen> quyens) {
        return quyens.stream().map(role -> new SimpleGrantedAuthority(role.getTenQuyen())).collect(Collectors.toList());
    }
}
