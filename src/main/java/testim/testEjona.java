package testim;

import models.Cars;
import models.Dto.CreateCarDto;
import models.Dto.CreateOffersDto;
import models.Dto.UpdateOffersDto;
import models.Offers;
import models.enums.FuelEnum;
import models.enums.CarStatusEnum;
import models.enums.TransmissionTypeEnum;
import repository.CarRepository;
import repository.OffersRepository;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

public class testEjona {
    public static void main(String[] args) {
        try {

            OffersRepository offersRepository = new OffersRepository();


            CreateOffersDto newOffer = new CreateOffersDto(
                    1,
                    20.0,
                    Date.valueOf("2025-05-01"),
                    Date.valueOf("2025-05-15")
            );

            Offers createdOffer = offersRepository.create(newOffer);


            if (createdOffer != null) {
                System.out.println("Offer created successfully:");
                printOffer(createdOffer);
            } else {
                System.out.println("Failed to create offer.");
            }

            // Step 4: (Optional) Update the offer
            if (createdOffer != null) {
                UpdateOffersDto updateOffer = new UpdateOffersDto(
                        createdOffer.getId(),
                        null,
                        25.0,
                        null,
                        Date.valueOf("2025-05-20")
                );

                Offers updatedOffer = offersRepository.update(updateOffer);
                if (updatedOffer != null) {
                    System.out.println("Offer updated successfully:");
                    printOffer(updatedOffer);
                } else {
                    System.out.println("Failed to update offer.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void printOffer(Offers offer) {
        System.out.println("---------------------------------");
        System.out.println("Offer ID: " + offer.getId());
        System.out.println("Car ID: " + offer.getCarId());
        System.out.println("Discount: " + offer.getDiscount() + "%");
        System.out.println("Start Date: " + offer.getStartDate());
        System.out.println("End Date: " + offer.getEndDate());
        System.out.println("---------------------------------");
    }
}
