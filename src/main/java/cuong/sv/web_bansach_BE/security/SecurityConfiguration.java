package cuong.sv.web_bansach_BE.security;

import cuong.sv.web_bansach_BE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration//đánh dấu là nguồn cấu hình cho ứng dụng. Lớp này sẽ chứa các định nghĩa bean mà Spring sẽ quản lý và khởi tạo.
public class SecurityConfiguration {

    //Bean cho mã hóa mật khẩu dùng BCrypt
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Autowired
    //DaoAuthenticationProvider =>  là một triển khai của AuthenticationProvider trong Spring Security
    //sử dụng để xác thực người dùng dựa trên tên đăng nhập và mật khẩu
    public DaoAuthenticationProvider authenticationProvider(UserService userService) {
        DaoAuthenticationProvider dap = new DaoAuthenticationProvider();
        dap.setUserDetailsService(userService);
        dap.setPasswordEncoder(passwordEncoder());
        return dap;
    }

    //SecurityFilterChain => được sử dụng để cấu hình các chuỗi bộ lọc bảo mật cho ứng dụng.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      //authorizeHttpRequests => một phương thức cấu hình bảo mật trong Spring Security
        http.authorizeHttpRequests(
                //authorizeHttpRequests được sử dụng để cấu hình các quy tắc ủy quyền.
                configurer -> configurer
                        .requestMatchers(HttpMethod.GET, "/sach").permitAll()
                        .requestMatchers(HttpMethod.GET, "/sach/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/hinh-anh/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/nguoi-dung").hasAnyAuthority("ADMIN", "STAFF")
                        .requestMatchers(HttpMethod.GET, "/tai-khoan/dang-ky").permitAll()

        );
// được sử dụng để kích hoạt xác thực HTTP Basic với các cấu hình mặc định.
        //Customizer.withDefaults() chỉ định rằng không có tùy chỉnh nào được áp dụng
        http.httpBasic(Customizer.withDefaults());
        // để vô hiệu hóa bảo vệ CSRF
        // CSRF (Cross-Site Request Forgery) là một loại tấn công mà kẻ tấn công có thể thực hiện các hành động không mong muốn thay mặt người dùng đã xác thực.
        http.csrf(crsf -> crsf.disable());
        //được sử dụng để xây dựng và trả về một đối tượng
        return http.build();
    }
}
