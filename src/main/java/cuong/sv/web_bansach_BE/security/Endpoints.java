package cuong.sv.web_bansach_BE.security;

public class Endpoints {

    public static final String front_end_host = "http://localhost:3000";

    public static final String[] PUBLIC_GET_ENDPOIN = {
            "/sach",
            "/sach/**",
            "/hinh-anh",
            "/hinh-anh/**",
            "/nguoi-dung/search/existsByTenDangNhap",
            "/nguoi-dung/search/existsByEmail",
            "/the-loai/search/existsByTenTheLoai",
            "/hinh-thuc-giao-hang",
            "/hinh-thuc-giao-hang/search/existsByTenHinhThucGiaoHang",
            "/hinh-thuc-thanh-toan",
            "/hinh-thuc-thanh-toan/search",
            "/hinh-thuc-thanh-toan/search/existsByTenHinhThucThanhToan",
            "sach/search/existsByTenSach"
    };


    public static final String[] PUBLIC_POST_ENDPOIN = {
            "/tai-khoan/dang-ky",
            "/api/them-the-loai",
            "/api/them-hinh-thuc-giao-hang",
            "/api/them-hinh-thuc-thanh-toan",
            "/api/them-sach"
    };

    public static final String[] ADMIN_GET_ENDPOIN = {
            "/nguoi-dung",
            "/nguoi-dung/**"

    };

}
