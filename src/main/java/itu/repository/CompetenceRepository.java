package itu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import itu.model.Competence;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {
}
