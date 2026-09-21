package vn.iotstar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    // Trang dành cho User: Xem & Lọc sản phẩm
    @GetMapping({"/", "/user/products"})
    public String userProductsPage() {
        return "user/products";
    }

    // Trang Admin: Quản lý Danh mục
    @GetMapping("/admin/categories")
    public String adminCategoriesPage() {
        return "admin/categories";
    }

    // Trang Admin: Quản lý Sản phẩm
    @GetMapping("/admin/products")
    public String adminProductsPage() {
        return "admin/products";
    }
}