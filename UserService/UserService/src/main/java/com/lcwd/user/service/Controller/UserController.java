package com.lcwd.user.service.Controller;

import com.lcwd.user.service.Services.UserServices;
import com.lcwd.user.service.entities.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.Getter;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserServices userServices;
    private static final Logger logger =
            LoggerFactory.getLogger(UserController.class);

    //create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        String randomUserId=UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        User user1=userServices.saveUser(user);
        //generate unique userid

        return  ResponseEntity.status(HttpStatus.CREATED).body(user1);

    }
    //single user
    int retrycount =1 ;
    @GetMapping("/{userId}")
//    @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    @Retry(name="ratingHotelService",fallbackMethod = "ratingHotelFallback")
    //@RateLimiter(name="userRateLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUserResponseEntity(@PathVariable  String userId)
    {
//        logger.info("Retry Count:"+retrycount);
//        retrycount++;
        logger.info("REAL SERVICE CALLED for userId: " + userId);
        User user=userServices.getUser(userId);
        return  ResponseEntity.ok(user);

    }


    //all get user
    @GetMapping
    public ResponseEntity<List<User>> getAllUser()
    {
        List<User> alluser=userServices.getAllUser();
        return  ResponseEntity.ok(alluser);
    }

    //create fall back mwthod for circuotbreaker


    public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex)
    {
        logger.info("FALLBACK TRIGGERED for userId: " + userId);
        logger.info("Fallback is executed becuase service is down"+ex.getMessage());
        User user=User.builder()
                .email("ankit@gmail.com")
                .name("Ankit")
                .about("hi hello")
                .userId("431234")
                .build();
        return new ResponseEntity<>(user,HttpStatus.OK);


    }

}
