package services;

import models.Cars;
import models.Dto.CreatePaymentsDto;
import models.Payments;
import models.PromoCode;
import models.Reservations;
import repository.CarRepository;
import repository.PaymentsRepository;
import repository.ReservationsRepository;

import javax.print.attribute.standard.RequestingUserName;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public class PaymentsService {
  private final PromoCodeService promoCodeService;
  private final PaymentsRepository paymentsRepository;
  private final ReservationsRepository reservationsRepository;

  public PaymentsService() throws SQLException{
      this.promoCodeService = new PromoCodeService();
      this.paymentsRepository = new PaymentsRepository();
      this.reservationsRepository = new ReservationsRepository();
  }

  public Reservations getReservationById(int reservationId) throws SQLException{
      return reservationsRepository.getById(reservationId);
  }

  public void calculateTotalNoDiscount(Payments payments, Reservations reservations) throws SQLException{
      int carId = reservations.getIdCar();
      Date start = reservations.getStartDate();
      Date end = reservations.getEndDate();

      long days = (end.getTime()-start.getTime()) / (1000 * 60 * 60 * 24); //kjo long se ma preciz se int edhe sbojke int ashtu kshtu
//kjo getTime e kthen ne milisekonda e per qata krejt qikjo formule tani - 1000ms=1s, 60s = 1min, 60min = 1h, 24h = 1d
      CarRepository carRepository = new CarRepository();
      BigDecimal pricePerDay = carRepository.getDailyPrice(carId);

      BigDecimal totalNoDiscount = pricePerDay.multiply(BigDecimal.valueOf(days));
      payments.setTotalNoDiscount(totalNoDiscount);
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

  public List<Payments> checkRole() throws SQLException {
      List<Payments> payments;
      String role = SessionManager.getInstance().getCurrentRole();

      if ("client".equals(role)){
          int clientId = SessionManager.getInstance().getCurrentClient().getId();
          payments = paymentsRepository.getByClientId(clientId);
      }else {
          payments = paymentsRepository.getAll();
      }
      return payments;
  }
}
