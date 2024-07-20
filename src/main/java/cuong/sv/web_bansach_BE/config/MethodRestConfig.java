package cuong.sv.web_bansach_BE.config;

import cuong.sv.web_bansach_BE.entity.NguoiDung;
import cuong.sv.web_bansach_BE.entity.TheLoai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MethodRestConfig implements RepositoryRestConfigurer {


    @Autowired
    private EntityManager entityManager;

    private String url = "http://localhost:8080";

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        //expose ids
        //cho phep tra ve id
        config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream().map(Type::getJavaType).toArray(Class[]::new));

        //chan cac methods
        HttpMethod[] chanCacPhuongThuc = {
                HttpMethod.POST,
                HttpMethod.PUT,
                HttpMethod.DELETE,
                HttpMethod.PATCH,

        };
        //cau hinh rieng cho the loai ;
        disableHttpMethods(TheLoai.class, config, chanCacPhuongThuc);
        HttpMethod[] phuongThucDelete = {
                HttpMethod.DELETE,
        };
        disableHttpMethods(NguoiDung.class, config, phuongThucDelete);

    }

    private void disableHttpMethods(Class c, RepositoryRestConfiguration config, HttpMethod[] httpMethods) {
        config.getExposureConfiguration().forDomainType(c);
    }
}
