package cuong.sv.web_bansach_BE.dao;

import cuong.sv.web_bansach_BE.entity.SuDanhGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "su-danh-gia")
public interface SuDanhGiaRepository extends JpaRepository<SuDanhGia , Integer> {
}
