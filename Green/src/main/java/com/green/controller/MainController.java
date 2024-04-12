package com.green.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.green.VO.BoardVO;
import com.green.VO.ConditionValue;
import com.green.VO.PageVO;
import com.green.service.BoardService;

@Controller
@RequestMapping(value={"/", "/main"})
public class MainController {
	
	@Autowired
	BoardService service;
	
	@GetMapping("")
	public String goToMain(Model model) {
		
		model.addAttribute("vrList", service.getMainVrList());
		model.addAttribute("videoList", service.getMainVideoList());
		
		return "/main/mainpage";
	}
	
	@GetMapping("/signin")
	public String goToSignIn() {
		return "/main/signinpage";
	}
	
	@GetMapping("/signup")
	public String goToSignUp() {
		return "/main/signuppage";
	}
	
	@PostMapping("/signup")
	public String submitSignup() {
		
		return "";
	}
	
	@GetMapping("/vr")
	public String goToVr(Model model, ConditionValue cv) {
		
		long total = service.getVrCount();
		
		model.addAttribute("list", service.getVrList(cv));
		model.addAttribute("page", new PageVO(cv, total));
		
		return "/section/vr/vr";
	}
	
	@GetMapping("/vr_now")
	public String goToVrOne(Model model, ConditionValue cv) {
		
		long total = service.getVrCountOne();
		
		model.addAttribute("list", service.getVrListOne(cv));
		model.addAttribute("page", new PageVO(cv, total));
		
		return "/section/vr/vr_now";
	}
	
	@GetMapping("/vr_now+1")
	public String goToVrTwo(Model model, ConditionValue cv) {
		
		long total = service.getVrCountTwo();
		
		model.addAttribute("list", service.getVrListTwo(cv));
		model.addAttribute("page", new PageVO(cv, total));
		
		return "/section/vr/vr_now+1";
	}
	
	@GetMapping("/vr_now+2")
	public String goToVrThree(Model model, ConditionValue cv) {
		
		long total = service.getVrCountThree();
		
		model.addAttribute("list", service.getVrListThree(cv));
		model.addAttribute("page", new PageVO(cv, total));
		
		return "/section/vr/vr_now+2";
	}
	
	@GetMapping("/clip")
	public String goToClip(Model model, ConditionValue cv) {
		
		long total = service.getVideoCount();
		
		model.addAttribute("list", service.getVideoList(cv));
		model.addAttribute("page", new PageVO(cv, total));
		
		return "/section/clip/clip";
	}
	
	@GetMapping("/viewmap")
	public String goToViewMap() {
		return "/section/viewmap";
	}
	
	@GetMapping("/vr_write")
	public String writeVrForm() {
		return "/section/vr/vr_write";
	}
	
	@PostMapping("/vr_write")
	public String writeVr(BoardVO boardVO, @RequestParam("sectionNo") int sectionNo, @RequestParam("file") MultipartFile file) {
		
		String uploadDir = "src/main/resources/static/images";
		
		try {
			
			Path filePath = Paths.get(uploadDir, file.getOriginalFilename());
			Files.write(filePath, file.getBytes());
			
			long boardNo = service.vrWrite(boardVO, sectionNo);
			service.imageUpload(boardNo, file);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/vr";
	}
	
	@GetMapping("/clip_write")
	public String writeVideoForm() {
		return "/section/clip/clip_write";
	}
	
	@PostMapping("/clip_write")
	public String writeVideo(BoardVO boardVO, @RequestParam("sectionNo") int sectionNo, @RequestParam("youtubeLink") String youtubeLink) {
		
			long boardNo = service.videoWrite(boardVO, sectionNo);
			service.videoUpload(boardNo, youtubeLink);
			
		return "redirect:clip";
	}
	
	@GetMapping("/vr_view/{boardNo}")
	public String vrView(@PathVariable("boardNo") long boardNo, Model model) {
		
		model.addAttribute("board", service.getVrView(boardNo));
		model.addAttribute("image", service.getVrViewImage(boardNo));
		
		return "/section/vr/vr_view";
	}
	
	@GetMapping("/clip_view/{boardNo}")
	public String videoView(@PathVariable("boardNo") long boardNo, Model model) {
		
		model.addAttribute("board", service.getClipView(boardNo));
		model.addAttribute("video", service.getClipViewVideo(boardNo));
		
		return "/section/clip/clip_view";
	}
		
}
