package cuong.sv.web_bansach_BE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name = "the_loai")
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // khóa chính tự đ��ng tăng
    @Column(name = "ma_the_loai")  // tên cột trong bảng sử dụng cho khóa chính
    private int maTheLoai;
    @Column(name = "ten_the_loai" ,length = 256)  // tên cột trong bảng để lưu dữ liệu cho tên thể loại sách
    private String tenTheLoai;

    @ManyToMany(fetch = FetchType.LAZY , cascade = {
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH

    })
    @JoinTable(
            name = "sach_theloai"
            , joinColumns = @JoinColumn(name = "ma_the_loai")
            ,inverseJoinColumns = @JoinColumn(name = "ma_sach")
    )
    private List<Sach> danhSachQuyenSach;

}