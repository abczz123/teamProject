package com.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String writeVr(BoardVO boardVO, @RequestParam("sectionNo") int sectionNo) {
		service.vrWrite(boardVO, sectionNo);
		return "redirect:/vr";
	}
	
	@GetMapping("/clip_write")
	public String writeVideoForm() {
		return "/section/clip/clip_write";
	}
	
	@PostMapping("/clip_write")
	public String writeVideo(BoardVO boardVO, @RequestParam("sectionNo") int sectionNo) {
		service.videoWrite(boardVO, sectionNo);
		return "redirect:clip";
	}
	
	@GetMapping("/vr_view/{boardNo}")
	public String vrView(@PathVariable("boardNo") long boardNo, Model model) {
		
		model.addAttribute("board", service.getVrView(boardNo));
		
		return "/section/vr/vr_view";
	}
	
	@GetMapping("/clip_view/{boardNo}")
	public String videoView(@PathVariable("boardNo") long boardNo, Model model) {
		
		model.addAttribute("board", service.getVideoView(boardNo));
		
		return "/section/clip/clip_view";
	}
	
//	@PostMapping("/upload")
//	public String upload(@RequestParam("file") MultipartFile file) {
//		String fileRealName = file.getOriginalFileName();
//		long size = file.getSize();
//		
//		
//	}
	
	
}
