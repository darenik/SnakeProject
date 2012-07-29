package base;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
/*
 * Маппиннг таблицы список приложений
 * */
@Entity
@Table(name="SL_APPLICATIONLIST")
public class ApplicationList implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="APPLICATION_ID")	private Integer id;
	//название приложения
	@Column(name = "NAME")			private String name;
	
	//Связь с невыполненными командами
	@OneToMany(mappedBy = "applicationlist")
	private List<Command> command;
	
	//Связь со списком ролей в приложении
	@OneToMany(mappedBy = "applicationlist")
	private List<RoleList> rolelist;
	
	//Связь со списком привилегий в приложении
	@OneToMany(mappedBy = "applicationlist")
	private List<PrivilegeList> privilegelist;
	
	public ApplicationList()
	{
		
	}
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
	public List<Command> getCommand() {
		return command;
	}
	public void setCommand(List<Command> command) {
		this.command = command;
	}
	public List<RoleList> getRolelist() {
		return rolelist;
	}
	public void setRolelist(List<RoleList> rolelist) {
		this.rolelist = rolelist;
	}
	public List<PrivilegeList> getPrivilegelist() {
		return privilegelist;
	}
	public void setPrivilegelist(List<PrivilegeList> privilegelist) {
		this.privilegelist = privilegelist;
	}
	
	
}
