package co.istad.springsecuritybasic.restcontrollers;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/articles")
public class ArticleRestController {
    @GetMapping
    public String getAllArticles() {
        return " Getting All articles from the database ! ";
    }
    @GetMapping("/read/{id}")
    public String readSingleArticle(@PathVariable int id) {
        return "Reading on article " + id;
    }
    @PostMapping("/write")
    public String createArticle() {
        return "Creating the new article ! ";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteArticle(@PathVariable int id) {
        return "Successfully delete the article with id = " + id;
    }

}
