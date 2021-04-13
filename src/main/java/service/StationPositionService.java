package service;

import external.client.StationPositionClient;
import external.dao.StationPositionDao;
import external.dto.StationPositionDto;

import java.time.Duration;
import java.time.LocalDateTime;

public class StationPositionService {
    final static double EARTH_RADIUS = 6378100;

    StationPositionDto stationPositionDto = new StationPositionDto();
    StationPositionDao stationPositionDao = new StationPositionDao();
    StationPositionClient stationPositionClient = new StationPositionClient();

    public StationPositionDto getCurrentPosition() {

        stationPositionDto = stationPositionClient.getCurrentPosition();
        stationPositionDto.getIss_position().setTime(LocalDateTime.now());
        stationPositionDao.save(stationPositionDto.getIss_position());
        return stationPositionDto;
    }

    public double getStationSpeed() {
        stationPositionDto = stationPositionClient.getCurrentPosition();
        double lat1 = stationPositionDto.getIss_position().getLatitude();
        double lon1 = stationPositionDto.getIss_position().getLongitude();
        LocalDateTime timestampOfFirstPositionCheck = stationPositionDto.getIss_position().getTime();
//waiting suggested time amount (advised by open-notify-API documentation)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stationPositionDto = stationPositionClient.getCurrentPosition();
        double lat2 = stationPositionDto.getIss_position().getLatitude();
        double lon2 = stationPositionDto.getIss_position().getLongitude();
        LocalDateTime timestampOfSecondPositionCheck = stationPositionDto.getIss_position().getTime();
        Duration duration = Duration.between(timestampOfFirstPositionCheck, timestampOfSecondPositionCheck);
        try {
            return calculateDistanceBetweenTwoPoints(lat1, lon1, lat2, lon2) / duration.getSeconds();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    public double calculateDistanceBetweenTwoPoints(double lat1, double lon1, double lat2, double lon2) {
// Convert degrees to radians
        if (lat1 > 90 || lat1 < -90) {
            throw new IllegalArgumentException("Incorrect value for first lattitude");
        }
        if (lat2 > 90 || lat2 < -90) {
            throw new IllegalArgumentException("Incorrect value for second lattitude");
        }
        if (lon1 > 180 || lon1 < -180) {
            throw new IllegalArgumentException("Incorrect value for first longitude");
        }
        if (lon2 > 180 || lon2 < -180) {
            throw new IllegalArgumentException("Incorrect value for second longitude");
        }
        lat1 = lat1 * Math.PI / 180.0;
        lon1 = lon1 * Math.PI / 180.0;

        lat2 = lat2 * Math.PI / 180.0;
        lon2 = lon2 * Math.PI / 180.0;

        // radius of earth in metres

        // P
        double rho1 = EARTH_RADIUS * Math.cos(lat1);
        double z1 = EARTH_RADIUS * Math.sin(lat1);
        double x1 = rho1 * Math.cos(lon1);
        double y1 = rho1 * Math.sin(lon1);

        // Q
        double rho2 = EARTH_RADIUS * Math.cos(lat2);
        double z2 = EARTH_RADIUS * Math.sin(lat2);
        double x2 = rho2 * Math.cos(lon2);
        double y2 = rho2 * Math.sin(lon2);

        // Dot product
        double dot = (x1 * x2 + y1 * y2 + z1 * z2);
        double cos_theta = dot / (EARTH_RADIUS * EARTH_RADIUS);

        double theta = Math.acos(cos_theta);

        // Distance in Metres
        return EARTH_RADIUS * theta;
    }
}
