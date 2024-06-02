package itu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import itu.model.Diplome;

public interface DiplomeRepository extends JpaRepository<Diplome, Long> {
}
