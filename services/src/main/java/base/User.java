package base;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

/*
 * Маппиннг таблицы Пользователи
 * */
@Entity
@Table(name="SL_USER")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID") private Integer id;

	//Имя
	@Column(name="NAME")    private String name;
	
	//Фамилия
	@Column(name="SURNAME") private String surname;
	
	//Отчество
	@Column(name="LASTNAME")private String lastname;
	
	//День рождения
	@Column(name="BIRTHDAY")private Date birthday;
	
	//Логин
	@OneToOne
	@JoinColumn(name="LOGIN_ID") private Account account;
	
	//Занимаемые должности
	@ManyToMany(mappedBy="users") 
	private List<BusinessRole> businessRoles;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	public Account getLogin() {
		return account;
	}
	public void setLogin(Account account) {
		this.account = account;
	}
	public List<BusinessRole> getBusinessRoles() {
		return businessRoles;
	}
	public void setBusinessRoles(List<BusinessRole> businessRoles) {
		this.businessRoles = businessRoles;
	}
	
	
	
}
