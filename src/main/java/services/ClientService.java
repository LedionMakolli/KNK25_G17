package services;

import models.Clients;
import models.Dto.CreateClientDto;
import models.Dto.UpdateClientDto;
import models.Dto.CreateLogActivityDto;
import repository.ClientRepository;
import repository.LogActivityRepository;

public class ClientService {
    private ClientRepository clientRepository;
    private LogActivityRepository logActivityRepository;

    public ClientService() throws Exception {
        this.clientRepository = new ClientRepository();
        this.logActivityRepository = new LogActivityRepository();
    }

    public Clients getById(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("Invalid ID!");
        }
        Clients client = this.clientRepository.getById(id);
        if (client == null) {
            throw new Exception("Client with ID " + id + " does not exist!");
        }
        return client;
    }

    public Clients create(CreateClientDto clientDto) throws Exception {
        if (clientDto.getFirstName() == null || clientDto.getFirstName().isEmpty() ||
                clientDto.getLastName() == null || clientDto.getLastName().isEmpty() ||
                clientDto.getAge() <= 12 || clientDto.getEmail() == null || clientDto.getEmail().isEmpty()) {
            throw new Exception("Client data is not valid!");
        }

        Clients client = this.clientRepository.create(clientDto);
        if (client == null) {
            throw new Exception("Client not created!");
        }

        CreateLogActivityDto createLogActivityDto=new CreateLogActivityDto(
                client.getUsername(), null, "SIGN UP"
        );
        this.logActivityRepository.create(createLogActivityDto);

        return client;
    }

    public Clients update(UpdateClientDto updateDto) throws Exception {
        if (updateDto.getId() <= 0) {
            throw new Exception("Invalid ID for update!");
        }

        Clients updatedClient = this.clientRepository.update(updateDto);
        if (updatedClient == null) {
            throw new Exception("Client update failed!");
        }

        return updatedClient;
    }
}
