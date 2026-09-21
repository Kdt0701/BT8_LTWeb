\# BT8\_LTWeb - Spring Boot GraphQL Product Category API AJAX \[COMING SOON...]



\## 1. Mục tiêu bài tập (Objectives)



Dự án \*\*BT8\_LTWeb\*\* được xây dựng nhằm tạo bộ khung ứng dụng Java Web trên nền tảng \*\*Spring Boot 3\*\*, triển khai hệ thống API với \*\*GraphQL\*\* và giao diện tương tác qua \*\*AJAX\*\*. Dự án đáp ứng các mục tiêu chính theo đề bài Bài tập 08:



\* Thiết kế và ánh xạ mô hình CSDL gồm các bảng `Category`, `User`, `Product` với các mối quan hệ:

&#x20; \* `Category` $\\leftrightarrow$ `User`: Mối quan hệ Nhiều - Nhiều (Many-to-Many).

&#x20; \* `Category` $\\leftrightarrow$ `Product`: Mối quan hệ Một - Nhiều (One-to-Many).

\* Hiện thực hệ thống \*\*GraphQL API\*\* (Query \& Mutation) cho xử lý CRUD và truy vấn dữ liệu.

\* Tích hợp công cụ thử nghiệm GraphQL (GraphiQL UI / Playground) và \*\*Swagger 3 (Springdoc OpenAPI)\*\*.

\* Xây dựng giao diện Frontend (`.html` / `.jsp`) gọi GraphQL API thông qua \*\*jQuery / AJAX\*\* để hiển thị dữ liệu động không tải lại trang.



\## 2. Mô hình Dữ liệu (Domain Model)



\* \*\*Category\*\*: `id`, `name`, `images`

\* \*\*User\*\*: `id`, `fullname`, `email`, `password`, `phone`

\* \*\*Product\*\*: `id`, `title`, `quantity`, `desc`, `price`, `userid`

\* \*\*Mối quan hệ\*\*:

&#x20; \* `Category` $\\leftrightarrow$ `User`: Mối quan hệ Nhiều - Nhiều (Many-to-Many).

&#x20; \* `Category` $\\leftrightarrow$ `Product`: Mối quan hệ Một - Nhiều (One-to-Many).



\## 3. Công nghệ dự kiến sử dụng (Tech Stack)



\* \*\*Language\*\*: Java 21

\* \*\*Framework\*\*: Spring Boot 3.x

\* \*\*API Framework\*\*: Spring GraphQL, Spring Web

\* \*\*Database \& ORM\*\*: SQL Server JDBC Driver, Spring Data JPA

\* \*\*Validation \& Utility\*\*: Spring Boot Starter Validation, Lombok

\* \*\*Documentation \& Testing\*\*: Springdoc OpenAPI (Swagger 3), GraphiQL

\* \*\*Template Engine \& UI\*\*: HTML5 / JSP, jQuery, AJAX, CSS3

\* \*\*Build Tool\*\*: Maven



\## 4. Kế hoạch thực hiện (Execution Plan)



1\. \*\*Khởi tạo Project Skeleton\*\*: Tạo dự án `BT8\_LTWeb` với cấu trúc package `vn.iotstar`, cấu hình `pom.xml` và các tệp `.gitkeep` để lưu giữ bộ khung trên GitHub.

2\. \*\*Cấu hình CSDL \& Entity JPA\*\*: Cấu hình kết nối SQL Server, ánh xạ các lớp Entity (`Category`, `Product`, `User`) kèm annotation mối quan hệ (1-N, N-N).

3\. \*\*Phát triển Repository \& Service\*\*: Xây dựng các hàm truy vấn Spring Data JPA, xử lý logic sắp xếp giá sản phẩm và tìm kiếm theo Category.

4\. \*\*Xây dựng GraphQL Schema \& Controller\*\*:

&#x20;  \* Thiết kế file schema `.graphqls` định nghĩa Types, Queries, Mutations.

&#x20;  \* Viết `@Controller` GraphQL xử lý các chức năng CRUD và Query.

&#x20;  \* Cấu hình Swagger 3 / GraphiQL UI.

5\. \*\*Giao diện AJAX Rendering\*\*: Viết trang view `.html` hoặc `.jsp`, dùng jQuery AJAX gửi request GraphQL (POST payload) để render dữ liệu lên giao diện.



\## 5. Danh sách chức năng dự kiến (Features)



\### GraphQL Query \& Mutation API

\* \[ ] \*\*CRUD Category\*\*:

&#x20; \* \[ ] Lấy danh sách tất cả Category

&#x20; \* \[ ] Thêm mới Category

&#x20; \* \[ ] Cập nhật thông tin Category

&#x20; \* \[ ] Xóa Category

\* \[ ] \*\*CRUD Product\*\*:

&#x20; \* \[ ] Lấy danh sách tất cả Product

&#x20; \* \[ ] Thêm mới Product

&#x20; \* \[ ] Cập nhật thông tin Product

&#x20; \* \[ ] Xóa Product

\* \[ ] \*\*Truy vấn nâng cao Product\*\*:

&#x20; \* \[ ] Hiển thị danh sách tất cả Product có `price` từ thấp đến cao (Ascending order)

&#x20; \* \[ ] Lấy danh sách tất cả Product thuộc về 01 Category cụ thể (`categoryId`)



\### Frontend UI \& Integration

\* \[ ] Giao diện danh sách \& quản lý Product / Category (`.html` / `.jsp`)

\* \[ ] Tích hợp jQuery AJAX gọi GraphQL API và render UI động không reload trang



\## 6. Checklist tiến độ (Progress Checklist)



\* \[ ] `\[Chưa bắt đầu]` Khởi tạo khung dự án `BT8\_LTWeb` và đẩy Skeleton lên GitHub

\* \[ ] `\[Chưa bắt đầu]` Cấu hình `application.properties` kết nối SQL Server

\* \[ ] `\[Chưa bắt đầu]` Định nghĩa Entity JPA (`Category`, `Product`, `User`)

\* \[ ] `\[Chưa bắt đầu]` Định nghĩa GraphQL Schema (`schema.graphqls`)

\* \[ ] `\[Chưa bắt đầu]` Viết Spring Data JPA Repositories

\* \[ ] `\[Chưa bắt đầu]` Viết Business Service Layer

\* \[ ] `\[Chưa bắt đầu]` Viết GraphQL Controllers (`@QueryMapping`, `@MutationMapping`, `@SchemaMapping`)

\* \[ ] `\[Chưa bắt đầu]` Cấu hình GraphiQL / Swagger 3

\* \[ ] `\[Chưa bắt đầu]` Tạo trang giao diện View (`.html` / `.jsp`) \& xử lý jQuery AJAX



\## 7. Cấu trúc thư mục dự kiến (Folder Tree)



Toàn bộ thư mục rỗng được duy trì bởi tệp `.gitkeep` để đảm bảo Git theo dõi đầy đủ cấu trúc bộ khung dự án.



```

BT8\_LTWeb/

├── database/

│   └── .gitkeep

├── src/

│   ├── main/

│   │   ├── java/

│   │   │   └── vn/

│   │   │       └── iotstar/

│   │   │           ├── config/

│   │   │           │   └── .gitkeep

│   │   │           ├── controller/

│   │   │           │   └── .gitkeep

│   │   │           ├── dto/

│   │   │           │   └── .gitkeep

│   │   │           ├── entity/

│   │   │           │   └── .gitkeep

│   │   │           ├── repository/

│   │   │           │   └── .gitkeep

│   │   │           └── service/

│   │   │               ├── .gitkeep

│   │   │               └── impl/

│   │   │                   └── .gitkeep

│   │   └── resources/

│   │       ├── graphql/

│   │       │   └── .gitkeep

│   │       ├── static/

│   │       │   ├── css/

│   │       │   │   └── .gitkeep

│   │       │   └── js/

│   │       │       └── .gitkeep

│   │       └── templates/

│   │           └── .gitkeep

│   └── test/

│       └── java/

│           └── .gitkeep

├── .gitignore

├── pom.xml

└── README.md

```



\## 8. Hướng dẫn chạy \& Phạm vi hiện tại



\* \*\*Phạm vi hiện tại\*\*: Dự án ở giai đoạn \*\*Project Skeleton\*\* (Bộ khung khởi tạo). Chưa chứa mã nguồn nghiệp vụ Java hay cấu hình CSDL thực tế.

\* \*\*Bảo mật\*\*: Không lưu trữ tài khoản/mật khẩu CSDL hay thông tin nhạy cảm trong repository.

\* \*\*Hướng dẫn các bước triển khai tiếp theo\*\*:

&#x20; 1. Clone repository về máy: `git clone <repository-url>`

&#x20; 2. Mở dự án trong IDE (IntelliJ IDEA / Eclipse).

&#x20; 3. Bổ sung cấu hình CSDL SQL Server vào `src/main/resources/application.properties`.

&#x20; 4. Thực hiện lệnh build dự án: `mvn clean install`

&#x20; 5. Chạy ứng dụng Spring Boot: `mvn spring-boot:run`

