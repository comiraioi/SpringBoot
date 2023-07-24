package com.example.Project.service;

import com.example.Project.entity.Lecture;
import com.example.Project.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {
    @Autowired
    private final LectureRepository lectureRepository;
    public List<Lecture> findByOrderByLecnoDesc() {
        return lectureRepository.findByOrderByLecnoDesc();
    }

    public void saveLecture(Lecture lecture) {
        lectureRepository.save(lecture);
    }

    public void deleteByLecno(int lecno){
        lectureRepository.deleteById(lecno);
    }

    public Lecture findByLecno(int lecno){
        Lecture lecture = lectureRepository.findById(lecno).orElseThrow();
        return lecture;
    }
}
