package testim;

import models.Dto.CreateOffersDto;
import models.Dto.CreateReviewsDto;
import models.Dto.UpdateOffersDto;
import models.Dto.UpdateReviewsDto;
import models.Offers;
import models.Reviews;
import repository.OffersRepository;
import repository.ReviewsRepository;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Date;

public class testEjona {

//    --------------- OffersRepository ---------------
//    public static void main(String[] args) {
//        try {
//
//            OffersRepository offersRepository = new OffersRepository();
//
//
//            CreateOffersDto newOffer = new CreateOffersDto(
//                    1,
//                    20.0,
//                    Date.valueOf("2025-05-01"),
//                    Date.valueOf("2025-05-15")
//            );
//
//            Offers createdOffer = offersRepository.create(newOffer);
//
//
//            if (createdOffer != null) {
//                System.out.println("Offer created successfully:");
//                printOffer(createdOffer);
//            } else {
//                System.out.println("Failed to create offer.");
//            }
//
//            // Step 4: (Optional) Update the offer
//            if (createdOffer != null) {
//                UpdateOffersDto updateOffer = new UpdateOffersDto(
//                        createdOffer.getId(),
//                        null,
//                        25.0,
//                        null,
//                        Date.valueOf("2025-05-20")
//                );
//
//                Offers updatedOffer = offersRepository.update(updateOffer);
//                if (updatedOffer != null) {
//                    System.out.println("Offer updated successfully:");
//                    printOffer(updatedOffer);
//                } else {
//                    System.out.println("Failed to update offer.");
//                }
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Database error: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    private static void printOffer(Offers offer) {
//        System.out.println("---------------------------------");
//        System.out.println("Offer ID: " + offer.getId());
//        System.out.println("Car ID: " + offer.getCarId());
//        System.out.println("Discount: " + offer.getDiscount() + "%");
//        System.out.println("Start Date: " + offer.getStartDate());
//        System.out.println("End Date: " + offer.getEndDate());
//        System.out.println("---------------------------------");
//    }


//    --------------- ReviewsRepository ---------------
//    public static void main(String[] args) {
//        try {
//            ReviewsRepository reviewsRepository = new ReviewsRepository();
//
//            // Test create
//            System.out.println("Testing create...");
//            CreateReviewsDto createDto = new CreateReviewsDto(
//                    1,
//                    1,
//                    5,
//                    "Great car! Very comfortable.",
//                    new Timestamp(new Date().getTime())
//            );
//            Reviews createdReview = reviewsRepository.create(createDto);
//            System.out.println("Created review: " + createdReview.getId());
//
//            // Test getById
//            System.out.println("\nTesting getById...");
//            Reviews retrievedReview = reviewsRepository.getById(createdReview.getId());
//            System.out.println("Retrieved review:");
//            printReviewDetails(retrievedReview);
//
//            // Test update
//            if (createdReview != null) {
//                UpdateReviewsDto updateDto = new UpdateReviewsDto(
//                        createdReview.getId(),
//                        createdReview.getClientId(), // must pass real int (not null)
//                        createdReview.getCarId(),
//                        4, // updated rating
//                        "Good car but a bit expensive.", // updated text
//                        new Timestamp(System.currentTimeMillis())
//                );
//
//                Reviews updatedReview = reviewsRepository.update(updateDto);
//                if (updatedReview != null) {
//                    System.out.println("Review Updated:");
//                    printReviewDetails(updatedReview);
//                } else {
//                    System.out.println("Failed to update review.");
//                }
//            }
//
//            // Test getAll
//            System.out.println("\nTesting getAll...");
//            System.out.println("All reviews:");
//            reviewsRepository.getAll().forEach(testEjona::printReviewDetails);
//
//            // Test delete
//            System.out.println("\nTesting delete...");
//            boolean deleted = reviewsRepository.delete(createdReview.getId());
//            System.out.println("Delete successful: " + deleted);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void printReviewDetails(Reviews review) {
//        if (review == null) {
//            System.out.println("Review is null");
//            return;
//        }
//        System.out.println("ID: " + review.getId());
//        System.out.println("Client ID: " + review.getClientId());
//        System.out.println("Car ID: " + review.getCarId());
//        System.out.println("Rating: " + review.getRating());
//        System.out.println("Text: " + review.getText());
//        System.out.println("Date: " + review.getDate());
//        System.out.println("---------------------");
//    }

}