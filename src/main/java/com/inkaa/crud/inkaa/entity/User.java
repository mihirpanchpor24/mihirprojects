package com.inkaa.crud.inkaa.entity; // POJO CLASS

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // Lombok dependency annotations which requires no getter-setter
@Entity
@Builder
@NoArgsConstructor // Lombok dependency annotations which requires no getter-setter
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(nullable = false, name = "phone_number", unique = true)
	private String phoneNumber;

	@Column(nullable = false, name = "first_name")
	private String firstName;

	@Column(nullable = false, name = "last_name")
	private String lastName;

	@Column(nullable = false, name = "pin")
	private String pin;

	@Column(nullable = false, name = "vuaId", unique = true)
	private String vuaId;
}
