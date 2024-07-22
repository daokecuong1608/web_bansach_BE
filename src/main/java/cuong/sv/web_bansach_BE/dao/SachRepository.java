package cuong.sv.web_bansach_BE.dao;

import cuong.sv.web_bansach_BE.entity.Quyen;
import cuong.sv.web_bansach_BE.entity.Sach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "sach")
public interface SachRepository extends JpaRepository<Sach, Integer> {
}
