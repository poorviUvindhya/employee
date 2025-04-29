package edu.icet.dto;
import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private Integer id;
    private String name;
    private String email;
    private String department;
    private LocalDate craetedAt;
    private LocalDate updateAt;
}
