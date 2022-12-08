package HelloWorldAplication;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String sayHi() {
        return "Hello world";
    }

    @GetMapping("/{name}")
    public String sayHiToSomeOne(@PathVariable String name) {
        return "Hello " + name;
    }
}