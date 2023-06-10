package com.blogapplication.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplication.entity.Post;
import com.blogapplication.exception.ResourceNotFoundException;
import com.blogapplication.payload.PostDto;
import com.blogapplication.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public PostDto createPost(PostDto postDto) {
		Post post = new Post();
		post.setTilte(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setDescription(postDto.getDescription());
		Post newPost = postRepository.save(post);
		
		PostDto dto = new PostDto();
		dto.setId(newPost.getId());
		dto.setTitle(newPost.getTilte());
		dto.setContent(newPost.getContent());
		dto.setDescription(newPost.getDescription());
		return dto;
	}

	@Override
	public List<PostDto> getAllPosts() {
		List<Post> posts = postRepository.findAll();
		List<PostDto> dtos = posts.stream().map(post->mapToDto(post)).collect(Collectors.toList());
		return dtos;
	}
	PostDto mapToDto(Post post) {
		PostDto dto = new PostDto();
		dto.setId(post.getId());
		dto.setTitle(post.getTilte());
		dto.setContent(post.getContent());
		dto.setDescription(post.getDescription());
		return dto;
	}

	@Override
	public PostDto getPostById(long id) {
		Post post = postRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("post not found with id: "+id)
				);
		return mapToDto(post);
	}

	@Override
	public void deletePostById(long id) {
		Post post =postRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("post not found with id: "+id)
				);
		postRepository.deleteById(id);
		
	}

	@Override
	public PostDto updatePost(PostDto postDto, long id) {
		Post post =postRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("post not found with id: "+id)
				);
		Post newPost = mapToEntity(postDto);
		newPost.setId(id);
		Post updated = postRepository.save(newPost);
		return mapToDto(updated);
	}
	
	Post mapToEntity(PostDto postDto) {
		Post post = new Post();
		post.setId(postDto.getId());
		post.setTilte(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setDescription(postDto.getDescription());
		return post;
	}
}
