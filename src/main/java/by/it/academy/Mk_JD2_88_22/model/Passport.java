package by.it.academy.Mk_JD2_88_22.model;

import com.fasterxml.jackson.annotation.*;

import java.time.LocalDate;
import java.util.Objects;

/**
 * 	1. ИД гражданина (idCitizen)
 * 	2. Кем выдан (address)
 * 	3. Дата выдачи (LocalDate)
 * 	4. ИД паспорта (id)
 */
public class Passport {
    private String id;

    @JsonProperty("id_citizen")
    private String idCitizen;

    private String address;

    @JsonProperty("create_date")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private LocalDate createDate;

    @JsonCreator
    public Passport(@JsonProperty("id") String id,
                    @JsonProperty("id_citizen") String idCitizen,
                    @JsonProperty("address") String address,
                    @JsonProperty("create_date") LocalDate createDate) {
        this.id = id;
        this.idCitizen = idCitizen;
        this.address = address;
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCitizen() {
        return idCitizen;
    }

    public void setIdCitizen(String idCitizen) {
        this.idCitizen = idCitizen;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(id, passport.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id='" + id + '\'' +
                ", idCitizen='" + idCitizen + '\'' +
                ", address='" + address + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
