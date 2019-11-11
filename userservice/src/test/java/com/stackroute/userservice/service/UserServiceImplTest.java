package com.stackroute.userservice.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.stackroute.userservice.domain.model.User;
import com.stackroute.userservice.repository.IUserServiceRepository;

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
		user.setMail("admin@gmail.com");
    }
    
    @After
    public void tearDown(){
    	user = null;
    }

    @Test
    public void testFindByUserIdAndPassword() throws Exception {
        Mockito.when(userServiceRepository.findByUserIdAndUserPassword(user.getUserId(), user.getUserPassword())).thenReturn(user);
        User usr = userService.findByUserIdAndPassword(user.getUserId(), user.getUserPassword());
        Assert.assertEquals(user, usr);
    }
    
    @Test
    public void testSaveUser() throws Exception {
        Mockito.when(userServiceRepository.save(user)).thenReturn(user);
        boolean isUserCreated = userService.saveUser(user);
        Assert.assertEquals(true, isUserCreated);
    }
}
