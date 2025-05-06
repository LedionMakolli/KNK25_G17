package services;

import models.Clients;
import models.Dto.CreateLogActivityDto;
import models.Dto.LoginResponse;
import models.LogActivity;
import models.Staff;
import repository.ClientRepository;
import repository.LogActivityRepository;
import repository.StaffRepository;



public class LoginService {
    private final ClientRepository clientRepository;
    private final StaffRepository staffRepository;
    private final LogActivityRepository logActivityRepository;

    public LoginService(ClientRepository clientRepository, StaffRepository staffRepository,LogActivityRepository logActivityRepository){
        this.clientRepository = clientRepository;
        this.staffRepository = staffRepository;
        this.logActivityRepository = logActivityRepository;
    }

    public LoginResponse login(String username, String password){
        Clients client  = clientRepository.findByUsernameAndPassword(username,password);
        if (client != null) {
            ClientRegisterActivity(client.getUsername());
            return new LoginResponse("client",client.getUsername());
        }

        Staff staff  = staffRepository.findByUsernameAndPassword(username,password);
        if (staff != null){
            StaffRegisterActivity(staff.getUsername());
            return new LoginResponse("staff",staff.getUsername());
        }
        throw new RuntimeException("Invallid email or Password");
    }

    public  void StaffRegisterActivity(String staffUsername){
        CreateLogActivityDto createLogActivityDto = new CreateLogActivityDto(null,staffUsername);
        logActivityRepository.create(createLogActivityDto);
    }

    public  void ClientRegisterActivity(String clientUsername){
        System.out.println("Logging activity for clientUsername: " + clientUsername); // debug
        CreateLogActivityDto createLogActivityDto = new CreateLogActivityDto(clientUsername,null);
        logActivityRepository.create(createLogActivityDto);
    }
}
