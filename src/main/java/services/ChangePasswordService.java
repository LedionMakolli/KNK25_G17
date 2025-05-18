package services;

import models.Clients;
import models.Dto.UpdateClientDto;
import models.Dto.UpdateStafDto;
import models.Staff;
import repository.ClientRepository;
import repository.StaffRepository;

public class ChangePasswordService {
    private ClientRepository clientRepository;
    private StaffRepository staffRepository;

    public ChangePasswordService() throws Exception{
        clientRepository = new ClientRepository();
        staffRepository = new StaffRepository();
    }

public boolean changePassword(String oldPassword, String newPassword){
        try{
          String role = SessionManager.getInstance().getCurrentRole();

          if(role.equals("client")){
              Clients client = SessionManager.getInstance().getCurrentClient();
              String hashOld = PasswordHasher.generateSaltedHash(oldPassword, client.getSalt());

              if(!hashOld.equals(client.getPassword())){
                  return false;
              }

              String newSalt = PasswordHasher.generateSalt();
              String newHashed = PasswordHasher.generateSaltedHash(newPassword, newSalt);
              client.setPassword(newHashed);
              client.setSalt(newSalt);
              UpdateClientDto updateClientDto = new UpdateClientDto(client.getId(), client.getAge(), client.getEmail(),newHashed, client.getSalt(), client.getTelephoneNumber());
              return clientRepository.update(updateClientDto) != null;
          }
          if(role.equals("staff")){
              Staff staff = SessionManager.getInstance().getCurrentStaff();
              String hashOld = PasswordHasher.generateSaltedHash(oldPassword, staff.getSalt());

              if(!hashOld.equals(staff.getPassword())){
                  return false;
              }

              String newSalt = PasswordHasher.generateSalt();
              String newHashed = PasswordHasher.generateSaltedHash(newPassword, newSalt);
              staff.setPassword(newHashed);
              staff.setSalt(newSalt);

              UpdateStafDto updateStaffDto = new UpdateStafDto(staff.getId(), staff.getAge(), staff.getEmail(), newHashed, staff.getSalt(), staff.getTelephoneNumber(), staff.getPosition(), staff.getSalary());
              return staffRepository.update(updateStaffDto) != null;
          }
        }catch(Exception e){
          e.printStackTrace();
          throw new RuntimeException("Ndodhi nje gabim gjate nderrimit te fjalekalimit");

        }
        return true;
    }
}
