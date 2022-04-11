package com.example.internetshop.services.user.impls;

import com.example.internetshop.DTO.user.req.UserModify;
import com.example.internetshop.DTO.user.resp.UserDTO;
import com.example.internetshop.model.User;
import com.example.internetshop.repositories.UserRepository;
import com.example.internetshop.services.user.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.UserServiceImpl
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|22:02
 * @Version UserServiceImpl: 1.0
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final UserRepository repository;

    @Override
    public Page<UserDTO> getAll(Integer page, Integer size) {
        Page<User> users = repository.findAll(PageRequest.of(page, size));

        var usersDTOs = users.get().map(this::convertToDTO).collect(Collectors.toList());

        return new PageImpl<UserDTO>(usersDTOs);
    }

    @Override
    public UserDTO get(Integer id) {
            return convertToDTO(repository.getById(id));
    }

    @Override
    public UserDTO create(UserModify entity) {

        return convertToDTO(repository.save(User.builder()
                .username(entity.getUsername())
                .password(entity.getPassword())
                .build())
        );
    }

    @Override
    public UserDTO update(UserModify entity){

        return convertToDTO(repository.save(User.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .build())
        );
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private UserDTO convertToDTO(User entity) {
        return UserDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .build();
    }
}