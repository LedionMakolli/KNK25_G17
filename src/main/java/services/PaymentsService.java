package services;

import models.Dto.CreatePaymentsDto;
import models.Payments;
import models.PromoCode;
import repository.PaymentsRepository;

import java.math.BigDecimal;
import java.sql.SQLException;

public class PaymentsService {
  private final PromoCodeService promoCodeService;
  private final PaymentsRepository paymentsRepository;

  public PaymentsService() throws SQLException{
      this.promoCodeService = new PromoCodeService();
      this.paymentsRepository = new PaymentsRepository();
  }
  public void calculateTotalAmount(Payments payments){
      BigDecimal totalNoDiscount = payments.getTotalNoDiscount();
      Integer promoCodeId = payments.getPromoCodeId();

      if(promoCodeId != null){
          PromoCode promo = promoCodeService.getPromoCodeById(promoCodeId);
          if(promo != null){
              BigDecimal discounted = promo.applyDiscount(totalNoDiscount);
              payments.setTotalFinal(discounted);
          }else {
              payments.setTotalFinal(totalNoDiscount); //nese se kena gjet promocodeId
          }
      } else {
          payments.setTotalFinal(totalNoDiscount); //nese s'eshte shkru promocodeId
      }
  }

  public Payments save(Payments payments){
      CreatePaymentsDto dto = new CreatePaymentsDto(
              payments.getIdReservation(),
              payments.getType(),
              payments.getPromoCodeId(),
              payments.getTotalNoDiscount(),
              payments.getTotalFinal(),
              payments.getDate());
     return paymentsRepository.create(dto);
  }

}
