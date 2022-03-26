package com.example.internetshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.Book
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 12.02.2022|17:39
 * @Version Book: 1.0
 */

@Entity(name = "books")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private BigDecimal price;
	private String name;
	private String publishingHouse;

	@ManyToMany
	@JoinTable(
			name = "bookHasAuthor",
			joinColumns = @JoinColumn(name = "book_id"),
			inverseJoinColumns = @JoinColumn(name = "author_id")
	)
	private List<Author> authors;

	@ManyToMany
	@JoinTable(
			name = "bookHasCategory",
			joinColumns = @JoinColumn(name = "book_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id")
	)
	private List<Category> categories;
}