package external.utility;

public class StationPositionNotFoundException extends RuntimeException {
    public StationPositionNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public StationPositionNotFoundException() {
    }
}
