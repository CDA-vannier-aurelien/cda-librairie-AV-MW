package fr.cda.librairie.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "CompteUtilisateur")

public class CompteUser {

	@Id
	private String login;

	private String password;

	@Column(name = "date_connection")

	private Date dateConnection;

	private boolean isActif;

}
