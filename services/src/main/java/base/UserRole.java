package base;

import java.io.Serializable;

import javax.persistence.*;

/*
 * Маппиннг таблицы Роли пользователей
 * */
@Entity
@Table(name="SL_USERROLE")
public class UserRole implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="USERROLE_ID")	private Integer id;
	
	//Какому юзеру
	@ManyToOne( fetch = FetchType.LAZY, optional = true )
	@JoinColumn(name ="LOGIN_ID")                          
	private Account account;
	
	//Какая роль
	@ManyToOne( fetch = FetchType.LAZY, optional = true )
	@JoinColumn(name ="ROLE_ID")                          
	private RoleList rolelist;
	
	public UserRole()
	{
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Account getAccount()
	{
		return account;
	}
	
	public void setAccount(Account account)	
	{
		this.account=account;
	}
	
	public RoleList getRoleList()
	{
		return rolelist;
	}
	
	public void setRoleList(RoleList rolelist)	
	{
		this.rolelist=rolelist;
	}
	
	
}
