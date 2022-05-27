package com.example.springweb.Reponsitory;

import com.example.springweb.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    public List<RoleEntity>findAllByName(String name);
}
