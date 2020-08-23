package fr.cda.librairie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommandeLineDto {
    private String nomLivre;
    private int quantiteCommandee;
    private double prixLivre;
}
