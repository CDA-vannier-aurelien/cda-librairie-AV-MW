package fr.cda.librairie.entity;

import lombok.AllArgsConstructor;
<<<<<<< HEAD
import lombok.Builder;
=======
>>>>>>> Dev
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
<<<<<<< HEAD
@Builder
=======
>>>>>>> Dev
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role;
}
