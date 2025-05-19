package services;

import models.Dto.CreateReviewsDto;
import models.Reviews;
import repository.ReviewsRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewsService {
    private ReviewsRepository reviewsRepository;

    public ReviewsService() throws SQLException {
        this.reviewsRepository = new ReviewsRepository();
    }

    public ArrayList<Reviews> getAllReviews(){
        return this.reviewsRepository.getAll();
    }

    public Reviews createReivew(CreateReviewsDto dto){
        return this.reviewsRepository.create(dto);
    }
}
