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
        // Chỉ chèn data mẫu khi DB chưa có danh mục nào
        if (categoryRepository.count() == 0) {

            // 1. Khởi tạo Users mẫu
            User user1 = User.builder()
                    .fullname("Đỗ Trọng Khôi")
                    .email("khoi@gmail.com")
                    .password("123456")
                    .phone("0901234567")
                    .build();

            User user2 = User.builder()
                    .fullname("Trần Duy Luân")
                    .email("luan@gmail.com")
                    .password("123456")
                    .phone("0908765432")
                    .build();

            userRepository.saveAll(List.of(user1, user2));

            // 2. Khởi tạo Categories mẫu
            Category cat1 = Category.builder().name("Điện thoại").images("phone.png").build();
            Category cat2 = Category.builder().name("Laptop").images("laptop.png").build();
            Category cat3 = Category.builder().name("Máy tính bảng").images("tablet.png").build();
            Category cat4 = Category.builder().name("Đồng hồ thông minh").images("smartwatch.png").build();
            Category cat5 = Category.builder().name("Thiết bị âm thanh").images("audio.png").build();
            Category cat6 = Category.builder().name("Phụ kiện").images("accessory.png").build();

            categoryRepository.saveAll(List.of(cat1, cat2, cat3, cat4, cat5, cat6));

            // 3. Khởi tạo 30 Products mẫu
            List<Product> products = List.of(
                // --- Điện thoại (cat1) ---
                Product.builder().title("iPhone 15 Pro Max").quantity(10).desc("Flagship cao cấp từ Apple, chip A17 Pro").price(32000000.0).category(cat1).user(user1).build(),
                Product.builder().title("Samsung Galaxy S24 Ultra").quantity(15).desc("Màn hình 120Hz, camera 200MP zoom 100x").price(29990000.0).category(cat1).user(user1).build(),
                Product.builder().title("Xiaomi 14 Ultra").quantity(8).desc("Ống kính Leica cao cấp, sạc nhanh 90W").price(24500000.0).category(cat1).user(user2).build(),
                Product.builder().title("OPPO Find X7 Ultra").quantity(12).desc("Camera tiềm vọng kép, màn hình 2K").price(21000000.0).category(cat1).user(user2).build(),
                Product.builder().title("iPhone 13 128GB").quantity(20).desc("Thiết kế đẹp, hiệu năng ổn định").price(13990000.0).category(cat1).user(user1).build(),
                Product.builder().title("Realme GT 5 Pro").quantity(14).desc("Chip Snapdragon 8 Gen 3 giá tốt").price(11500000.0).category(cat1).user(user2).build(),

                // --- Laptop (cat2) ---
                Product.builder().title("MacBook Pro M3 Max").quantity(5).desc("Cấu hình siêu mạnh cho đồ họa chuyên nghiệp").price(55000000.0).category(cat2).user(user1).build(),
                Product.builder().title("Dell XPS 15 9530").quantity(7).desc("Màn hình OLED 3.5K, thiết kế vỏ nhôm").price(42000000.0).category(cat2).user(user1).build(),
                Product.builder().title("ASUS ROG Zephyrus G16").quantity(6).desc("Laptop gaming mỏng nhẹ, card RTX 4070").price(38500000.0).category(cat2).user(user2).build(),
                Product.builder().title("Lenovo ThinkPad X1 Carbon Gen 11").quantity(9).desc("Bàn phím gõ êm, độ bền chuẩn quân đội").price(36000000.0).category(cat2).user(user2).build(),
                Product.builder().title("Acer Swift Go 14").quantity(15).desc("Màn hình OLED rực rỡ, nhẹ chỉ 1.2kg").price(18990000.0).category(cat2).user(user1).build(),
                Product.builder().title("HP Pavilion 15").quantity(18).desc("Laptop văn phòng mượt mà, giá bình dân").price(15490000.0).category(cat2).user(user2).build(),

                // --- Máy tính bảng (cat3) ---
                Product.builder().title("iPad Pro 12.9 inch M2").quantity(10).desc("Màn hình Mini-LED, hỗ trợ Apple Pencil 2").price(28000000.0).category(cat3).user(user1).build(),
                Product.builder().title("Samsung Galaxy Tab S9 Ultra").quantity(8).desc("Màn hình AMOLED 14.6 inch siêu lớn").price(24990000.0).category(cat3).user(user1).build(),
                Product.builder().title("iPad Air 5 64GB WiFi").quantity(25).desc("Chip M1 mạnh mẽ, nhiều màu sắc").price(14500000.0).category(cat3).user(user2).build(),
                Product.builder().title("Xiaomi Pad 6").quantity(30).desc("Màn hình 144Hz, học tập giải trí giá rẻ").price(7990000.0).category(cat3).user(user2).build(),
                Product.builder().title("Lenovo Tab P12 Pro").quantity(10).desc("Loa JBL xịn xò, kèm bút cảm ứng").price(12000000.0).category(cat3).user(user1).build(),

                // --- Đồng hồ thông minh (cat4) ---
                Product.builder().title("Apple Watch Ultra 2").quantity(12).desc("Vỏ Titanium siêu bền, chống nước 100m").price(20500000.0).category(cat4).user(user1).build(),
                Product.builder().title("Garmin Fenix 7 Pro").quantity(6).desc("Đồng hồ thể thao chuyên nghiệp, pin mặt trời").price(19000000.0).category(cat4).user(user2).build(),
                Product.builder().title("Samsung Galaxy Watch 6 Classic").quantity(20).desc("Vòng xoay bezel vật lý đặc trưng").price(7500000.0).category(cat4).user(user1).build(),
                Product.builder().title("Huawei Watch GT 4").quantity(25).desc("Thời lượng pin lên đến 14 ngày").price(4800000.0).category(cat4).user(user2).build(),
                Product.builder().title("Xiaomi Watch S3").quantity(40).desc("Thay viền linh hoạt, đo nhịp tim giấc ngủ").price(3200000.0).category(cat4).user(user1).build(),

                // --- Thiết bị âm thanh (cat5) ---
                Product.builder().title("Loa Marshall Stanmore III").quantity(10).desc("Âm thanh cổ điển, công suất 80W").price(9500000.0).category(cat5).user(user1).build(),
                Product.builder().title("Tai nghe Bose QuietComfort Ultra").quantity(12).desc("Chống ồn chủ động hàng đầu").price(8900000.0).category(cat5).user(user2).build(),
                Product.builder().title("Tai nghe Sony WH-1000XM5").quantity(15).desc("Thiết kế mới, chất âm Hi-Res").price(7990000.0).category(cat5).user(user1).build(),
                Product.builder().title("AirPods Pro Gen 2 Type-C").quantity(35).desc("Chống ồn gấp 2 lần, cổng sạc Type-C").price(5800000.0).category(cat5).user(user1).build(),
                Product.builder().title("Loa Bluetooth JBL Charge 5").quantity(22).desc("Chống nước IP67, kiêm pin dự phòng").price(3490000.0).category(cat5).user(user2).build(),

                // --- Phụ kiện (cat6) ---
                Product.builder().title("Chuột Logitech MX Master 3S").quantity(40).desc("Cuộn siêu nhanh, kết nối 3 thiết bị").price(24500000.0).category(cat6).user(user1).build(),
                Product.builder().title("Bàn phím cơ Keychron K2 V2").quantity(30).desc("Bluetooth/Wireless, Gateron Switch").price(1850000.0).category(cat6).user(user2).build(),
                Product.builder().title("Sạc Anker 65W GaNPrime").quantity(50).desc("3 cổng sạc siêu nhỏ gọn").price(850000.0).category(cat6).user(user1).build()
            );

            productRepository.saveAll(products);

            System.out.println("=== Khởi tạo thành công 2 Users, 6 Categories và 30 Products mẫu! ===");
        }
    }
}