package by.it.academy.Mk_JD2_88_22.model.airpotsDB;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;

import java.time.ZonedDateTime;

public class Flight {
    @JsonProperty("Идентификатор рейса")
    private int flightId;

    @JsonProperty("Номер рейса")
    private String flightNum;

    @JsonProperty("Время вылета по расписанию")
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ssX")
    private ZonedDateTime timeScheduleDepart;

    @JsonProperty("Время прилёта по расписанию")
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ssX")
    private ZonedDateTime timeScheduleArrival;

    @JsonProperty("Аэропорт вылета")
    private String codeAirDepart;

    @JsonProperty("Аэропорт прилета")
    private String codeAirArrival;

    @JsonProperty("Статус рейса")
    private String status;

    @JsonProperty("Код самолета")
    private String aircraftCode;

    @JsonProperty("Фактическое время вылета")
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ssX")
    private ZonedDateTime timeActualDepart;

    @JsonProperty("Фактическое время прилета")
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ssX")
    private ZonedDateTime timeActualArrival;

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public ZonedDateTime getTimeScheduleDepart() {
        return timeScheduleDepart;
    }

    public void setTimeScheduleDepart(ZonedDateTime timeScheduleDepart) {
        this.timeScheduleDepart = timeScheduleDepart;
    }

    public ZonedDateTime getTimeScheduleArrival() {
        return timeScheduleArrival;
    }

    public void setTimeScheduleArrival(ZonedDateTime timeScheduleArrival) {
        this.timeScheduleArrival = timeScheduleArrival;
    }

    public String getCodeAirDepart() {
        return codeAirDepart;
    }

    public void setCodeAirDepart(String codeAirDepart) {
        this.codeAirDepart = codeAirDepart;
    }

    public String getCodeAirArrival() {
        return codeAirArrival;
    }

    public void setCodeAirArrival(String codeAirArrival) {
        this.codeAirArrival = codeAirArrival;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public ZonedDateTime getTimeActualDepart() {
        return timeActualDepart;
    }

    public void setTimeActualDepart(ZonedDateTime timeActualDepart) {
        this.timeActualDepart = timeActualDepart;
    }

    public ZonedDateTime getTimeActualArrival() {
        return timeActualArrival;
    }

    public void setTimeActualArrival(ZonedDateTime timeActualArrival) {
        this.timeActualArrival = timeActualArrival;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", flightNum='" + flightNum + '\'' +
                ", timeDepart=" + timeScheduleDepart +
                ", timeArrival=" + timeScheduleArrival +
                ", codeAirDepart='" + codeAirDepart + '\'' +
                ", codeAirArrival='" + codeAirArrival + '\'' +
                ", status='" + status + '\'' +
                ", aircraftCode='" + aircraftCode + '\'' +
                ", actualDepart='" + timeActualDepart + '\'' +
                ", actualArrival='" + timeActualArrival + '\'' +
                '}';
    }
}
