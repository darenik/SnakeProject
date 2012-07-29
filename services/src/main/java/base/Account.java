package base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/*
 * Маппиннг таблицы аккаунтов
 * */

@Entity
@Table(name="SL_ACCOUNT")
public class Account implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="LOGIN_ID")	private Integer id;
	
	//Лоин
	@Column(name="LOGIN")		private String login;
	//Пароль
	@Column(name="PASSWORD")	private String password;

	//Связь с пользователями  - один к одному
	@OneToOne(mappedBy = "account")
	private User user;
	
	@OneToMany(mappedBy = "account")
	private List<Command> command;
	
	@OneToMany(mappedBy = "account")
	private List<UserPrivilege> userprivilege;
	
	@OneToMany(mappedBy="account")
	private List<UserRole> userrole;
    
	public Account()
	{
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Command> getCommand() {
		return command;
	}

	public void setCommand(List<Command> command) {
		this.command = command;
	}

	public List<UserPrivilege> getUserprivilege() {
		return userprivilege;
	}

	public void setUserprivilege(List<UserPrivilege> userprivilege) {
		this.userprivilege = userprivilege;
	}

	public List<UserRole> getUserrole() {
		return userrole;
	}

	public void setUserrole(List<UserRole> userrole) {
		this.userrole = userrole;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
