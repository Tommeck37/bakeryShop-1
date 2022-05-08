package com.slodkacysia.bakeryshop.controllers;

import com.slodkacysia.bakeryshop.configuration.Authenticate;
import com.slodkacysia.bakeryshop.entity.Cart;
import com.slodkacysia.bakeryshop.entity.Purchase;
import com.slodkacysia.bakeryshop.repository.CartRepository;
import com.slodkacysia.bakeryshop.repository.PurchaseRepository;
import com.slodkacysia.bakeryshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
public class HomeController {


    private  final UserRepository userRepository;
    private final CartRepository cartRepository;

    private final PurchaseRepository purchaseRepository;

    private final Authenticate authenticate;
    @Autowired
    public HomeController(UserRepository userRepository, CartRepository cartRepository, PurchaseRepository purchaseRepository, Authenticate authenticate) {
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
        this.purchaseRepository = purchaseRepository;
        this.authenticate = authenticate;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        if(authenticate.isAuthenticated(email,password)) {

            Purchase purchase = new Purchase();
            Cart cart = new Cart();
            cart.setPurchase(purchase);
            cart.setTotal_amount(BigDecimal.valueOf(0));
            cartRepository.save(cart);
            purchase.setCart(cart);
            purchaseRepository.save(purchase);

            return "redirect:/welcome";
        }
        return "redirect:/login?error";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(
            @RequestParam(value="error", required = false)
            String error,
            @RequestParam(value="logout", required = false)
            String logout,
            Model model){

        if(error != null){
            model.addAttribute("error", "Invalid username and password");
        }

        if (logout !=null){
            model.addAttribute("msg", "You have been logged out successfully");
        }

        return "login";
    }

    @RequestMapping(value = {
            "/",
            "/welcome"
    }, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }


}
