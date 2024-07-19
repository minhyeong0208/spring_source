package pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder  
@NoArgsConstructor  
@AllArgsConstructor
@Entity
@Table(name="gogek") 
public class GogekDto {
	@Id
	@Column(name="gogek_no")
	private int no;
	
	@Column(name="gogek_name")
	private String name;
	
	@Column(name="gogek_tel")
	private String tel;  
}
