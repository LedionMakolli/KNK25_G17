package services;
import models.Dto.CreateOffersDto;
import repository.OffersRepository;

import java.sql.SQLException;

public class AddOfferService {
    private final OffersRepository offersRepository;

    public AddOfferService() {
        try {
            this.offersRepository = new OffersRepository();
        } catch (SQLException e) {
            throw new RuntimeException("Gabim në inicializimin e OffersRepository", e);
        }
    }

    public boolean createOffer(CreateOffersDto offerDto) {
        try {
            if (offersRepository.getByCarId(offerDto.getCarId())) {
                return false;
            }
            return offersRepository.create(offerDto) != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}