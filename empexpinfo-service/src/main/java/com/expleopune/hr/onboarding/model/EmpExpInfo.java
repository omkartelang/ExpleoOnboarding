package com.expleopune.hr.onboarding.model;

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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empexp_info")
public class EmpExpInfo extends AuditModel<String> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empExp_id")
	private Long empExpId;
	
	@Column(name = "logIn_userId", nullable = false)
	private String usrId;
	
	@Column(name = "name_of_company")
	private String nameOfComp;
	
	@Column(name = "company_emp_id")
	private String empId;
	
	@Column(name = "from_date")
	private String frmDate;
	
	@Column(name = "to_date")
	private String toDate;
	
	@Column(name = "address_of_company")
	private String addrOfCmp;
	
	@Column(name = "company_in_city")
	private String city;
	
	@Column(name = "company_in_state")
	private String state;
	
	@Column(name = "job_title")
	private String jobTitle;
	
	@Column(name = "grade")
	private String grade;
	
	@Column(name = "reason_for_leaving")
	private String reasonForLeaving;
	
	@Column(name = "salary_in_ctc_per_anuum")
	private Double salaryInCTCPerAnnum;
	
	@Column(name = "salary_in_gross_per_month")
	private Double salaryInGrossPerMonth;
	
	@Column(name = "hr_person_name")
	private String hrPersonNam;
	
	@Column(name = "hr_person_email")
	private String hrPersonEmail;
	
	@Column(name = "hr_person_contact_number")
	private String hrPersonContact;
	
	@Column(name = "manager_name")
	private String mngrNam;
	
	@Column(name = "manager_supervisor_email")
	private String mngrSuprEmail;
	
}
