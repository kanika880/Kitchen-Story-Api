package com.kitchenStory.webservice.interfaces;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.kitchenStory.webservice.model.Order;
import com.kitchenStory.webservice.model.User;

public interface OrderRepository extends PagingAndSortingRepository<Order,Integer>{
	Page<Order> findByUserContaining(User user, Pageable pageable);
}
