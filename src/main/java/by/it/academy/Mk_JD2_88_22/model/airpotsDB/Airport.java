package by.it.academy.Mk_JD2_88_22.model.airpotsDB;

public class Airport {
    private String airportCode;
    private NameLang airportName;
    private NameLang city;
    private Point coordinates;
    private String timezone;

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public NameLang getAirportName() {
        return airportName;
    }

    public void setAirportName(NameLang airportName) {
        this.airportName = airportName;
    }

    public NameLang getCity() {
        return city;
    }

    public void setCity(NameLang city) {
        this.city = city;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "airportCode='" + airportCode + '\'' +
                ", airportName=" + airportName +
                ", city=" + city +
                ", coordinates=" + coordinates +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}
