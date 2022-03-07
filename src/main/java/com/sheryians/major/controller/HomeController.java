package com.sheryians.major.controller;

import com.sheryians.major.service.CategoryService;
import com.sheryians.major.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping("/shop")
    public String HomeCategory(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("products", productService.getAllProd());
        return "shop";


    }

    @GetMapping({"/", "/home"})
    public String homepage(Model model) {

        return "index";


    }

    @GetMapping("/shop/category/{id}")
    public String shopBycategory(Model model,@PathVariable int id){
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("products", productService.getAllProdByCat(id));
        return "shop";
    }
    @GetMapping("/shop/viewproduct/{id}")
public String prodDetails(@PathVariable long id,Model model){

        model.addAttribute("product", productService.findProductById(id).get());
        return "viewProduct";
    }

}




