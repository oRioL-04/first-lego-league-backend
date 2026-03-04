package cat.udl.eps.softarch.fll.service;

import cat.udl.eps.softarch.fll.domain.Coach;
import cat.udl.eps.softarch.fll.domain.Team;
import cat.udl.eps.softarch.fll.dto.AssignCoachRequest;
import cat.udl.eps.softarch.fll.dto.AssignCoachResponse;
import cat.udl.eps.softarch.fll.repository.CoachRepository;
import cat.udl.eps.softarch.fll.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CoachService {

	private final TeamRepository teamRepository;
	private final CoachRepository coachRepository;

	public AssignCoachResponse assignCoach(String teamId, Integer coachId) {

		Team team = teamRepository.findById(teamId)
			.orElseThrow(() -> new RuntimeException("TEAM_NOT_FOUND"));

		Coach coach = coachRepository.findById(coachId)
			.orElseThrow(() -> new RuntimeException("COACH_NOT_FOUND"));

		if (team.getTrainedBy().contains(coach)) {
			throw new RuntimeException("COACH_ALREADY_ASSIGNED");
		}

		if (team.getTrainedBy().size() >= 2) {
			throw new RuntimeException("MAX_COACHES_PER_TEAM_REACHED");
		}

		if (coach.getTeams().size() >= 2) {
			throw new RuntimeException("MAX_TEAMS_PER_COACH_REACHED");
		}

		team.addCoach(coach);

		teamRepository.save(team);

		return new AssignCoachResponse(teamId, coachId, "ASSIGNED");
	}
}