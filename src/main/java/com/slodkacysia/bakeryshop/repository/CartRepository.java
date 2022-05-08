package com.slodkacysia.bakeryshop.repository;

import com.slodkacysia.bakeryshop.entity.Cart;
import com.slodkacysia.bakeryshop.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    public  Cart save(Cart cart);

    public Cart getCartById(long cartId);

}
