package com.dogmax.bookshelf.repository;

import com.dogmax.bookshelf.model.Format;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormatRepository extends JpaRepository<Format, Long> {
}
