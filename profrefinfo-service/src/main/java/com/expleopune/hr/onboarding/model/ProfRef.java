package com.expleopune.hr.onboarding.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profref_info")
@EntityListeners(AuditingEntityListener.class)
public class ProfRef extends AuditModel<String> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "profref_id")
	private long profrefId;
	
	@Column(name = "login_usrId")
	private String usrId;
	
	@Column(name = "person_name")
	private String personNam;
	
	@Column(name = "email_addr")
	private String emailAddr;

}
