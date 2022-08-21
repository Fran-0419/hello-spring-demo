package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**/
@Controller
@ResponseBody

public class HelloController {

    //Handles request at path = hello
   /* @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return " Hello, Spring!";
    }*/

    //Handles request at path = goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return " Goodbye, Spring!";
    }

    //Handles request of the form  /hello/name=LaunchCode

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam  String name){
        return "Hello, " +name +"!";
    }

    //Handles request of the form  /hello/LaunchCode

    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " +name +"!";
    }

    @GetMapping("form")
    public String helloForm(){
        return "<html>"+
                "<body>"+
                "<form action='hello'>"+ // submit a request to //hello
                "<input type='text' name='name' method='post'>" +
                "<input type='submit' value= 'Greet me!'>" +
                "</form>" +
                "</body>" +
                "<html>";
    }
}
