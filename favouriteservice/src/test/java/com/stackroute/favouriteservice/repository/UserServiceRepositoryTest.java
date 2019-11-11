package com.stackroute.favouriteservice.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.favouriteservice.domain.model.User;
import com.stackroute.favouriteservice.repository.IUserServiceRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserServiceRepositoryTest {
	
	@Autowired
	private IUserServiceRepository userServiceRepo;

	private User user;

    @Before
    public void setUp(){
    	user = new User();
		user.setFirstName("Naresh");
		user.setLastName("Kumar");
		user.setUserId("naresh1");
		user.setUserPassword("pass");
		user.setUserRole("admin");
    }
    
    @After
    public void tearDown(){
    	userServiceRepo.deleteAll();
    	user=null;
    }
    
    @Test
    public void testFindByUserIdSuccess(){
    	userServiceRepo.save(user);
    	User userObj = userServiceRepo.findByUserId(user.getUserId());
        Assert.assertEquals(user.getFirstName(), userObj.getFirstName());
        userServiceRepo.delete(user);
    }
    
}
