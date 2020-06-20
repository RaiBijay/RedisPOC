package com.bijay.redis.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.bijay.redis.dtos.PeopleDTO;
import com.bijay.redis.models.People;

@Mapper
public interface PeopleMapper {
List<PeopleDTO> peopleListToPeopleDTOList(List<People> people);
PeopleDTO peopleToPeopleDTO(People people);
People peopleDTOToPeople(PeopleDTO peopleDTO);
}
