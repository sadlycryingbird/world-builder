package com.my.worldbuilder.world;

import com.my.worldbuilder.world.dto.WorldRequest;
import com.my.worldbuilder.world.dto.WorldResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/worlds")
@RequiredArgsConstructor
public class WorldController {
    private final WorldService worldService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorldResponse createWorld(@RequestBody WorldRequest request) {
        return worldService.createWorld(request);
    }

    @GetMapping
    public List<WorldResponse> getAllWorlds() {
        return worldService.getAllWorlds();
    }

    @GetMapping("/{id}")
    public WorldResponse getWorldById(@PathVariable UUID id) {
        return worldService.getWorldById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWorld(@PathVariable UUID id) {
        worldService.deleteWorld(id);
    }
}
