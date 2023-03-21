package cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.domain;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
@Data
@Entity //@Builder
@Table(name = "branches")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "branch_name", length = 50)
    private String name;

    @Column(name = "branch_country", length = 50)
    private String country;

    public Branch(String name, String country) {
        this.name = name;
        this.country = country;

    }

}
