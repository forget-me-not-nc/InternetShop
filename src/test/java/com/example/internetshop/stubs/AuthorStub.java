package com.example.internetshop.stubs;

import com.example.internetshop.DTO.author.req.AuthorModify;
import com.example.internetshop.DTO.author.resp.AuthorDTO;
import com.example.internetshop.model.Author;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.AuthorStub
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 09.04.2022|14:14
 * @Version AuthorStub: 1.0
 */

public final class AuthorStub {

    public static final Integer ID = 1;
    public static final Integer page = 0;
    public static final Integer size = 2;

    public static Author generateAuthor() {
        return Author.builder()
                .id(ID)
                .info("Info")
                .firstName("FirstName")
                .middleName("MiddleName")
                .lastName("LastName")
                .books(new ArrayList<>())
                .build();
    }

    public static List<Author> generateAuthorsList() {
        return new ArrayList<>(
                Arrays.asList(
                        Author.builder()
                                .id(ID)
                                .info("Info")
                                .firstName("FirstName")
                                .middleName("MiddleName")
                                .lastName("LastName")
                                .books(new ArrayList<>())
                                .build(),
                        Author.builder()
                                .id(ID + 1)
                                .info("Info")
                                .firstName("FirstName")
                                .middleName("MiddleName")
                                .lastName("LastName")
                                .books(new ArrayList<>())
                                .build()
                )
        );
    }

    public static AuthorModify generateAuthorModifyRequest() {
        return AuthorModify.builder()
                .id(ID)
                .firstName("FirstName")
                .middleName("MiddleName")
                .lastName("LastName")
                .info("Info")
                .build();
    }

    public static AuthorDTO generateDTO() {
        return AuthorDTO.builder()
                .id(ID)
                .firstName("FirstName")
                .middleName("MiddleName")
                .lastName("LastName")
                .build();
    }

    public static AuthorDTO generateDTO_2() {
        return AuthorDTO.builder()
                .id(ID + 1)
                .firstName("FirstName")
                .middleName("MiddleName")
                .lastName("LastName")
                .build();
    }
}