package testim;

import models.Dto.CreateOffersDto;
import models.Dto.UpdateOffersDto;
import models.Offers;
import repository.OffersRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class testEjona {
    public static void main(String[] args) {
        try {
            OffersRepository offersRep = new OffersRepository();

            CreateOffersDto createDto = new CreateOffersDto(
                    1,
                    10.5,
                    Date.valueOf("2025-04-15"),
                    Date.valueOf("2025-04-25")
            );

            // create
            Offers createdOffer = offersRep.create(createDto);
            if(createdOffer != null) {
                System.out.println("Created Offer ID: " + createdOffer.getId());
            } else {
                System.out.println("Offer creation failed");
                return;
            }

            // readById
            Offers readOffer = offersRep.getById(createdOffer.getId());
            if(readOffer != null) {
                System.out.println(
                        "Read Offer ID: " + readOffer.getId() +
                        ", Discount = " + readOffer.getDiscount() +
                        ", Car ID = " + readOffer.getCarId()
                );
            }


            // update
            UpdateOffersDto updateDto = new UpdateOffersDto(
                    createdOffer.getId(),
                    null,
                    20.0,
                    null,
                    Date.valueOf("2025-04-30")
            );

            Offers updatedOffer = offersRep.update(updateDto);
            if(updatedOffer != null) {
                System.out.println(
                        "Updated Offer ID: " + updatedOffer.getId() +
                        ", New Discount = " + updatedOffer.getDiscount() +
                        ", New End Date = " + updatedOffer.getEndDate()
                );
            }

            // get all
            List<Offers> allOffers = offersRep.getAll();
            System.out.println("All offers: " + allOffers.size());


            // delete
            boolean isDeleted = offersRep.delete(createdOffer.getId());
            System.out.println(isDeleted ? "Offer deleted successfully" : "Offer delete failed");



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
