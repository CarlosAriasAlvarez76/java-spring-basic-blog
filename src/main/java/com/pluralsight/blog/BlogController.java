package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {

    @RequestMapping("/")
    public String listPosts(ModelMap modelMap){
        List<Post> postList = this.postRepository.getAllPosts();
        modelMap.put("posts", postList);
        //modelMap.put("title", "Blog Post 1");
        return "home";
    }

    private PostRepository postRepository;

    public BlogController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping("/post/{id}")
    public String postDetails(@PathVariable Long id, ModelMap modelMap){
        Post post = postRepository.findById(id);
        modelMap.put("post", post);
        return "post-details";
    }
}
