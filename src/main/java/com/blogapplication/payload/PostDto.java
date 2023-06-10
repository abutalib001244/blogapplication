package com.blogapplication.payload;

import lombok.*;
@Data
public class PostDto {

	private long id;
	private String title;
	private String content;
	private String description;
}
