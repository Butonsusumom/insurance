package com.tsybulko.insurance.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Integer id;

    @NotBlank(message = "{valid.name.notNull}")
    @Size(min = 2, message = "{valid.firstname.size.min2}")
    private String firstName;

    @NotBlank(message = "{valid.name.notNull}")
    @Size(min = 3, message = "{valid.firstname.size.min3}")
    private String lastName;

    @NotNull(message = "{valid.date.notNull}")
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
   // @Past(message = "{valid.birthday.past}")
    private Date dateOfBirth;

    @NotBlank(message = "{valid.document.notBlank}")
    private String idDocument;

    @NotBlank(message = "{valid.address.notBlank}")
    private String address;

    @NotBlank(message = "{valid.phone.notBlank}")
    @Pattern(regexp="\\d{12}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}",message = "{valid.phone.cellphone}")
    private String phone;
}