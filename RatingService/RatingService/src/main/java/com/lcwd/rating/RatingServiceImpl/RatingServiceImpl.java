package com.lcwd.rating.RatingServiceImpl;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.repository.RatingRepo;
import com.lcwd.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class RatingServiceImpl implements RatingService
{
    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public Rating create(Rating rating) {
        return  ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);    }
}
