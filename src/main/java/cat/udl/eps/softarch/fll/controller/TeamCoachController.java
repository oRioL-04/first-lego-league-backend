package cat.udl.eps.softarch.fll.controller;

import cat.udl.eps.softarch.fll.dto.AssignCoachRequest;
import cat.udl.eps.softarch.fll.dto.AssignCoachResponse;
import cat.udl.eps.softarch.fll.service.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamCoachController {

	private final CoachService teamCoachService;

	@PostMapping("/assign-coach")
	public AssignCoachResponse assignCoach(@RequestBody AssignCoachRequest request) {

		return teamCoachService.assignCoach(
			request.getTeamId(),
			request.getCoachId()
		);
	}
}