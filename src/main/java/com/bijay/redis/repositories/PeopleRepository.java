package com.bijay.redis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bijay.redis.models.People;

@Repository
public interface PeopleRepository extends JpaRepository<People,Long>{

}
