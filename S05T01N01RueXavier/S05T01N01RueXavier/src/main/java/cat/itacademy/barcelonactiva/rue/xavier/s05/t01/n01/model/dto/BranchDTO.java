package cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Data
public class BranchDTO {

    private long id;
    private String name;
    private String country;
    private String typeBranch;


    private static final List<String> UECOUNTRIES = new ArrayList<>(Arrays.asList("Alemania","Austria","Bélgica",
            "Bulgaria","Chipre","Croacia", "Dinamarca", "España", "Eslovaquia", "Eslovenia", "Estonia",
            "Finlandia","Francia", "Grecia", "Hungría", "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo",
            "Malta", "Países Bajos", "Polonia", "Portugal", "República Checa", "Rumania", "Suecia"));

    public BranchDTO(String name, String country) {
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





