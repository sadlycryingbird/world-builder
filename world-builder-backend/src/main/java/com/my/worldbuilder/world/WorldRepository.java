package com.my.worldbuilder.world;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorldRepository extends JpaRepository<World, UUID> {
}