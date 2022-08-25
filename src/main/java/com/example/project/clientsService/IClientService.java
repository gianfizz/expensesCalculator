package com.example.project.clientsService;
import com.example.project.ClientInformation;
import com.example.project.models.ClientModel;

import java.util.List;

public interface IClientService {

//    public String saveClient(ClientModel client);

    public List<ClientModel> getClients();

//    public ClientModel saveClient(ClientModel client);

    public void deleteClient(Long id);

    public ClientModel findClient(Long id);

    public ClientInformation createClient(ClientInformation client);
}
