package com.kitchenStory.webservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kitchenStory.webservice.interfaces.CartRepository;
import com.kitchenStory.webservice.interfaces.OrderRepository;
import com.kitchenStory.webservice.interfaces.ProductRepository;
import com.kitchenStory.webservice.interfaces.UserRepository;
import com.kitchenStory.webservice.model.Cart;
import com.kitchenStory.webservice.model.Order;
import com.kitchenStory.webservice.model.Product;
import com.kitchenStory.webservice.model.User;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public List<Cart> getEntityCarts(Integer pageNo, Integer pageSize, String sortBy, String username) throws Exception{
		Page<Cart> pagedResult;
		Pageable paging = PageRequest.of(pageNo, pageSize,Sort.by(sortBy));
		User searchUser = null;
		try {
			pagedResult =  cartRepository.findAll(paging);
			if(username != null) {
				
				Iterable<User> user = userRepository.findAll();
				for(User u : user) {
					if(u.getUsername().equals(username)) {
						searchUser = u;
						break;
					}
				}
				pagedResult = cartRepository.findByUserContaining(searchUser, paging);
			}
			if(pagedResult.hasContent()) {
	            return pagedResult.getContent();
	        } else {
	            return new ArrayList<Cart>();
	        }
		}
		catch(Exception ex) {
			throw new Exception("Unable to retrieve carts "+ex.getMessage().toString());
		}
	}
	public Optional<Cart> getEntityCart(int cartId) throws Exception{
		try {
			return this.cartRepository.findById(cartId);
		}
		catch(Exception ex){
			throw new Exception("Unable to retrieve cart with id"+cartId+" "+ex.getMessage().toString());
		}
	}
	public void addEntityCart(Cart addCart) throws Exception {
		try {
			this.cartRepository.save(addCart);
		}
		catch(Exception ex) {
			throw new Exception("Unable to add cart "+ex.getMessage().toString());
		}
	}
	
	public void updateEntityCart(Cart updateCart) throws Exception {
		try {
			this.cartRepository.save(updateCart);
		}
		catch(Exception ex) {
			throw new Exception("Unable to update cart "+ex.getMessage().toString());
		}
	}
	
	public void deleteEntityCart(int cartId) throws Exception {
		try {
			this.cartRepository.deleteById(cartId);
		}
		catch(Exception ex) {
			throw new Exception("Unable to delete cart "+ex.getMessage().toString());
		}
	}
}
