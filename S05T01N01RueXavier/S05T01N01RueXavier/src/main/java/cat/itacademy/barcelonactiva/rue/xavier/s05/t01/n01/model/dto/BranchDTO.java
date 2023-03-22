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


    private static final List<String> UECOUNTRIES = new ArrayList<>(Arrays.asList("alemania", "austria", "bélgica",
            "bulgaria", "chipre", "croacia", "dinamarca", "españa", "eslovaquia", "eslovenia", "estonia", "finlandia",
            "francia", "grecia", "hungría", "irlanda", "italia", "letonia", "lituania", "luxemburgo", "malta",
            "países bajos", "polonia", "portugal", "república checa", "rumania", "suecia"));

    public BranchDTO(String name, String country) {
        this.name = name;
        this.country = country;
        this.typeBranch = checkCountry();

    }

    public String checkCountry() {
        String type = "Outside UE";

        if (UECOUNTRIES.contains(country.toLowerCase())) {
            type = "UE";
        }
        return type;

    }

}





