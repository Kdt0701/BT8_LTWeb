package vn.iotstar.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Product;
import vn.iotstar.entity.User;
import vn.iotstar.repository.CategoryRepository;
import vn.iotstar.repository.ProductRepository;
import vn.iotstar.repository.UserRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Nếu DB chưa có dữ liệu thì mới tự động chèn data mẫu
        if (categoryRepository.count() == 0) {
            
            // 1. Tạo User mẫu
            User user1 = User.builder()
                    .fullname("Đỗ Trọng Khôi")
                    .email("khoi@example.com")
                    .password("123456")
                    .phone("0901234567")
                    .build();
            userRepository.save(user1);

            // 2. Tạo Category mẫu
            Category cat1 = Category.builder()
                    .name("Điện thoại")
                    .images("phone.png")
                    .build();

            Category cat2 = Category.builder()
                    .name("Laptop")
                    .images("laptop.png")
                    .build();

            categoryRepository.saveAll(List.of(cat1, cat2));

            // 3. Tạo Product mẫu (bao gồm các mức giá khác nhau để test sắp xếp)
            Product p1 = Product.builder()
                    .title("iPhone 15 Pro Max")
                    .quantity(10)
                    .desc("Điện thoại cao cấp Apple")
                    .price(32000000.0)
                    .category(cat1)
                    .user(user1)
                    .build();

            Product p2 = Product.builder()
                    .title("Samsung Galaxy S24")
                    .quantity(15)
                    .desc("Điện thoại flagship Samsung")
                    .price(22000000.0)
                    .category(cat1)
                    .user(user1)
                    .build();

            Product p3 = Product.builder()
                    .title("MacBook Pro M3")
                    .quantity(5)
                    .desc("Laptop chuyên đồ họa")
                    .price(45000000.0)
                    .category(cat2)
                    .user(user1)
                    .build();

            productRepository.saveAll(List.of(p1, p2, p3));

            System.out.println("=== Khởi tạo dữ liệu mẫu thành công! ===");
        }
    }
}