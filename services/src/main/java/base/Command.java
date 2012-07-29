package base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/*
 * Маппиннг таблицы Команд
 * */
@Entity
@Table(name="SL_COMMAND")
public class Command implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="COMMAND_ID")
	private Integer id;
	
	//Для какого пользователя выполняется команда
	@ManyToOne( fetch = FetchType.LAZY, optional = true )
	@JoinColumn(name ="LOGIN_ID")                          
	private Account account;
	
	//Какая привилегия меняется
	@ManyToOne( fetch = FetchType.LAZY, optional = true )
	@JoinColumn(name ="PRIVILEGE_ID")                          
	private PrivilegeList privilegelist;
	
	//Для какого приложения
	@ManyToOne( fetch = FetchType.LAZY, optional = true )
	@JoinColumn(name ="APPLICATION_ID")                          
	private ApplicationList applicationlist;
	
	//Какой тип команды (создание, удаление, грант, ревок)
	@ManyToOne( fetch = FetchType.LAZY, optional = true )
	@JoinColumn(name ="COMMANDTYPE_ID")                          
	private CommandType commandtype;
	
	//Какая роль меняется
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name ="ROLE_ID")
	private RoleList rolelist;
	
	public Command()
	{
		
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public PrivilegeList getPrivilegelist() {
		return privilegelist;
	}

	public void setPrivilegelist(PrivilegeList privilegelist) {
		this.privilegelist = privilegelist;
	}

	public ApplicationList getApplicationlist() {
		return applicationlist;
	}

	public void setApplicationlist(ApplicationList applicationlist) {
		this.applicationlist = applicationlist;
	}

	public CommandType getCommandtype() {
		return commandtype;
	}

	public void setCommandtype(CommandType commandtype) {
		this.commandtype = commandtype;
	}

	public RoleList getRolelist() {
		return rolelist;
	}

	public void setRolelist(RoleList rolelist) {
		this.rolelist = rolelist;
	}

}
