package base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/*
 * Маппиннг таблицы Бизнес ролей
 * */

@Entity
@Table(name="SL_BUSINESSROLE")

public class BusinessRole implements Serializable{
	//id генерируется базой
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BUSINESSROLE_ID") private Integer id;
	
	//название роли
	@Column(name="NAME")    private String name;
	
	//Связь с подразделениями. В одном подразделении - много ролей
	@ManyToOne( fetch = FetchType.LAZY, optional = true )
	@JoinColumn(name="DIVISION_ID") private Division division;
	
	//Связь с пользователями. Одну должность могут занимать несколько человек
	@ManyToMany( fetch = FetchType.LAZY)
	@JoinTable(name="SL_USERBUSINESSROLE", joinColumns={@JoinColumn(name="BUSINESSROLE_ID")},inverseJoinColumns={@JoinColumn(name="USER_ID")})
			private List<User> users;
	
	//Связь с ролями. Должность дает определенииые роли в приложениях
	@ManyToMany ( fetch = FetchType.LAZY)
	@JoinTable(name="SL_BUSINESSROLE_ROLE", joinColumns={@JoinColumn(name="BUSINESSROLE_ID")},inverseJoinColumns={@JoinColumn(name="ROLE_ID")})
			private List<RoleList> rolelist;
	
	//Связь с привилегиями. Должность дает определенииые привилегии в приложениях
	@ManyToMany( fetch = FetchType.LAZY)
	@JoinTable(name="SL_BUSINESSROLE_PRIVILEGE", joinColumns={@JoinColumn(name="BUSINESSROLE_ID")},inverseJoinColumns={@JoinColumn(name="PRIVILEGE_ID")})
			private List<PrivilegeList> privilegelist;	
	
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
	public Division getDivision() {
		return division;
	}
	public void setDivision(Division division) {
		this.division = division;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<PrivilegeList> getPrivilegelist() {
		return privilegelist;
	}
	public void setPrivilegelist(List<PrivilegeList> privilegelist) {
		this.privilegelist = privilegelist;
	}
	public List<RoleList> getRolelist() {
		return rolelist;
	}
	public void setRolelist(List<RoleList> rolelist) {
		this.rolelist = rolelist;
	}

}
