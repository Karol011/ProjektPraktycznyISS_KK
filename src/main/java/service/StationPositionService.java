package service;

import external.client.StationPositionClient;
import external.dao.StationPositionDao;
import external.dto.StationPositionDto;
import external.entity.StationPosition;

import java.time.LocalDateTime;

public class StationPositionService {

    StationPositionDto stationPositionDto = new StationPositionDto();
    StationPositionDao stationPositionDao = new StationPositionDao();
    StationPositionClient stationPositionClient = new StationPositionClient();

    public StationPositionDto getCurrentPosition() {
        stationPositionDto = stationPositionClient.getCurrentPosition();
        stationPositionDto.getIss_position().setTime(LocalDateTime.now());
        stationPositionDao.save(stationPositionDto.getIss_position());
        return stationPositionDto;
    }
}
