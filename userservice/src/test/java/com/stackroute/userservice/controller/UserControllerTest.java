package com.stackroute.userservice.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.userservice.domain.model.User;
import com.stackroute.userservice.service.IJWTTokenGeneratorService;
import com.stackroute.userservice.service.IUserService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private IUserService userService;
	
	@MockBean
	IJWTTokenGeneratorService jwtTokenService;
	
	@InjectMocks
	private UserController userController;
	private User user;
	
	@Before
    public void setUp(){
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
		user = new User();
		user.setFirstName("Naresh");
		user.setLastName("Kumar");
		user.setUserId("naresh1");
		user.setUserPassword("pass");
		user.setMail("nareh@gmil.com");
    }

    @After
    public void tearDown(){
    	user = null;
    }

    @Test
	public void testRegisterUser() throws Exception {
	 	when(userService.findByUserIdAndPassword(user.getUserId(), user.getUserPassword())).thenReturn(null);
	 	when(userService.saveUser(user)).thenReturn(true);
	    mockMvc.perform(post("/cricinfo/user/register")
	    .contentType(MediaType.APPLICATION_JSON)
	            .content(jsonToString(user)))
	            .andExpect(status().isCreated()).andDo(print());
	    verify(userService, times(1)).findByUserIdAndPassword(user.getUserId(), user.getUserPassword());
	}
    
    @Test
   	public void testLogin() throws Exception {
   	 	when(jwtTokenService.generateToken(user.getUserId(), user.getUserPassword())).thenReturn("T0123xdrTYA");
   	 	when(userService.saveUser(user)).thenReturn(true);
   	    mockMvc.perform(post("/cricinfo/user/login")
   	    .contentType(MediaType.APPLICATION_JSON)
   	            .content(jsonToString(user)))
   	            .andExpect(status().isOk()).andDo(print());
   	    verify(jwtTokenService, times(1)).generateToken(user.getUserId(), user.getUserPassword());
   	}
	
	 private static String jsonToString(final Object obj) throws JsonProcessingException {
        String result;
        try{
            result = new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e){
            result = "JSON Processing Error";
        }
        return result;
	}

}
