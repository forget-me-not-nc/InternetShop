package com.example.internetshop.services.author.impls;

import com.example.internetshop.DTO.author.req.AuthorModify;
import com.example.internetshop.DTO.author.resp.AuthorDTO;
import com.example.internetshop.model.Author;
import com.example.internetshop.repositories.AuthorRepository;
import com.example.internetshop.services.author.services.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.AuthorServiceImpl
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|21:57
 * @Version AuthorServiceImpl: 1.0
 */

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements IAuthorService {

    private final AuthorRepository repository;

    @Override
    public Page<AuthorDTO> getAll(Integer page, Integer size) {
        Page<Author> authors = repository.findAll(PageRequest.of(page, size));

        var authorDTOs = authors.get().map(this::convertToDTO).collect(Collectors.toList());

        return new PageImpl<AuthorDTO>(authorDTOs);
    }

    @Override
    public AuthorDTO get(Integer id) {
        return convertToDTO(repository.getById(id));
    }

    @Override
    public AuthorDTO create(AuthorModify entity) {
        return convertToDTO(repository.save(
                Author.builder()
                        .firstName(entity.getFirstName())
                        .lastName(entity.getLastName())
                        .middleName(entity.getMiddleName())
                        .info(entity.getInfo())
                        .build()
        ));
    }

    @Override
    public AuthorDTO update(AuthorModify entity) {
        return convertToDTO(repository.save(
                Author.builder()
                        .id(entity.getId())
                        .firstName(entity.getFirstName())
                        .lastName(entity.getLastName())
                        .middleName(entity.getMiddleName())
                        .info(entity.getInfo())
                        .build())
        );
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public AuthorDTO convertToDTO(Author entity) {
        return AuthorDTO.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .middleName(entity.getMiddleName())
                .build();
    }

    @Override
    public AuthorDTO convertToDTO(Integer authorId) {
        Author author = repository.getById(authorId);

        return AuthorDTO.builder()
                .middleName(author.getMiddleName())
                .lastName(author.getLastName())
                .firstName(author.getFirstName())
                .id(authorId)
                .build();
    }
}