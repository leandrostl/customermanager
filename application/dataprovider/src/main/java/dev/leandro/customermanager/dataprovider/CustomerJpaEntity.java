package dev.leandro.customermanager.dataprovider;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer", uniqueConstraints = @UniqueConstraint(columnNames = {"document"}))
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CustomerJpaEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Setter
    private String firstName;
    @Setter
    private String lastName;
    @Setter
    private String document;
    @Setter
    private String documentType;
}
