package pack.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Gogek {
	
	@Id
	@Column(name = "gogek_no")
	private int gno;
	
	@Column(name = "gogek_name")
	private String gname;
	
	@Column(name = "gogek_tel")
	private String gtel;
	
	@Column(name="gogek_jumin")
    private String jumin;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "gogek_damsano", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private Jikwon jikwon;
}
