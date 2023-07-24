package com.example.Project.controller;

import com.example.Project.bean.LectureBean;
import com.example.Project.entity.Lecture;
import com.example.Project.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;

    @GetMapping(value = {"/", "lecture"})
    public String getLectureList(Model model){
        List<Lecture> lectureList = lectureService.findByOrderByLecnoDesc();
        model.addAttribute("lectureList",lectureList);
        return "lecture/select";
    }

    @GetMapping(value = "/lecture/insert")
    public String insertLecture(Model model){
        String[] major = {"경영","소프트웨어","아동","전자"};
        String[] day = {"월","화","수","목","금"};
        String[] time = {"09~12","12~15","15~18"};
        model.addAttribute("major",major);
        model.addAttribute("day",day);
        model.addAttribute("time",time);
        model.addAttribute("lectureBean", new LectureBean());
        return "lecture/insert";
    }

    @PostMapping(value = "/lecture/insert")
    public String insertDB(@Valid LectureBean lectureBean, BindingResult bindingResult, Model model){
        String result = "redirect:/";

        String[] major = {"경영","소프트웨어","아동","전자"};
        String[] day = {"월","화","수","목","금"};
        String[] time = {"09~12","12~15","15~18"};
        model.addAttribute("major",major);
        model.addAttribute("day",day);
        model.addAttribute("time",time);

        if(bindingResult.hasErrors()){
            model.addAttribute("lectureBean",lectureBean);
            return "lecture/insert";
        }

        Lecture lecture = Lecture.insertLecture(lectureBean);
        lectureService.saveLecture(lecture);

        return result;
    }

    @GetMapping(value = "/lecture/detail")
    public String detailBook(Model model, @RequestParam("lecno") int lecno){
        Lecture lecture = lectureService.findByLecno(lecno);
        model.addAttribute("lecture",lecture);
        return "lecture/detail";
    }

    @GetMapping(value = "lecture/update")
    public String updateGet(@RequestParam("lecno") int lecno, Model model){
        System.out.println("lecno:"+lecno);
        Lecture lecture = lectureService.findByLecno(lecno);
        model.addAttribute("lectureBean",lecture);

        String[] major = {"경영","소프트웨어","아동","전자"};
        String[] day = {"월","화","수","목","금"};
        String[] time = {"09~12","12~15","15~18"};
        model.addAttribute("major",major);
        model.addAttribute("day",day);
        model.addAttribute("time",time);

        return "lecture/update";
    }

    @PostMapping(value="lecture/update")
    public String updatePost(@Valid LectureBean lectureBean, BindingResult bindingResult, Model model){

        String[] major = {"경영","소프트웨어","아동","전자"};
        String[] day = {"월","화","수","목","금"};
        String[] time = {"09~12","12~15","15~18"};
        model.addAttribute("major",major);
        model.addAttribute("day",day);
        model.addAttribute("time",time);

        if(bindingResult.hasErrors()){

            model.addAttribute("lectureBean",lectureBean);
            return "lecture/update";
        }

        Lecture lecture = Lecture.insertLecture(lectureBean);
        lectureService.saveLecture(lecture);

        return "redirect:/";
    }
    @GetMapping(value = "lecture/delete")
    public String delete(@RequestParam("lecno") int lecno){

        lectureService.deleteByLecno(lecno);

        return "redirect:/";
    }
    @PostMapping(value = "lecture/checkDelete")
    public String checkDelete(int[] row){
        for(int i=0; i<row.length; i++){
            lectureService.deleteByLecno(row[i]);
        }
        return "redirect:/";
    }
}
