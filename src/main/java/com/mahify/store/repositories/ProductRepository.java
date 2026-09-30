package com.mahify.store.repositories;

import com.mahify.store.dtos.ProductSummary;
import com.mahify.store.dtos.ProductSummaryDTO;
import com.mahify.store.entities.Category;
import com.mahify.store.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByName(String name);
    List<Product> findByNameIgnoreCase(String name);

    @Modifying
    @Query("update Product p set p.price = :newPrice where p.category.id = :categoryId")
    public void updatePriceByCategory(@Param("newPrice") BigDecimal newPrice, @Param("categoryId") Byte categoryId);

    @Query("select new com.mahify.store.dtos.ProductSummaryDTO(p.id,p.name) from Product p where p.category = :category")
    List<ProductSummaryDTO> findByCategory(@Param("category") Category category);
}