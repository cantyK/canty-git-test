import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Controller
public class HelloController {
    @RequestMapping("index")
    public String hello(){
        return "index";
    }
}
