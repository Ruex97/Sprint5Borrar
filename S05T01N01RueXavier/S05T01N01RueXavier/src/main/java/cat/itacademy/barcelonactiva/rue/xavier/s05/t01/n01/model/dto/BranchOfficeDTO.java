package cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.dto;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class BranchOfficeDTO {

    private long id;
    private String name;
    private String country;
    private String typeBranch;


    private static final List<String> UECOUNTRIES = new ArrayList<>(Arrays.asList("Alemania","Austria","Bélgica",
            "Bulgaria","Chipre","Croacia", "Dinamarca", "España", "Eslovaquia", "Eslovenia", "Estonia",
            "Finlandia","Francia", "Grecia", "Hungría", "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo",
            "Malta", "Países Bajos", "Polonia", "Portugal", "República Checa", "Rumania", "Suecia"));

    public BranchOfficeDTO(String name, String country) {
        this.name = name;
        this.country = country;
        this.typeBranch = checkCountry();

    }

    public String checkCountry() {
        String type = "Outside UE";

        if (UECOUNTRIES.contains(country)) {
            type = "UE";
        }
        return type;

    }

}





