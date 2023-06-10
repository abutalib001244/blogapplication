package com.blogapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.entity.Post;
import com.blogapplication.payload.PostDto;
import com.blogapplication.service.PostService;

@RestController
@RequestMapping("/api/POST_DTLS")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
		PostDto dto = postService.createPost(postDto);
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<PostDto>> getAllPosts(){
		List<PostDto> dtos = postService.getAllPosts();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable("id") long id){
		PostDto dto = postService.getPostById(id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePostById(@PathVariable("id") long id){
		postService.deletePostById(id);
		return new ResponseEntity<>("Post is deleted", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable("id") long id){
		PostDto dto = postService.updatePost(postDto, id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

}
