package insurance.model;
import javax.persistence.Column;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Manishapp {
	@Id
	@GeneratedValue

	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPolicynamea() {
		return policynamea;
	}
	public void setPolicynamea(String policynamea) {
		this.policynamea = policynamea;
	}
	
	public String getCreationa() {
		return creationa;
	}
	public void setCreationa(String creationa) {
		this.creationa = creationa;
	}
	
	public String getSuma() {
		return suma;
	}
	public void setSuma(String suma) {
		this.suma = suma;
	}

	public String getAmounta() {
		return amounta;
	}
	public void setAmounta(String amounta) {
		this.amounta = amounta;
	}

	public String getInteresta() {
		return interesta;
	}
	public void setInteresta(String interesta) {
		this.interesta = interesta;
	}

	@Column
	private String policynamea;
	
	@Column
	private String creationa;
	private String suma;
	private String amounta;
	private String interesta;
}
