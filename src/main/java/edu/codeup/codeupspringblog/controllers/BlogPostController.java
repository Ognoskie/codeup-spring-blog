package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.repositories.BlogPostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/post")
public class BlogPostController {

	private BlogPostRepository blogPostDao;

	public BlogPostController(BlogPostRepository blogPostDao) {
		this.blogPostDao = blogPostDao;
	}

	@GetMapping("")
	@ResponseBody
	public String indexPage() {
		return "post index page";
	}

	@GetMapping("/{id}")
	@ResponseBody
	public String indexPage(@PathVariable long id) {
		return "view an individual post";
	}

	@GetMapping("/create")
	@ResponseBody
	public String showCreatePostView() {
		return "view the form for creating a post";
	}

	@PostMapping("/create")
	@ResponseBody
	public String createPost() {
		return "Create a new post";
	}
}
