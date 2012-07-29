package base;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/*
 * Маппиннг таблицы Список привилегий
 * */
@Entity
@Table(name="SL_PRIVILEGELIST")
public class PrivilegeList implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="PRIVILEGE_ID")	private Integer id;
    
	//название привилегии
	@Column(name="NAME")			private String name;
	
	//к какому приложению относится
	@ManyToOne( fetch = FetchType.LAZY, optional = true )
	@JoinColumn(name ="APPLICATION_ID")                          
	private ApplicationList applicationlist;
	
	//какие пользователи пользуются
	@OneToMany(mappedBy ="privilegelist")
	private List<UserPrivilege> userprivilige;

	//в каких командах
	@OneToMany(mappedBy="privilegelist")
	private List<Command> command;
	
	//к каким должностям привязана
	@ManyToMany(mappedBy ="privilegelist")
	private List<BusinessRole> businessrole_privilege;
	
	public PrivilegeList()
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
	
	public ApplicationList getApplicationList()
	{
		return applicationlist;
	}
	
	public void setApplicationList( ApplicationList applicationlist)
	{
		this.applicationlist=applicationlist;
	}

	public List<UserPrivilege> getUserprivilige() {
		return userprivilige;
	}

	public void setUserprivilige(List<UserPrivilege> userprivilige) {
		this.userprivilige = userprivilige;
	}

	public List<Command> getCommand() {
		return command;
	}

	public void setCommand(List<Command> command) {
		this.command = command;
	}

	public List<BusinessRole> getBusinessrole_privilege() {
		return businessrole_privilege;
	}

	public void setBusinessrole_privilege(List<BusinessRole> businessrole_privilege) {
		this.businessrole_privilege = businessrole_privilege;
	}

	
	
	
}
