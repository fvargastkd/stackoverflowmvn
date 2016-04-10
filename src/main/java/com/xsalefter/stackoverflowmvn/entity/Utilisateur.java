package com.xsalefter.stackoverflowmvn.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 6650489676565371799L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdUtilisateur")
    public Long id;
    public String Nom;
    public String Prenom;
    public String Profil;
    public String Pseudo;
    public String Password;

    public Utilisateur() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getProfil() {
        return Profil;
    }

    public void setProfil(String profil) {
        Profil = profil;
    }

    public String getPseudo() {
        return Pseudo;
    }

    public void setPseudo(String pseudo) {
        Pseudo = pseudo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "Utilisateur [id=" + id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Profil=" + Profil + ", Pseudo="
                + Pseudo + ", Password=" + Password + "]";
    }

}
