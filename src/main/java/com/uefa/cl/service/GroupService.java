package com.uefa.cl.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uefa.cl.dao.GroupDao;
import com.uefa.cl.entity.Group;
import com.uefa.cl.entity.Pot;
import com.uefa.cl.entity.Team;
import com.uefa.cl.framework.abstracts.AbstractService;


@Service
public class GroupService extends AbstractService<Group> {
	
	@Autowired private PotService potService;
	@Autowired private TeamService teamService;
	
	@Autowired private GroupDao dao;

	public Group findByGroupName(String name) {
		return dao.findByName(name);
	}

	public List<Group> distributionPotName(String potName) throws Exception {
		Pot pot = potService.findByPotName(potName);
		if (pot == null) {
			throw new Exception(potName + " isimli torba bulunamadı!");
		}

		for (Team team : pot.getTeams()) {
			Random r = new Random();
			// TODO: max 8 takim var
			int low = 1;
			int high = 8;
			int result = r.nextInt(high - low) + low;
			System.out.println("result " + result);
			Group group = dao.findByName("Group " + result);
			if (group == null) {
				throw new Exception("Group " + result + " isimli torba bulunamadı!");
			}

			// aynı gruptan takim var mi?
//			Team matchingTeam = group.getTeams().stream()
//					.filter(f -> f.getPot().getName().equals(team.getPot().getName())).findFirst().orElse(null);
//			if (matchingTeam != null) {
//				result = r.nextInt(high - low) + low;
//				group = dao.findByName("Group " + result);
//				matchingTeam = group.getTeams().stream()
//						.filter(f -> f.getPot().getName().equals(team.getPot().getName())).findFirst().orElse(null);
//			} else {
//				team.setGroup(group);
//				teamService.save(team);
//			}

		}
		return dao.findAll();
	}

}
