package com.record.backend.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Alert {

	@Id @GeneratedValue
	@Column(name = "alert_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	//enum 타입으로 할까 고민중
	private String content;

	private LocalDate created_time;
}
