package services;

import models.Payments;
import models.PromoCode;
import repository.PromoCodeRepository;

import java.math.BigDecimal;
import java.sql.SQLException;

public class PromoCodeService {
    private final PromoCodeRepository promoCodeRepository;

    public PromoCodeService() throws SQLException{
        this.promoCodeRepository = new PromoCodeRepository();
    }

    public PromoCode getPromoCodeById(Integer promoId){
        if(promoId == null) {
            return null;
        }
        return promoCodeRepository.getById(promoId);
    }
}
