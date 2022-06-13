package com.kitchenStory.webservice.interfaces;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.kitchenStory.webservice.model.User;

public interface UserRepository extends PagingAndSortingRepository<User,Integer>{
}
