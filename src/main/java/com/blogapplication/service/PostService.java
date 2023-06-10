package com.blogapplication.service;

import java.util.List;

import com.blogapplication.payload.PostDto;

public interface PostService {

	PostDto createPost(PostDto postDto);

	List<PostDto> getAllPosts();

	PostDto getPostById(long id);

	void deletePostById(long id);

	PostDto updatePost(PostDto postDto, long id);
}
