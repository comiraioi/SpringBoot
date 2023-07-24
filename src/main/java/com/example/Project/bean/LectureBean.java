package com.example.Project.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
public class LectureBean {
    private int lecno;
    @NotEmpty(message = "전공을 선택하세요")
    private String major;
    @NotEmpty(message = "강의명을 입력하세요")
    private String title;
    @NotEmpty(message = "교수명을 입력하세요")
    private String professor;
    private String content;
    @NotEmpty(message = "대상 학년을 선택하세요")
    private String grade;
    @NotEmpty(message = "강의 요일을 선택하세요")
    private String day;
    @NotEmpty(message = "강의 시간을 선택하세요")
    private String time;
    @NotNull(message = "학점을 선택하세요")
    private Integer credit;
    @NotNull(message = "수강정원을 선택하세요")
    private Integer limit;
    private Integer register;
}
