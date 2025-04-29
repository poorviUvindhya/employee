package edu.icet.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private Integer id;

    @NotBlank(message = "name id required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only alphabetic characters and spaces")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Department is required")
    @Pattern(regexp = "^(HR|IT|Finance|Operations)$", message = "Department must be HR, IT, Finance, or Operations")
    private String department;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
