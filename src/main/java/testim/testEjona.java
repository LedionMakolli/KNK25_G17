package testim;

import models.Dto.CreateReviewsDto;
import models.Dto.UpdateReviewsDto;
import models.Reviews;
import repository.ReviewsRepository;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class testEjona {
    public static void main(String[] args) {
        try {
            ReviewsRepository reviewsRepository = new ReviewsRepository();

            // Test create
            System.out.println("Testing create...");
            CreateReviewsDto createDto = new CreateReviewsDto(
                    1,
                    1,
                    5,
                    "Great car! Very comfortable.",
                    new Timestamp(new Date().getTime())
            );
            Reviews createdReview = reviewsRepository.create(createDto);
            System.out.println("Created review: " + createdReview.getId());

            // Test getById
            System.out.println("\nTesting getById...");
            Reviews retrievedReview = reviewsRepository.getById(createdReview.getId());
            System.out.println("Retrieved review:");
            printReviewDetails(retrievedReview);

            // Test update
            if (createdReview != null) {
                UpdateReviewsDto updateDto = new UpdateReviewsDto(
                        createdReview.getId(),
                        createdReview.getClientId(), // must pass real int (not null)
                        createdReview.getCarId(),
                        4, // updated rating
                        "Good car but a bit expensive.", // updated text
                        new Timestamp(System.currentTimeMillis())
                );

                Reviews updatedReview = reviewsRepository.update(updateDto);
                if (updatedReview != null) {
                    System.out.println("Review Updated:");
                    printReviewDetails(updatedReview);
                } else {
                    System.out.println("Failed to update review.");
                }
            }

            // Test getAll
            System.out.println("\nTesting getAll...");
            System.out.println("All reviews:");
            reviewsRepository.getAll().forEach(testEjona::printReviewDetails);

            // Test delete
            System.out.println("\nTesting delete...");
            boolean deleted = reviewsRepository.delete(createdReview.getId());
            System.out.println("Delete successful: " + deleted);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printReviewDetails(Reviews review) {
        if (review == null) {
            System.out.println("Review is null");
            return;
        }
        System.out.println("ID: " + review.getId());
        System.out.println("Client ID: " + review.getClientId());
        System.out.println("Car ID: " + review.getCarId());
        System.out.println("Rating: " + review.getRating());
        System.out.println("Text: " + review.getText());
        System.out.println("Date: " + review.getDate());
        System.out.println("---------------------");
    }
}