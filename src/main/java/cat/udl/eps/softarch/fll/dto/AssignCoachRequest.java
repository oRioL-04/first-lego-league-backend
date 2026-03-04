package cat.udl.eps.softarch.fll.dto;

import lombok.Data;

@Data
public class AssignCoachRequest {
	private String teamId;
	private Integer coachId;
}