package pack.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "buser")
public class Buser {
	@Id
	@Column(name = "buser_no")
	private int bno;
	
	@Column(name = "buser_name")
	private String bname;
	
	@OneToMany(mappedBy = "buser", fetch = FetchType.EAGER)
	private List<Jikwon> jikwons;
}
