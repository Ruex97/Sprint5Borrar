package cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.dto;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@Data
public class BranchOfficeDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String country;
    private String typeBranch;


    private static final List<String> UECOUNTRIES = new ArrayList<>(Arrays.asList("Alemania","Austria","Bélgica",
            "Bulgaria","Chipre","Croacia", "Dinamarca", "España", "Eslovaquia", "Eslovenia", "Estonia",
            "Finlandia","Francia", "Grecia", "Hungría", "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo",
            "Malta", "Países Bajo", "Polonia", "Portugal", "República Checa", "Rumania", "Suecia"));

    public BranchOfficeDTO(String name, String country, String typeBranch) {
        this.name = name;
        this.country = country;
        this.typeBranch = checkCountry(typeBranch);

    }

    public String checkCountry(String typeBranch) {
        String type = "Outside UE";

        if (UECOUNTRIES.contains(typeBranch)) {
            type = "UE";
        }
        return type;

    }

}





