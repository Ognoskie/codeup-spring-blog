package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Ad;
import edu.codeup.codeupspringblog.models.BlogPost;
import edu.codeup.codeupspringblog.models.User;
import edu.codeup.codeupspringblog.repositories.BlogPostRepository;
import edu.codeup.codeupspringblog.repositories.UserRepository;
import edu.codeup.codeupspringblog.services.EmailSvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class BlogPostController {

	private BlogPostRepository blogPostDao;
	private UserRepository userDao;

	private EmailSvc emailSvc;

	public BlogPostController(BlogPostRepository blogPostDao, UserRepository userDao, EmailSvc emailSvc) {
		this.blogPostDao = blogPostDao;
		this.userDao = userDao;
		this.emailSvc = emailSvc;
	}

//    private List<BlogPost> blogPostsList =  new ArrayList<>(Arrays.asList(
//        new BlogPost("A Day in the Life", "Yadda yadda yadda yaa..."),
//        new BlogPost("Another Day in the Life", "Adda yadda yadda yadda yaa..."),
//        new BlogPost("Yet Another Day in the Life", "Wadda adda yadda yadda yadda yaa...")
//    ));

	@GetMapping
	public String indexPage(Model vModel) {
		vModel.addAttribute("blogposts", blogPostDao.findAll());
		return "blogposts/index";
	}

	@GetMapping("/{id}")
	public String viewIndividualPost(@PathVariable long id, Model vModel) {
		if(blogPostDao.existsById(id)) {
			BlogPost post = blogPostDao.findById(id).get();
			vModel.addAttribute("blogpost", post);
			return "blogposts/show";
		}
		return "redirect:/posts";
	}

	@GetMapping("/create")
	public String showCreatePostView(Model model) {
		model.addAttribute("post", new BlogPost());
		return "blogposts/create";
	}


	@PostMapping("/create")
	public String createPost(@ModelAttribute BlogPost post) {
		// Hard Coded user SaintSteve
		User hardCodedUser = userDao.findById(1L).get();
		BlogPost postToCreate = new BlogPost(
				post.getTitle(),
				post.getBody(),
				hardCodedUser
		);
		blogPostDao.save(postToCreate);
		emailSvc.prepareAndSend(postToCreate, "New Post", "You have created a new post!");
		return "redirect:/posts";
	}


	@GetMapping("/{id}/edit")
	public String editPost(@PathVariable long id, Model model){
		BlogPost postToEdit = blogPostDao.findById(id).get();
		model.addAttribute("post", postToEdit);
		return "blogposts/edit";
	}


	@PostMapping("/{id}/edit")
	public String insertBlogPost(@ModelAttribute BlogPost blogPost) {
		BlogPost postToEdit = blogPostDao.findById(blogPost.getId()).get();
		postToEdit.setTitle(blogPost.getTitle());
		postToEdit.setBody(blogPost.getBody());
		blogPostDao.save(blogPost);
		return "redirect:/posts";
	}

	@PostMapping("/{id}/edit")
	public String insertEdit(@ModelAttribute BlogPost post, @PathVariable long id){
		BlogPost postToEdit = blogPostDao.findById(id).get();
		postToEdit.setTitle(post.getTitle());
		postToEdit.setBody(post.getBody());
		blogPostDao.save(postToEdit);
		return "redirect:/posts/"+id;
	}

}
