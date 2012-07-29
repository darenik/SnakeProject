package base;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/*
 * Маппиннг таблицы Тип команд
 * */
@Entity
@Table(name="SL_COMMANDTYPE")
public class CommandType implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="COMMANDTYPE_ID")
	private Integer id;
	
	//название команды
	@Column(name="NAME")
	private String name;
	
	//связь с командами
	@OneToMany(mappedBy="commandtype")               
	private List<Command> command;
	public CommandType()
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
	
	
}
