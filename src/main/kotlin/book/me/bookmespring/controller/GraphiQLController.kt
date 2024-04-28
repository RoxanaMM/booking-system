package book.me.bookmespring.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class GraphiQLController {

    @GetMapping("/graphiql")
    fun graphiql(): String {
        return "forward:/graphiql/index.html"
    }
}
