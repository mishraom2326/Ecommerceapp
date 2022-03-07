package com.sheryians.major.controller;

import com.sheryians.major.dto.ProductDTO;
import com.sheryians.major.model.Category;
import com.sheryians.major.model.Product;
import com.sheryians.major.service.CategoryService;
import com.sheryians.major.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminController {
    public static String uploadDir=System.getProperty("user.dir")+"/src/main/resources/static/productImages";
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @GetMapping ("/admin")
        public String adminHome(){
        return "adminHome";
        }
        @GetMapping("/admin/categories")
    public String getCat(Model model){
        model.addAttribute("categories",categoryService.getAllCategories());
        return "categories";

        }
        @GetMapping("/admin/categories/add")
        public String getCatAdd(Model model){
        model.addAttribute("category",new Category());
            return "categoriesAdd";

        }
    @PostMapping ("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category){
        categoryService.addCategory(category);
        return "redirect:/admin/categories";

    }
    @GetMapping("/admin/categories/delete/{id}")
    public  String deleteCategory(@PathVariable int id){
        categoryService.deleteCategorybyid(id);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/update/{id}")
    public  String updateCategory(@PathVariable int id,Model model){
        Optional categorybyid=categoryService.getCategorybyid(id);
        if(categorybyid.isPresent()){
         model.addAttribute("category",categorybyid.get());
            return "categoriesAdd";

        }
        else return "404";


    }
    //product

    @GetMapping("/admin/products")
    public String getProd(Model model){
        model.addAttribute("products",productService.getAllProd());
        return "products";
    }


    @GetMapping("/admin/products/add")
    public String prodAddGet(Model model){
        model.addAttribute("productDTO",new ProductDTO());
        model.addAttribute("categories",categoryService.getAllCategories());
        return "productsAdd";
    }
    @PostMapping("/admin/products/add")
    public String prodAddPost(@ModelAttribute("productDTO") ProductDTO productDTO, @RequestParam("productImage")MultipartFile file,
                              @RequestParam("imgName") String imgName)throws IOException {
        Product product=new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setWeight(productDTO.getWeight());
        product.setCategory((Category) categoryService.getCategorybyid(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        String imageUUID;
        if(!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
            Path fileNameandPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameandPath, file.getBytes());
        }
        else
        {
            imageUUID=imgName;


        }
        product.setImageName(imageUUID);
        productService.addProducts(product);

return "redirect:/admin/products";

    }
    @GetMapping("/admin/product/delete/{id}")
    public String removeProdById(@PathVariable long id){
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }
    @GetMapping("/admin/product/update/{id}")
    public String updateProdById(@PathVariable long id,Model model) throws Exception{
        try{
            Optional<Product> prodbyid=productService.findProductById(id);
            ProductDTO productDTO=new ProductDTO();
            if(prodbyid.isPresent()){
                productDTO.setCategoryId(prodbyid.get().getCategory().getId());
                productDTO.setDescription(prodbyid.get().getDescription());
                productDTO.setId(prodbyid.get().getId());
                productDTO.setName(prodbyid.get().getName());
                productDTO.setImageName(prodbyid.get().getImageName());
                productDTO.setWeight(prodbyid.get().getWeight());
                productDTO.setPrice(prodbyid.get().getPrice());
                model.addAttribute("productDTO",productDTO);
                model.addAttribute("categories",categoryService.getAllCategories());

            }
        }catch(Exception e){
System.out.println("e");
        }



        return "productsAdd";
    }

}
