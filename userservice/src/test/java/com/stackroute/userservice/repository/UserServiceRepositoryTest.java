package com.stackroute.userservice.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.userservice.domain.model.User;

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
		user.setMail("admin@gmail.com");
    }
    
    @After
    public void tearDown(){
    	userServiceRepo.deleteAll();
    	user=null;
    }
    
    @Test
    public void testFindByUserIdAndUserPassword(){
    	userServiceRepo.save(user);
    	User userObj = userServiceRepo.findByUserIdAndUserPassword(user.getUserId(), user.getUserPassword());
        Assert.assertEquals(user.getFirstName(), userObj.getFirstName());
        userServiceRepo.delete(user);
    }

}
