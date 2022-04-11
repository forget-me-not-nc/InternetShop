package com.example.internetshop.services.client.impls;

import com.example.internetshop.DTO.client.req.ClientModify;
import com.example.internetshop.DTO.client.resp.ClientDTO;
import com.example.internetshop.model.Client;
import com.example.internetshop.repositories.ClientRepository;
import com.example.internetshop.services.client.services.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.ClientServiceImpl
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|22:00
 * @Version ClientServiceImpl: 1.0
 */

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {
    private final ClientRepository repository;

    @Override
    public Page<ClientDTO> getAll(Integer page, Integer size) {
        Page<Client> clients = repository.findAll(PageRequest.of(page, size));

        var clientsDTOs = clients.get().map(this::convertToDTO).collect(Collectors.toList());

        return new PageImpl<ClientDTO>(clientsDTOs);
    }

    @Override
    public ClientDTO get(Integer id) {
        return convertToDTO(repository.getById(id));
    }

    @Override
    public ClientDTO create(ClientModify entity) {

        return convertToDTO(repository.save(Client.builder()
                .address(entity.getAddress())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .middleName(entity.getMiddleName())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .build())
        );
    }

    @Override
    public ClientDTO update(ClientModify entity) {
        return convertToDTO(repository.save(Client.builder()
                .id(entity.getId())
                .address(entity.getAddress())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .middleName(entity.getMiddleName())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .build())
        );
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private ClientDTO convertToDTO(Client entity) {
        return ClientDTO.builder()
                .id(entity.getId())
                .address(entity.getAddress())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .middleName(entity.getMiddleName())
                .phone(entity.getPhone())
                .build();
    }

}