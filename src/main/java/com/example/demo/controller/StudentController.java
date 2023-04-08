package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    private final StudentService service;

   @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/student")
    // holder method for our our list

    public ModelAndView listOfStudent(){
       ModelAndView mav = new ModelAndView("index");

       mav.addObject("students", service.getAllStudent());
       return mav;

    }
    @GetMapping("/student/new")
    public ModelAndView createNewStudentForm(){
       ModelAndView modelAndView = new ModelAndView("newStudent");
      Student student = new Student();
       modelAndView.addObject("newStudent", student);
       return modelAndView;
    }

    @PostMapping("/student/save")
   public String showNewStudent( @ModelAttribute("newStudent") Student student){
       if(student==null){
           return "newStudent";
       }

       service.saveStudent(student);
       return  "redirect:/";

    }


@GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id,  Model  model){
           model.addAttribute("student", service.getStudentById(id));
           return "edit";

   }

   @PostMapping("/edit/{id}")
    public String updateForm(@PathVariable("id") Long id, Student student , Model model){
              model.addAttribute("student ", service.updateStudent(student, id));
              return "redirect:/student";
   }

   @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable("id")Long id, Student student , Model model){
       service.deleteStudent(id);
       return "redirect:/student";
   }

}
