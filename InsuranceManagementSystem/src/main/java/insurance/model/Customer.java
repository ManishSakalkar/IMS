package insurance.model;
import javax.persistence.Column;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table
public class Customer {
	@Id
	@GeneratedValue

	private Integer id;
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Double getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(Double mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getUsern() {
		return usern;
	}
	public void setUsern(String usern) {
		this.usern = usern;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column
	private String name;
	
	@Column
	private Double mobilenumber;
	private String gender;
	private String email;

	private String addr;
	public String usern;
	public String password;
	
}
