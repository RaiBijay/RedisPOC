package com.bijay.redis.services;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.bijay.redis.dtos.PeopleDTO;
import com.bijay.redis.mappers.PeopleMapper;
import com.bijay.redis.models.People;
import com.bijay.redis.repositories.PeopleRepository;

@Service
public class PeopleService {

	@Autowired
	PeopleRepository peopleRepository;

	private PeopleMapper peopleMapper = Mappers.getMapper(PeopleMapper.class);

	@Cacheable(cacheNames = "findAllCache")
	public List<PeopleDTO> findAll() {
		return peopleMapper.peopleListToPeopleDTOList(peopleRepository.findAll());
	}

	@Caching(evict = { @CacheEvict(value = "findAllCache", allEntries = true),
			@CacheEvict(value = "findById", allEntries = true) })
	public PeopleDTO savePeople(PeopleDTO peopleDTO) {
		if (peopleDTO.getId() == null) {
			return peopleMapper.peopleToPeopleDTO(peopleRepository.save(peopleMapper.peopleDTOToPeople(peopleDTO)));
		} else {
			if (findById(peopleDTO.getId()) != null) {
				return peopleMapper.peopleToPeopleDTO(peopleRepository.save(peopleMapper.peopleDTOToPeople(peopleDTO)));
			} else {
				return null;
			}
		}
	}

	@Cacheable(cacheNames = "findByIdCache")
	public PeopleDTO findById(Long id) {
		Optional<People> findPeople = peopleRepository.findById(id);
		if (findPeople.isPresent()) {
			return peopleMapper.peopleToPeopleDTO(findPeople.get());
		} else {
			return null;
		}
	}

	@Autowired
	CacheManager cacheManager;

	public void flushCache() {
		for (String cacheName : cacheManager.getCacheNames()) {
			cacheManager.getCache(cacheName).clear();
		}
	}

}
