package service;

import external.client.PeopleClient;
import external.client.PeopleDto;
import external.dao.PeopleDao;
import external.entity.People;

import java.util.Set;

public class PeopleService {

    private PeopleDto peopleDto = new PeopleDto();
    private PeopleDao peopleDao = new PeopleDao();
    private PeopleClient peopleClient = new PeopleClient();

    public Set<People> getCurrentPeopleInSpace() {
        peopleDto = peopleClient.getCurrentPeopleInSpace();
        peopleDao.saveAll(peopleDto.getPeople());
        return peopleDao.findAll();
    }
}