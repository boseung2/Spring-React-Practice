package org.zerock.springreactpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.springreactpractice.entity.MovieImage;

public interface MovieImageRepository extends JpaRepository<MovieImage, Long> {
}
