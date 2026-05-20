package com.lcwd.user.service.UserServiceImpl;

import com.lcwd.user.service.Exception.ResourceNotFoundException;
import com.lcwd.user.service.Repository.UserRepository;
import com.lcwd.user.service.Services.UserServices;
import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.external.services.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServices
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
   private  RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user)
    {

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser()
    {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not found on server"+userId));
        //get ratings above user from RATING service
        //http://localhost:8083/ratings/users/b384b6a0-d041-4099-b16f-7edd3d957a74
      Rating[] ratingsOfUser=restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
      logger.info("{}",ratingsOfUser);

      //get users giev rating each hotels

        List<Rating> ratings=Arrays.stream(ratingsOfUser).toList();

     List<Rating> ratingList= ratings.stream().map(rating->
     {
         //api call hotel service to get hotel
         //http://localhost:8082/hotels/1c278a40-6c47-46c2-9cbe-7917fc2d2d06
//        ResponseEntity<Hotel> forEntity=restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
        Hotel hotel=hotelService.getHotel(rating.getHotelId());
//        logger.info("Response Status Cpde",forEntity.getStatusCode());

         //set the hotel to rating
         rating.setHotel(hotel);


         //return the rating
         return rating;

      }).collect(Collectors.toList());

      user.setRatings(ratingList);

        return user;
    }
}
