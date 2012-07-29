package base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/*
 * Маппиннг таблицы Подразделения
 * */
@Entity
@Table(name="SL_DIVISION")
public class Division implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DIVISION_ID") private Integer id;
	
	//название подразделения
	@Column(name="NAME")       private String name;
	
	//к какой компании относится
	@ManyToOne
	@JoinColumn(name="COMPANY_ID") private Company company;
	
	//связь с родительским подразделением
	@ManyToOne
	@JoinColumn(name="PARENTDIVISION_ID")	private Division parentdivision;
	
	//родительское подразделение
	@OneToMany(mappedBy="parentdivision")
	private List<Division> child;
	
	//список должностей у подразделения
	@OneToMany(mappedBy="division") 
	private List<BusinessRole> businessRoles;
	
	
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
	
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}

	public List<BusinessRole> getBusinessRoles() {
		return businessRoles;
	}

	public void setBusinessRoles(List<BusinessRole> businessRoles) {
		this.businessRoles = businessRoles;
	}

	public List<Division> getChild() {
		return child;
	}

	public void setChild(List<Division> child) {
		this.child = child;
	}

	public Division getParentdivision() {
		return parentdivision;
	}

	public void setParentdivision(Division parentdivision) {
		this.parentdivision = parentdivision;
	}

}
