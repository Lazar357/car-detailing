package rs.ac.signidunum.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
public class BookingRequest {
    @NotBlank(message = "Izaberite tip servisa")
    private String service;

    @NotNull(message = "Izaberite datum rezervacije")
    @FutureOrPresent
    private LocalDate date;

    @NotNull(message = "Izaberite vreme rezervacije")
    private LocalTime time;

    @Valid
    @NotNull(message = "Unesite podatke korisnika")
    private CustomerDTO customer;

    @NotBlank(message = "Unesite vase vozilo")
    private String vehicle;

}