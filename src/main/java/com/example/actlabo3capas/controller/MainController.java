package com.example.actlabo3capas.controller;

import com.example.actlabo3capas.domain.Student;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    private List<Student> students = new ArrayList<Student>();

    @GetMapping(path="/ejemplo1", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String ejemplo1(){
        return "Bienvenido\n" + "Programacion N-Capas";
    }

    @GetMapping("/ejemplo2")
    public @ResponseBody List<Student> ejemplo2(){
        return Arrays.asList(
                new Student("Nombre 1","Apellido","10/10/1992","Carrera X",true),
                new Student("Nombre 2","Apellido","10/10/1992","Ingenieria de Limones",false)
        );
    }

    @GetMapping("/inicio")
    public String inicio(Student student){
        return "index";
    }

    @PostMapping("/formData")
    public ModelAndView procesar(Student student){
        students.add(student);

        ModelAndView mod = new ModelAndView();
        mod.setViewName("index");
        mod.addObject("student", new Student());

        return mod;
    }

    @GetMapping("/listado")
    public ModelAndView listado(){
        ModelAndView mod = new ModelAndView();
        mod.setViewName("listado");
        mod.addObject("studentList", this.students);

        return mod;
    }

}
