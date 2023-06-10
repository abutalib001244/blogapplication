package com.blogapplication.entity;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="POST_DTLS")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="title", nullable=false, unique=true)
	private String tilte;
	
	@Column(name="content", nullable=false, unique=true)
	private String content;
	
	@Column(name="description", nullable=false, unique=true)
	private String description;

}
