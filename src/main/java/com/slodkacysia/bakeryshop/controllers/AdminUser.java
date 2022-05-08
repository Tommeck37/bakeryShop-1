package com.slodkacysia.bakeryshop.controllers;

import com.slodkacysia.bakeryshop.configuration.Authenticate;
import com.slodkacysia.bakeryshop.configuration.AuthenticateAdmin;
import com.slodkacysia.bakeryshop.entity.Category;
import com.slodkacysia.bakeryshop.entity.Product;
import com.slodkacysia.bakeryshop.repository.CategoryRepository;
import com.slodkacysia.bakeryshop.repository.ProductRepository;
import com.slodkacysia.bakeryshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/admin")
public class AdminUser {

    private final AuthenticateAdmin authenticateAdmin;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;
    @Autowired
    AdminUser(AuthenticateAdmin authenticateAdmin, UserRepository userRepository, ProductRepository productRepository, CategoryRepository categoryRepository){
        this.authenticateAdmin = authenticateAdmin;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "adminLogin";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        if(authenticateAdmin.isAuthenticated("tomasz.czornak59@gmail.com",password)) {
            return "redirect:/welcome";
        }
        return "redirect:/login?error";
    }

    @RequestMapping("/add-product")
    public String addProductForm(Model model) {

        model.addAttribute("product", new Product());

        return "addProduct";
    }
    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public String saveProductForm(@Valid Product product, BindingResult result) {

        if (result.hasErrors()) {
            return "addProduct";
        } else {

            productRepository.save(product);
            return "redirect:/productList";
        }
    }

    @RequestMapping("/productlist")
    public String list(Model model){
        model.addAttribute("products", productRepository.findAllBy());

        return "productList";
    }
    @ModelAttribute("categories")
    public List<Category> getAllCategories(){
        return categoryRepository.findAllBy();
    }
}
