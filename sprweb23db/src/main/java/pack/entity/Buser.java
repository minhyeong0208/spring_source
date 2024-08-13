package pack.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "buser")
@Entity
public class Buser {
	@Id
	@Column(name = "buser_no")
	private int bno;
	
	@Column(name = "buser_name")
	private int bname;
}
