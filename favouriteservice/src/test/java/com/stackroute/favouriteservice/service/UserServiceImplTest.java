package com.stackroute.favouriteservice.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.stackroute.favouriteservice.domain.model.User;
import com.stackroute.favouriteservice.repository.IUserServiceRepository;
import com.stackroute.favouriteservice.service.UserServiceImpl;

public class UserServiceImplTest {
	
	@Mock
    private IUserServiceRepository userServiceRepository;
    private User user;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        user = new User();
		user.setFirstName("Naresh");
		user.setLastName("Kumar");
		user.setUserId("naresh1");
		user.setUserPassword("pass");
		user.setUserRole("admin");
    }
    
    @After
    public void tearDown(){
    	user = null;
    }

    @Test
    public void testFindByUserIdSuccess(){
        Mockito.when(userServiceRepository.findByUserId(user.getUserId())).thenReturn(user);
        User usr = userService.findByUserId(user.getUserId());
        Assert.assertEquals(user, usr);
    }

}
