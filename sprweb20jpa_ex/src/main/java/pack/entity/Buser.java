package pack.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Buser {
	@Id
	@Column(name = "buser_no")
	private int bno;
	
	@Column(name = "buser_name")
	private String bname;
	
	@Column(name="buser_tel")
    private String btel;
	
	@OneToMany(mappedBy = "buser", fetch = FetchType.EAGER)
	private List<Jikwon> jikwons;
}
