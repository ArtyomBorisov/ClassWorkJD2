package by.it.academy.Mk_JD2_88_22.model.airpotsDB;

import java.time.LocalDate;

public class FlightFilter {
    private int flightId;
    private String flightNum;
    private LocalDate dayScheduleDepart;
    private LocalDate dayScheduleArrival;
    private String codeAirDepart;
    private String codeAirArrival;
    private String status;
    private String aircraftCode;
    private LocalDate dayActualDepart;
    private LocalDate dayActualArrival;

    public int getFlightId() {
        return flightId;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public LocalDate getDayScheduleDepart() {
        return dayScheduleDepart;
    }

    public LocalDate getDayScheduleArrival() {
        return dayScheduleArrival;
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

    public LocalDate getDayActualDepart() {
        return dayActualDepart;
    }

    public LocalDate getDayActualArrival() {
        return dayActualArrival;
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

        public Builder setDayScheduleDepart(LocalDate dayScheduleDepart) {
            newFlightFilter.dayScheduleDepart = dayScheduleDepart;
            return this;
        }

        public Builder setDayScheduleArrival(LocalDate dayScheduleArrival) {
            newFlightFilter.dayScheduleArrival = dayScheduleArrival;
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

        public Builder setDayActualDepart(LocalDate dayActualDepart) {
            newFlightFilter.dayActualDepart = dayActualDepart;
            return this;
        }

        public Builder setDayActualArrival(LocalDate dayActualArrival) {
            newFlightFilter.dayActualArrival = dayActualArrival;
            return this;
        }

        public FlightFilter build() {
            return newFlightFilter;
        }
    }
}
