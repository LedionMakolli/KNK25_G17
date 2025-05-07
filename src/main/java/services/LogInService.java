package services;

import models.Clients;
import models.Dto.CreateLogActivityDto;
import models.Dto.LoginResponse;
import models.Staff;
import repository.ClientRepository;
import repository.LogActivityRepository;
import repository.StaffRepository;

public class LogInService {
    private ClientRepository clientRepository;
    private StaffRepository staffRepository;
    private LogActivityRepository logActivityRepository;

    public LogInService() throws Exception {
        this.clientRepository = new ClientRepository();
        this.staffRepository = new StaffRepository();
        this.logActivityRepository = new LogActivityRepository();
    }

    public LoginResponse login(String username, String password){
        Clients client  = clientRepository.findByUsernameAndPassword(username,password);
        if (client != null) {
            String salt = client.getSaltedHash(); // salt
            String storedHash = client.getPassword(); // satlted hash

            String inputHash = PasswordHasher.generateSaltedHash(password,salt);
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

    public void StaffRegisterActivity(String staffUsername){
        CreateLogActivityDto createLogActivityDto = new CreateLogActivityDto(null,staffUsername);
        logActivityRepository.create(createLogActivityDto);
    }

    public void ClientRegisterActivity(String clientUsername){
        System.out.println("Logging activity for clientUsername: " + clientUsername); // debug
        CreateLogActivityDto createLogActivityDto = new CreateLogActivityDto(clientUsername,null);
        logActivityRepository.create(createLogActivityDto);
    }
}
