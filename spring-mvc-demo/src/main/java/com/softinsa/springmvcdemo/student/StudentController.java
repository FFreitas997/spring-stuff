package com.softinsa.springmvcdemo.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student/student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {
        System.out.println("First Name: " + student.getFirstName());
        System.out.println("Last Name: " + student.getLastName());
        System.out.println("Country: " + student.getCountry());
        System.out.println("Favourite Programming Language: " + student.getFavoriteProgrammingLanguage());
        System.out.println("Operating Systems: " + student.getOperatingSystems().toString());
        return "student/student-confirmation";
    }
}
