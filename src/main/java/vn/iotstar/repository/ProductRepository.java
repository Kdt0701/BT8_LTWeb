package vn.iotstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iotstar.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Lấy tất cả Product sắp xếp giá từ thấp đến cao (yêu cầu đề bài)
    List<Product> findAllByOrderByPriceAsc();

    // Lấy tất cả Product theo Category ID (yêu cầu đề bài)
    List<Product> findByCategoryId(Long categoryId);
}