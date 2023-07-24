package com.example.Project.entity;

import com.example.Project.bean.LectureBean;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Entity(name="lecture")
@Table(name="lecture")
@Setter
@Getter
@ToString
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int lecno;
    private String major;
    private String title;
    private String professor;
    private String content;
    private String grade;
    private String day;
    private String time;
    private int credit;
    private int limit;
    private int register;

    private static ModelMapper modelMapper = new ModelMapper();
    public static Lecture insertLecture(LectureBean lectureBean){
        Lecture lecture = modelMapper.map(lectureBean, Lecture.class);
        return lecture;
    }
}
