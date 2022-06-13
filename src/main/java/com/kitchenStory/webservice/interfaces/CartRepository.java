package com.kitchenStory.webservice.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.kitchenStory.webservice.model.Cart;
import com.kitchenStory.webservice.model.User;


public interface CartRepository extends PagingAndSortingRepository<Cart,Integer>{
	Page<Cart> findByUserContaining(User user, Pageable pageable);
}
