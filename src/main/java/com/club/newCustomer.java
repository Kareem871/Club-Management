package com.club;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="clubname", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class newCustomer {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Size(min = 2, max= 100, message = "Please add a name with at least 2 characters")
    private String name;

    @Pattern(regexp = "^05[0-9]{8}|", message = "Please add a number starts with 05")
    private String mobileno;

    @Digits(integer = 4, fraction = 0, message = "Please add the money with no more than 4 numbers")
    @NotNull(message = "Please insert a value")
    @Min(message = "The money must be at least 1", value = 1)
    private int money;

    @NotNull(message = "Please enter a valid date dd/mm/yyyy")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate date;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate expiry;

    @Column(columnDefinition = "Boolean NOT NULL Default '1'")
    private Boolean type = false;

//    @Min(message = "At least 1", value = 1)
    @Max(message = "No more than 12", value = 12)
    private int period;

    @Column(columnDefinition = "Boolean NOT NULL Default '1'")
    private Boolean active = true;

    private Date createdAt;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
