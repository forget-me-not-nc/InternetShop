package com.example.internetshop.services.book.impls;

import com.example.internetshop.DTO.author.resp.AuthorDTO;
import com.example.internetshop.DTO.book.req.BookModify;
import com.example.internetshop.DTO.book.resp.BookDTO;
import com.example.internetshop.DTO.category.resp.CategoryDTO;
import com.example.internetshop.model.Author;
import com.example.internetshop.model.Book;
import com.example.internetshop.model.Category;
import com.example.internetshop.repositories.BookRepository;
import com.example.internetshop.services.author.services.IAuthorService;
import com.example.internetshop.services.book.services.IBookService;
import com.example.internetshop.services.category.services.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.BookServiceImpl
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|21:58
 * @Version BookServiceImpl: 1.0
 */

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService {
    private final BookRepository repository;
    private final IAuthorService authorService;
    private final ICategoryService categoryService;

    @Override
    public Page<BookDTO> getAll(Integer page, Integer size) {
        Page<Book> books = repository.findAll(PageRequest.of(page, size));

        var booksDTOs = books.get().map(this::convertToDTO).collect(Collectors.toList());

        return new PageImpl<BookDTO>(booksDTOs);
    }

    @Override
    public BookDTO get(Integer id) {
        return convertToDTO(repository.getById(id));
    }

    @Override
    public BookDTO create(BookModify entity) {
        return convertToDTO(repository.save(
                Book.builder()
                        .authors(bindBookWithAuthors(entity.getAuthors()))
                        .categories(bindBookWithCategories(entity.getCategories()))
                        .price(entity.getPrice())
                        .name(entity.getName())
                        .publishingHouse(entity.getPublishingHouse())
                        .build()
                )
        );
    }

    @Override
    public BookDTO update(BookModify entity) {
        return convertToDTO(repository.save(
                Book.builder()
                        .id(entity.getId())
                        .authors(bindBookWithAuthors(entity.getAuthors()))
                        .categories(bindBookWithCategories(entity.getCategories()))
                        .price(entity.getPrice())
                        .name(entity.getName())
                        .publishingHouse(entity.getPublishingHouse())
                        .build()
                )
        );
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public BookDTO convertToDTO(Book entity) {
        return BookDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .authors(getBookAuthorDTOs(entity.getAuthors()))
                .categories(getBookCategoryDTOs(entity.getCategories()))
                .build();
    }

    @Override
    public String convertToDTOString(Integer bookId) {
        try {
            Book book = repository.getById(bookId);

            return convertToDTO(book).toString();
        } catch (Exception e) {
            return "-DELETED BOOK-";
        }
    }

    public List<AuthorDTO> getBookAuthorDTOs(List<Author> authors) {
        return authors.stream().map(
                item -> authorService.convertToDTO(item.getId())
        ).collect(Collectors.toList());
    }

    public List<CategoryDTO> getBookCategoryDTOs(List<Category> categories) {
        return categories.stream().map(
                item -> categoryService.convertToDTO(item.getId())
        ).collect(Collectors.toList());
    }

    public List<Author> bindBookWithAuthors(List<Integer> authorIds) {
        return authorIds.stream()
                .filter(
                        item -> {
                            try {
                                authorService.get(item);

                                return true;
                            } catch (Exception e) {
                                return false;
                            }
                        }
                )
                .map(
                        item -> Author.builder()
                                .id(item)
                                .build()
                )
                .collect(Collectors.toList());
    }

    public List<Category> bindBookWithCategories(List<Integer> categoryIds) {
        return categoryIds.stream()
                .filter(
                        item -> {
                            try {
                                categoryService.get(item);

                                return true;
                            } catch (Exception e) {
                                return false;
                            }
                        }
                )
                .map(
                        item -> {
                            return Category.builder()
                                    .id(item)
                                    .build();
                        }
                )
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getCategoriesNamesByBookId(Integer bookId) {
        return categoryService.getCategoriesNamesByBookId(bookId);
    }
}