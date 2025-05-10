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

            SessionManager.getInstance().loginClient(client); //edhe qit rresht e kom shtu per me lidh me sessionmanager mu rujt gjendja e login - Dua
            ClientRegisterActivity(client.getUsername());
            return new LoginResponse("client",client.getUsername());
        }

        Staff staff  = staffRepository.findByUsernameAndPassword(username, password);
        if (staff != null){

            SessionManager.getInstance().loginStaff(staff); //njejt si ma nalt veq me staf - Dua
            StaffRegisterActivity(staff.getUsername());
            return new LoginResponse("staff", staff.getUsername());
        }
        return null;
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
