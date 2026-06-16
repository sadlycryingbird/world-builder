package com.my.worldbuilder.world;

import com.my.worldbuilder.world.dto.WorldRequest;
import com.my.worldbuilder.world.dto.WorldResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorldService {

    private final WorldRepository worldRepository;
    private final WorldMapper worldMapper;

    public WorldResponse createWorld(WorldRequest request) {
        World worldEntity = worldMapper.toEntity(request);
        World saved = worldRepository.save(worldEntity);
        return worldMapper.toResponse(saved);
    }

    public List<WorldResponse> getAllWorlds() {
        return worldRepository.findAll()
                .stream()
                .map(worldMapper::toResponse)
                .toList();
    }

    public WorldResponse getWorldById(UUID id) {
        World world = worldRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("World not found"));
        return worldMapper.toResponse(world);
    }

    public void deleteWorld(UUID id) {
        worldRepository.deleteById(id);
    }
}