package com.example.Project.bean;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UnivBean {
    private int userno;
    private String identity;
    @NotEmpty(message = "아이디를 입력하세요")
    private String userid;
    @NotEmpty(message = "비밀번호를 입력하세요")
    private String userpw;
    @NotEmpty(message = "이름을 입력하세요")
    private String username;
    @NotEmpty(message = "이메일을 입력하세요")
    private String email;
    @NotEmpty(message = "전공을 선택하세요")
    private String major;
    private Integer grade;
    private Integer credit;
}
