package cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.domain;

import jakarta.persistence.*;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "branches")
public class BranchOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "branch_name", length = 50)
    private String name;

    @Column(name = "branch_country", length = 50)
    private String country;

    public BranchOffice(String name, String country) {
        this.name = name;
        this.country = country;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return "BranchOffice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
