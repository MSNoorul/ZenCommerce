package com.noor.zencommerce.service.product;
import java.util.List;

import com.noor.zencommerce.dto.ProductDto;
import com.noor.zencommerce.model.Product;
import com.noor.zencommerce.request.AddProductRequest;
import com.noor.zencommerce.request.ProductUpdateRequest;

public interface IProductService {
    Product addProduct(AddProductRequest product);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProduct(ProductUpdateRequest product, Long productId);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String category, String name);
    Long countProductsByBrandAndName(String brand, String name);

    List<ProductDto> getConvertedProducts(List<Product> products);

    ProductDto convertToDto(Product product);

   // List<Product> getDistinctProductsByCategory();

    List<Product> findDistinctProductsByName();

    List<String> getAllDistinctBrands();
}
