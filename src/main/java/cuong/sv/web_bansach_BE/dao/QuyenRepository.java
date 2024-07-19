package cuong.sv.web_bansach_BE.dao;

import cuong.sv.web_bansach_BE.entity.Quyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "quyen")
public interface QuyenRepository extends JpaRepository<Quyen , Integer> {
}
