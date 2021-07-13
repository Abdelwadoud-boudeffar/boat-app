package com.openwt.suisse.mapper;

import com.openwt.suisse.dao.model.Boat;
import com.openwt.suisse.dto.BoatDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BoatMapper {

    BoatMapper INSTANCE = Mappers.getMapper( BoatMapper.class );

    @Mapping(source = "boatName", target = "boatName")
    BoatDTO boatToBoatDTO(Boat boat);
}
