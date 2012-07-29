package base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/*
 * Маппиннг таблицы Компании
 * */

@Entity
@Table(name="SL_COMPANY")
public class Company implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COMPANY_ID") private Integer id;
	
	//название 
	@Column(name="NAME")       private String name;
	
	//телефон
	@Column(name="TELEPHONE")  private String telephone;
	
	//адрес
	@Column(name="ADDRESS")    private String address;
	
	//список подразделений
	@OneToMany(mappedBy="company")
	private List<Division> divisions;

	
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
	
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public List<Division> getDivisions() {
		return divisions;
	}
	public void setDivisions(List<Division> divisions) {
		this.divisions = divisions;
	}

	
}
