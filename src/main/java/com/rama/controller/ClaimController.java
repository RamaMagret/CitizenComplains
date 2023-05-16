package com.rama.controller;

import com.rama.model.claims;
import com.rama.services.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;

@Controller
public class ClaimController {

    @Autowired
    ClaimService claimService;


    @GetMapping("/home")
    public String homePage(Model model){
        model.addAttribute("home", claimService.getAllDesigns());
        return "home-page";
    }

    @GetMapping ("/search-page")
    public String searchMethod(Model model){
        claims student =new claims();
       model.addAttribute("search",student);
        return "index";
    }

    @PostMapping("/search_one")
    public String getEmployee(@ModelAttribute("search") claims student, Model model){
        model.addAttribute("search", claimService.findDesign(student.getOrderId()));
        return "searching";
    }


    @GetMapping("/employee_page")
    public String getEmployee(Model model){
        claims stud = new claims();
        model.addAttribute("student",stud);
        return "employee";
    }

    @GetMapping("/registration")
    public String registerStudentPage(Model model){
        claims stud = new claims();
        model.addAttribute("student", stud);
        return "registration-page";
    }
    @GetMapping("/search")
    public String searchOrder(Model model){
        model.addAttribute("search",new claims());
        return "findOne";
    }

    @PostMapping("/findOrder")
    public String getOrder(@ModelAttribute("search") claims claims, Model model){
        claims claims1 = claimService.findDesign(claims.getOrderId());
        if (claims1 !=null){
            model.addAttribute("search", claims1);
            return "findOne";
        }else {
            model.addAttribute("error","order wa not found");
            return "findOne";
        }

    }


    @PostMapping("/emp")
    public String registerEmp(@ModelAttribute("student") claims theStudent) throws ParseException {

        claims savedStudent = claimService.saveDesign(theStudent);
        if(savedStudent != null){
            return "redirect:/employee_page?success";
        }
        return "redirect:/employee_page?error";
    }


    @PostMapping("/register")
    public String registerStudentInDb(@ModelAttribute("student") claims theStudent) throws ParseException {

        claims savedStudent = claimService.saveDesign(theStudent);
        if(savedStudent != null){
            return "registeration-page?success";
        }
        return "registeration-page?error";
    }

    @GetMapping("/home/edit/{studentID}")
    public String editStudent(@PathVariable String studentID, Model model){
        claims st=new claims();
     model.addAttribute("student", claimService.findDesign(studentID));
     return "edit-design";
    }

    @PostMapping("/home/{studentID}")
    public String updateStudent(@PathVariable String studentID, @ModelAttribute("student") claims claims, Model model){
        claims exitingDesign= claimService.findDesign(claims.getOrderId());
        exitingDesign.setOrderId(claims.getOrderId());
        exitingDesign.setfName(claims.getfName());
        exitingDesign.setlName(claims.getlName());
        exitingDesign.setYard(claims.getYard());
        exitingDesign.setOrderDate(claims.getOrderDate());
        exitingDesign.setComplains(claims.getComplains());
        claimService.updateDesign(exitingDesign);
        return "redirect:/home";
    }
    @GetMapping ("/home/{studentID}")
    public String detleteStudent(@PathVariable String studentID ){
   claimService.deleteDesign(studentID);
   return "redirect:/home";
    }

}
