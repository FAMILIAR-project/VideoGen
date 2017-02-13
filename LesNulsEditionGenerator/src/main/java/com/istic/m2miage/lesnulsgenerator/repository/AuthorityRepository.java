package com.istic.m2miage.lesnulsgenerator.repository;

import com.istic.m2miage.lesnulsgenerator.domain.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
