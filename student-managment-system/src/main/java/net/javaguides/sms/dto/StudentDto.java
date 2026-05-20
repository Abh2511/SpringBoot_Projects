package net.javaguides.sms.dto;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StudentDto
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Student first Name should not be empty")
    private String firstName;
    @NotEmpty(message = "Student last name should not be empty")
    private String lastName;
    @NotEmpty(message = "Student email should not be empty")
    @Email
    private String email;

}
