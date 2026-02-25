package com.example.spring_store.services;

import com.example.spring_store.dtos.ProductSummary;
import com.example.spring_store.dtos.ProductSummaryDto;
import com.example.spring_store.models.*;
import com.example.spring_store.repositories.*;
import com.example.spring_store.repositories.specifications.ProductSpec;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

@Transactional
    public void showEntity(){
        var user= User.builder().name("sachin").email("emai@s.com").password("password").build();

         var profile= Profile.builder().bio("test").build();
         var address= Address.builder().state("kerala").city("thiruvalla").street("jjjj").zip("899112").build();
         user.addAddress(address);




    if(entityManager.contains(user)){
            System.out.println("persistent");
        }else{
            System.out.println("transinet/ detached");
        }
        userRepository.save(user);


    if(entityManager.contains(user)){
            System.out.println("persistent");
        }else{
            System.out.println("transinet/ detached");
        }
    }

    public void findAddressById(){
    var address=  addressRepository.findById(1L).orElseThrow();
        System.out.println(address+"addd++++");
    }

@Transactional
    public void showRelatedEntities(){
        var profile = profileRepository.findById(15L).orElseThrow();
        System.out.println(profile.getUser().getEmail()+"getBioooo=======>");

    }
    public void deleteRelated(){
    userRepository.deleteById(14L);
    }
@Transactional
    public void deleteChild(){
    var user=userRepository.findById(16L).orElseThrow();
    var address=user.getAddresses().getFirst();
    user.removeAddress(address);
    userRepository.save(user);

    }

    public void createProduct(){
        var category = Category.builder()
                .name("study2")
                .build();

        var product = Product.builder()
                .name("Book")
                .price(new BigDecimal("33.00"))
                .build();

          category.addProduct(product);;

     categoryRepository.save(category);

    }

    public void addProductToExisting(){
    var category= categoryRepository.findById(2L).orElseThrow();
    var product= Product.builder().name("Dubber").price(new BigDecimal("88.99")).build();
    product.setCategory(category);
    productRepository.save(product);
    }
    @Transactional
    public void addProductToWhishlist(){

        var user= userRepository.findById(2L).orElseThrow();
        var products= productRepository.findAll();
            for(var product:products){
                user.getWishlist().add(product);

            }


    }

    public void deleteAproduct(){
    productRepository.deleteById(2L);
    }


    @Transactional
    public void fetchUsers(){
    var users =userRepository.findAllWithAddress();
        users.forEach(user -> {
            System.out.println(user );
            user.getAddresses().forEach(address -> {

            });
        });
    }
@Transactional
    public void printLoyalProfile(){
    var profiles= profileRepository .findLoyalProfiles(2);
    profiles.forEach(profile -> {
        System.out.println(profile.getId()+"====>"+profile.getEmail());
    });
    }
@Transactional
    public void fetchProducts(){
    var product = new Product();
     product.setName("Bo");
   var matcher= ExampleMatcher.matching().withIgnoreNullValues().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

       var example= Example.of(product,matcher);
       var products=productRepository.findAll(example);
       products.forEach(productOne-> {
           System.out.println(productOne+"=====>");
       });
    }

    public void fetchProductsBycriteria(){
        System.out.println("==========>");
    var products  = productRepository.findProductsCriteria(null,BigDecimal.valueOf(30), BigDecimal.valueOf(35));
        System.out.println(products+"====<<<<>>>>>>>");
    }

    public void fetchProductBySpecifications(String name, BigDecimal min, BigDecimal max){
        Specification<Product> spec= Specification.where(null);
        if(name!=null){
            spec=spec.and(ProductSpec.hasName( name));
        }if(min!=null){
            spec=spec.and(ProductSpec.hasPriceGreaterThanOrEqualTo(min));

        }
        if(max!=null){
            spec=spec.and(ProductSpec.hasPriceLessThanOrEqualTo(max));

        }

        productRepository.findAll(spec).forEach(System.out::println);


    }
    public void fetchSortedProducts(){
       var sort=  Sort.by( "name").and(Sort.by("price").descending());
       productRepository.findAll(sort).forEach(System.out::println);;
    }

    public void fetchPaginatedProducts(int page,int size){
        PageRequest pageRequest= PageRequest.of(page,size);
        Page<Product> pages=productRepository.findAll(pageRequest);
        var product=pages.getContent();
        product.forEach(System.out::println);
        var totalPages=pages.getTotalPages();
        var totalElements=pages.getTotalElements();
        System.out.println(totalElements+" "+totalPages);
    }
}
