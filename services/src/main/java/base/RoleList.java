package base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/*
 * Маппиннг таблицы Список ролей
 * */
@Entity
@Table(name ="SL_ROLELIST")
public class RoleList implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="ROLE_ID")	private Integer id;
	
	//навание роли
	@Column(name="NAME")	private String name;
	
	//к какому приложению относится
	@ManyToOne( fetch = FetchType.LAZY, optional = true )
	@JoinColumn(name ="APPLICATION_ID")                          
	private ApplicationList applicationlist;
	
	//какие пользователи используют
	@OneToMany(mappedBy ="rolelist")
	private List<UserRole> userrole;
	
	//каким должностяи соответсвует
	@ManyToMany(mappedBy ="rolelist")
	private List<BusinessRole> businessrole_role;
	
	//в каких командах вызывается
	@OneToMany(mappedBy ="rolelist")
	private List<Command> command;
	
	public RoleList()
	{
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ApplicationList getApplicationlist() {
		return applicationlist;
	}

	public void setApplicationlist(ApplicationList applicationlist) {
		this.applicationlist = applicationlist;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserRole> getUserrole() {
		return userrole;
	}

	public void setUserrole(List<UserRole> userrole) {
		this.userrole = userrole;
	}



	public List<Command> getCommand() {
		return command;
	}

	public void setCommand(List<Command> command) {
		this.command = command;
	}

	public List<BusinessRole> getBusinessrole_role() {
		return businessrole_role;
	}

	public void setBusinessrole_role(List<BusinessRole> businessrole_role) {
		this.businessrole_role = businessrole_role;
	}

	
}
