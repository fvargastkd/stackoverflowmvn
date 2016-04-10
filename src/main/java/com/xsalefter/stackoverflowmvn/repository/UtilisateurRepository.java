package com.xsalefter.stackoverflowmvn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xsalefter.stackoverflowmvn.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
