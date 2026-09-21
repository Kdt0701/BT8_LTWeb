package vn.iotstar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Product;
import vn.iotstar.entity.User;
import vn.iotstar.repository.CategoryRepository;
import vn.iotstar.repository.ProductRepository;
import vn.iotstar.repository.UserRepository;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class GraphQLController {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    // ================= QUERIES =================

    @QueryMapping
    public List<Product> allProductsByPriceAsc() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    @QueryMapping
    public List<Product> productsByCategory(@Argument Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @QueryMapping
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    @QueryMapping
    public Category categoryById(@Argument Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    @QueryMapping
    public Product productById(@Argument Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // ================= MUTATIONS CATEGORY =================

    @MutationMapping
    public Category createCategory(@Argument Map<String, Object> input) {
        Category category = Category.builder()
                .name((String) input.get("name"))
                .images((String) input.get("images"))
                .build();
        return categoryRepository.save(category);
    }

    @MutationMapping
    public Category updateCategory(@Argument Long id, @Argument Map<String, Object> input) {
        Category category = categoryRepository.findById(id).orElseThrow();
        category.setName((String) input.get("name"));
        category.setImages((String) input.get("images"));
        return categoryRepository.save(category);
    }

    @MutationMapping
    public Boolean deleteCategory(@Argument Long id) {
        categoryRepository.deleteById(id);
        return true;
    }

    // ================= MUTATIONS PRODUCT =================

    @MutationMapping
    public Product createProduct(@Argument Map<String, Object> input) {
        Long categoryId = Long.parseLong(input.get("categoryId").toString());
        Category category = categoryRepository.findById(categoryId).orElseThrow();

        User user = null;
        if (input.get("userId") != null) {
            Long userId = Long.parseLong(input.get("userId").toString());
            user = userRepository.findById(userId).orElse(null);
        }

        Product product = Product.builder()
                .title((String) input.get("title"))
                .quantity(Integer.parseInt(input.get("quantity").toString()))
                .desc((String) input.get("desc"))
                .price(Double.parseDouble(input.get("price").toString()))
                .category(category)
                .user(user)
                .build();

        return productRepository.save(product);
    }

    @MutationMapping
    public Product updateProduct(@Argument Long id, @Argument Map<String, Object> input) {
        Product product = productRepository.findById(id).orElseThrow();

        if (input.get("categoryId") != null) {
            Long categoryId = Long.parseLong(input.get("categoryId").toString());
            Category category = categoryRepository.findById(categoryId).orElseThrow();
            product.setCategory(category);
        }

        product.setTitle((String) input.get("title"));
        product.setQuantity(Integer.parseInt(input.get("quantity").toString()));
        product.setDesc((String) input.get("desc"));
        product.setPrice(Double.parseDouble(input.get("price").toString()));

        return productRepository.save(product);
    }

    @MutationMapping
    public Boolean deleteProduct(@Argument Long id) {
        productRepository.deleteById(id);
        return true;
    }
}