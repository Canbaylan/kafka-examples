package com.canbaylan.springboot.repository;

import com.canbaylan.springboot.entity.Wikimedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepository extends JpaRepository<Wikimedia,Long> {
}
