package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**/
@Controller


public class HelloController {

    //Handles request at path = hello
   /* @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return " Hello, Spring!";
    }*/

    //Handles request at path = goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return " Goodbye, Spring!";
    }

    //Handles request of the form  /hello/name=LaunchCode

    @RequestMapping( method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam  String name, Model model){
        String greeting ="Hello, "+ name +"!";
        model.addAttribute("greeting",greeting);
        return "hello";
    }

    //Handles request of the form  /hello/LaunchCode

    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        model.addAttribute("greeting","Hello, "+ name +"!");
        return "hello";
    }

    @GetMapping("form")
    public String helloForm(){

        return "form";
    }

    //@GetMapping("hello/{name}/{language}")
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello/{name}/{language}")
    @ResponseBody
    public String createMessage( String name, String language){
        String greetMe ="";
        if(language.equals("French")){
            greetMe = "Bonjour";
        } else if (language.equals("English")) {
            greetMe = "Hello";
        } else if (language.equals("Spanish")) {
            greetMe = "Hola";
        } else if (language.equals("Italian")) {
            greetMe = "Ciao";
        } else if (language.equals("Japanese")) {
            greetMe = "Kon'nichiwa";
        }
        return greetMe +" "+ name+"!"  ;
    }

    @GetMapping("greet")
    @ResponseBody
    public String helloFormOptions(){
        return "<html>"+
                "<body>"+
                "<form action='hello/name/language'>"+ // submit a request to //hello
                "<input type='text' name='name' method='post'>" +
                "<select name='language'>" +
                "   <option value='English'>English</option >" +
                "   <option value='French'>French</option >" +
                "   <option value='Spanish'>Spanish</option >" +
                "   <option value='Italian'>Italian</option >" +
                "   <option value='Japanese'>Japanese</option >" +
                "</select >" +
                "<input type='submit' value= 'Greet me!'>" +
                "</form>" +
                "</body>" +
                "<html>";
    }

    //handles hello-list.html
    @GetMapping("hello-names")
    public String helloName(Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        names.add("Python");

        model.addAttribute("names", names);

        return ("hello-list");
    }
}
