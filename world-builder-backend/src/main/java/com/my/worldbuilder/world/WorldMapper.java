package com.my.worldbuilder.world;

import com.my.worldbuilder.world.dto.WorldRequest;
import com.my.worldbuilder.world.dto.WorldResponse;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface WorldMapper {

    World toEntity(WorldRequest request);

    WorldResponse toResponse(World world);

}