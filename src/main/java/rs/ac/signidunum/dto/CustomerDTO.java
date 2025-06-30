package rs.ac.signidunum.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    @NotBlank(message = "Unesite ime i prezime")
    private String name;

    @NotBlank(message = "Unesite broj telefona")
    private String phone;

    @Email(message = "Email nije validan")
    private String email;

}
