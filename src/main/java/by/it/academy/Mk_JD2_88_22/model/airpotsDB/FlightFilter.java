package by.it.academy.Mk_JD2_88_22.model.airpotsDB;

import java.time.ZonedDateTime;

public class FlightFilter {
    private int flightId;
    private String flightNum;
    private ZonedDateTime timeScheduleDepart;
    private ZonedDateTime timeScheduleArrival;
    private String codeAirDepart;
    private String codeAirArrival;
    private String status;
    private String aircraftCode;
    private ZonedDateTime timeActualDepart;
    private ZonedDateTime timeActualArrival;

    public int getFlightId() {
        return flightId;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public ZonedDateTime getTimeScheduleDepart() {
        return timeScheduleDepart;
    }

    public ZonedDateTime getTimeScheduleArrival() {
        return timeScheduleArrival;
    }

    public String getCodeAirDepart() {
        return codeAirDepart;
    }

    public String getCodeAirArrival() {
        return codeAirArrival;
    }

    public String getStatus() {
        return status;
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public ZonedDateTime getTimeActualDepart() {
        return timeActualDepart;
    }

    public ZonedDateTime getTimeActualArrival() {
        return timeActualArrival;
    }

    public static class Builder {
        private FlightFilter newFlightFilter;

        public Builder() {
            newFlightFilter = new FlightFilter();
        }

        public Builder setFlightId(int flightId) {
            newFlightFilter.flightId = flightId;
            return this;
        }

        public Builder setFlightNum(String flightNum) {
            newFlightFilter.flightNum = flightNum;
            return this;
        }

        public Builder setTimeScheduleDepart(ZonedDateTime timeScheduleDepart) {
            newFlightFilter.timeScheduleDepart = timeScheduleDepart;
            return this;
        }

        public Builder setTimeScheduleArrival(ZonedDateTime timeScheduleArrival) {
            newFlightFilter.timeScheduleArrival = timeScheduleArrival;
            return this;
        }

        public Builder setCodeAirDepart(String codeAirDepart) {
            newFlightFilter.codeAirDepart = codeAirDepart;
            return this;
        }

        public Builder setCodeAirArrival(String codeAirArrival) {
            newFlightFilter.codeAirArrival = codeAirArrival;
            return this;
        }

        public Builder setStatus(String status) {
            newFlightFilter.status = status;
            return this;
        }

        public Builder setAircraftCode(String aircraftCode) {
            newFlightFilter.aircraftCode = aircraftCode;
            return this;
        }

        public Builder setTimeActualDepart(ZonedDateTime timeActualDepart) {
            newFlightFilter.timeActualDepart = timeActualDepart;
            return this;
        }

        public Builder setTimeActualArrival(ZonedDateTime timeActualArrival) {
            newFlightFilter.timeActualArrival = timeActualArrival;
            return this;
        }

        public FlightFilter build() {
            return newFlightFilter;
        }
    }
}
