package insurance.model;
import javax.persistence.Column;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Problem {
	@Id
	@GeneratedValue

	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProblemname() {
		return problemname;
	}
	public void setProblemname(String problemname) {
		this.problemname = problemname;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getTodayd() {
		return todayd;
	}
	public void setTodayd(String todayd) {
		this.todayd = todayd;
	}

	@Column
	private String problemname;
	
	@Column
	private String message;
	private String todayd;
	
}
