package com.example.Project.repository;

import com.example.Project.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture,Integer> {
    List<Lecture> findByOrderByLecnoDesc();
    Lecture findByLecno(int lecno);
}
