package insurance.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
    @Table
	public class Contact{
	
	@Id
	@GeneratedValue
	
	@Column
	private Integer Id;
	
	@Column
	private String Name;
	
	@Column
	private String Email;
	
	@Column 
	private Double PhoneNumber;
	
	@Column
	private String Message;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Double getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(Double phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	
}
