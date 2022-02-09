package com.record.backend.domain.alert;

import static javax.persistence.FetchType.*;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.record.backend.domain.user.User;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Alert {

	@Id
	@GeneratedValue
	@Column(name = "alert_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	private String content;

	private LocalDateTime created_time;
}
