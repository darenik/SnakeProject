package base;


import java.io.Serializable;

import javax.persistence.*;

/*
 * Маппиннг таблицы Привилегии каждого пользователя
 * */
@Entity
@Table(name="SL_USERPRIVILEGE")
public class UserPrivilege implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="USERPRIVILEGE_ID")	private Integer id;
	
	//Какому юзеру предоставлена
	@ManyToOne( fetch = FetchType.LAZY, optional = true )
	@JoinColumn(name ="LOGIN_ID")                          
	private Account account;
	
	//Какая привилегия
	@ManyToOne( fetch = FetchType.LAZY, optional = true )
	@JoinColumn(name ="PRIVILEGE_ID")                          
	private PrivilegeList privilegelist;
	
	public UserPrivilege()
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

}
