package maxcmartinez.academic_structure.academicstructure.helloWorld;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

//    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
//    public HelloWorld helloWorld(){
//        return new HelloWorld("Hello World");
//    }
    //diferent references to anotation
    @GetMapping("/hello-world")
    public HelloWorld helloWorld(){
        return new HelloWorld("Hello World");
    }

    //with variable id:
    @GetMapping("/hello-world/{name}/other-name/{otherName}")
    public HelloWorld helloWorld(@PathVariable String name, @PathVariable String otherName){
        return new HelloWorld(String.format("Hello World %s %s", name, otherName));
    }
}
