```markdown
# BT8_LTWeb - Spring Boot GraphQL Product Category API AJAX

## 1. Mục tiêu bài tập (Objectives)
Dự án **BT8_LTWeb** được xây dựng nhằm tạo bộ khung và ứng dụng hoàn chỉnh Java Web trên nền tảng **Spring Boot 3**, triển khai hệ thống API với **GraphQL** và giao diện tương tác qua **AJAX**. Dự án đáp ứng đầy đủ các mục tiêu chính theo đề bài Bài tập 08:
* Thiết kế và ánh xạ mô hình CSDL gồm các bảng `Category`, `User`, `Product` với các mối quan hệ:
  * Category ↔ User: Mối quan hệ Nhiều - Nhiều (Many-to-Many).
  * Category ↔ Product: Mối quan hệ Một - Nhiều (One-to-Many).
* Hiện thực hệ thống **GraphQL API** (Query & Mutation) cho xử lý CRUD và truy vấn dữ liệu.
* Tích hợp công cụ thử nghiệm GraphQL (**GraphiQL UI**) và **Swagger 3 (Springdoc OpenAPI)**.
* Xây dựng giao diện Frontend (.html) gọi GraphQL API thông qua **jQuery / AJAX** để hiển thị dữ liệu động không tải lại trang.

## 2. Mô hình Dữ liệu (Domain Model)
* **Category**: `id`, `name`, `images`
* **User**: `id`, `fullname`, `email`, `password`, `phone`
* **Product**: `id`, `title`, `quantity`, `desc`, `price`, `userid`
* **Mối quan hệ**:
  * Category ↔ User: Many-to-Many
  * Category ↔ Product: One-to-Many

## 3. Công nghệ sử dụng (Tech Stack)
* **Language**: Java 21
* **Framework**: Spring Boot 3.x
* **API Framework**: Spring GraphQL, Spring Web
* **Database & ORM**: SQL Server, Spring Data JPA
* **Validation & Utility**: Spring Boot Starter Validation, Lombok
* **Documentation & Testing**: Springdoc OpenAPI (Swagger 3), GraphiQL UI
* **Template Engine & UI**: HTML5, Bootstrap 5, jQuery, AJAX
* **Build Tool**: Maven

## 4. Chức năng đã hoàn thành (Features)
### GraphQL Query & Mutation API
* **CRUD Category**: Lấy danh sách, Thêm mới, Cập nhật, Xóa Category.
* **CRUD Product**: Lấy danh sách, Thêm mới, Cập nhật, Xóa Product.
* **Truy vấn nâng cao Product**:
  * Sắp xếp danh sách Product có giá từ thấp đến cao (`allProductsByPriceAsc`).
  * Lấy danh sách Product thuộc về 01 Category cụ thể (`productsByCategory`).

### Frontend UI & Integration
* **Trang User (`/user/products`)**: Bảng hiển thị danh sách sản phẩm, sắp xếp theo giá, lọc theo danh mục qua GraphQL AJAX. Tự động hiển thị hình ảnh thật chất lượng cao theo tên/loại thiết bị qua Unsplash CDN.
* **Trang Admin (`/admin/products`)**: Form thêm sản phẩm mới trực tiếp qua Mutation GraphQL, bảng quản lý danh sách sản phẩm hệ thống kèm ảnh thumbnail tự động.

## 5. Tiến độ thực hiện (Progress Checklist)
* [x] **[Hoàn thành]** Khởi tạo cấu trúc dự án BT8_LTWeb (Maven, Spring Boot 3, Java 21)
* [x] **[Hoàn thành]** Cấu hình `application.properties` kết nối CSDL SQL Server
* [x] **[Hoàn thành]** Định nghĩa Entity JPA (`Category`, `Product`, `User`) kèm Annotation mối quan hệ
* [x] **[Hoàn thành]** Xây dựng GraphQL Schema (`schema.graphqls`) định nghĩa Types, Queries & Mutations
* [x] **[Hoàn thành]** Viết Spring Data JPA Repositories & Business Service Layer
* [x] **[Hoàn thành]** Viết GraphQL Controllers (`@QueryMapping`, `@MutationMapping`, `@SchemaMapping`)
* [x] **[Hoàn thành]** Cấu hình GraphiQL UI (`/graphiql`) & Swagger 3 (`/swagger-ui.html`)
* [x] **[Hoàn thành]** Xây dựng giao diện User (`user/products.html`) gọi GraphQL API qua jQuery AJAX
* [x] **[Hoàn thành]** Xây dựng giao diện Admin (`admin/products.html`) quản lý & thêm sản phẩm
* [x] **[Hoàn thành]** Tích hợp hàm `getProductImageUrl()` ánh xạ ảnh sản phẩm thực tế từ Unsplash CDN

## 6. Cấu trúc thư mục dự án (Project Structure)

```text
BT8_LTWeb/
├── database/
│   └── schema.sql
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── vn/
│   │   │       └── iotstar/
│   │   │           ├── config/
│   │   │           │   └── GraphQLConfig.java
│   │   │           ├── controller/
│   │   │           │   ├── CategoryGraphQLController.java
│   │   │           │   ├── ProductGraphQLController.java
│   │   │           │   └── ViewController.java
│   │   │           ├── dto/
│   │   │           ├── entity/
│   │   │           │   ├── Category.java
│   │   │           │   ├── Product.java
│   │   │           │   └── User.java
│   │   │           ├── repository/
│   │   │           │   ├── CategoryRepository.java
│   │   │           │   ├── ProductRepository.java
│   │   │           │   └── UserRepository.java
│   │   │           └── service/
│   │   │               ├── CategoryService.java
│   │   │               └── ProductService.java
│   │   └── resources/
│   │       ├── graphql/
│   │       │   └── schema.graphqls
│   │       ├── static/
│   │       │   ├── css/
│   │       │   └── js/
│   │       ├── templates/
│   │       │   ├── admin/
│   │       │   │   └── products.html
│   │       │   └── user/
│   │       │       └── products.html
│   │       └── application.properties
│   └── test/
├── .gitignore
├── pom.xml
└── README.md

```

## 7. Hướng dẫn Cài đặt & Chạy ứng dụng

### Bước 1: Clone Repository

```bash
git clone [https://github.com/Kdt0701/BT8_LTWeb.git](https://github.com/Kdt0701/BT8_LTWeb.git)
cd BT8_LTWeb

```

### Bước 2: Cấu hình CSDL

Cập nhật thông tin kết nối SQL Server trong file `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=BT8_LTWeb;encrypt=true;trustServerCertificate=true
spring.datasource.username=sa
spring.datasource.password=sa
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

```

### Bước 3: Build & Chạy ứng dụng

```bash
mvn clean install
mvn spring-boot:run

```

### Bước 4: Truy cập giao diện & Công cụ

* **Trang User**: `http://localhost:8080/user/products`
* **Trang Admin**: `http://localhost:8080/admin/products`
* **GraphiQL UI**: `http://localhost:8080/graphiql`
* **Swagger UI**: `http://localhost:8080/swagger-ui.html`

```

```