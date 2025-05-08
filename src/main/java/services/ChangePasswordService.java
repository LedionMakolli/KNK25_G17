package services;

import repository.ClientRepository;
import repository.StaffRepository;

public class ChangePasswordService {
    private ClientRepository clientRepository;
    private StaffRepository staffRepository;

    public ChangePasswordService() throws Exception{
        clientRepository = new ClientRepository();
        staffRepository = new StaffRepository();
    }


}
