package com.mahify.store.Service;

import com.mahify.store.entities.Address;
import com.mahify.store.entities.Category;
import com.mahify.store.entities.Product;
import com.mahify.store.entities.User;
import com.mahify.store.repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Builder
public class UserService {
    private UserRepository userRepository;
    private EntityManager entityManager;
    private AddressRepository addressRepository;
    private ProfileRepository profileRepository;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public void showEntityStates() {
        var user = User.builder()
                .name("Mahendra")
                .email("Mahe@gmail.com")
                .password("1234")
                .build();

        if (entityManager.contains(user))
            System.out.println("Transient");
        else
            System.out.println("Persistent / detacted");
        userRepository.save(user);

        if (entityManager.contains(user))
            System.out.println("Transient");
        else
            System.out.println("Persistent / detacted");
    }
    @Transactional
    public void showRelatedEntites(){
        var profile = profileRepository.findById(2L).orElseThrow();
        System.out.println(profile.getUser().getEmail());
    }

    @Transactional
    public void  fetchAddress(){
        var address = addressRepository.findById(1L).orElseThrow();
//        System.out.println(address.getUser().g);
    }

    public void persistRelated(){
        var user = User.builder()
                .name("Mahendra123").email("Mahe@gmail.com").password("Mahe123").build();
        var address = Address.builder()
                .street("street").city("city").zip("zip").state("state").build();
        user.addAddress(address);

        userRepository.save(user);
    }

    @Transactional
    public void deleteRelated(){
        var user = userRepository.findById(3L).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);
    }

    @Transactional
    public void manageProduct(){
//        step 01 -- and step 02
//        var category = categoryRepository.findById((byte) 1).orElseThrow();
//
//        var product = Product.builder()
//                .description("des 2")
//                .name("product 2")
//                .price(BigDecimal.valueOf(12.22))
//                .category(category)
//                .build();
//
//        productRepository.save(product);
//        step 03---
//        var user = userRepository.findById(3L).orElseThrow();
//        var products = productRepository.findAll();
//        products.forEach(user::addFavoriteProducts);
//        userRepository.save(user);

//        step 04
        productRepository.deleteById(4L);
    }

    @Transactional
    public void updateProductPrices(){
        productRepository.updatePriceByCategory(BigDecimal.valueOf(10),(byte) 1);
    }

    public void fetchCategories(){
       var products = productRepository.findByCategory(new Category((byte) 1));
        products.forEach(System.out::println);
    }
}
