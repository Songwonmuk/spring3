package net.softsociety.spring3.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring3.controller.PersonController;
import net.softsociety.spring3.service.PersonService;
import net.softsociety.spring3.vo.Person;

@Slf4j
@Controller
public class PersonController {

//	@Autowired // 기억해라 Mapper나 Controller가붙은 객체는 프로그램 실행시 자동 생성됨
//	// 따라서 autowired 입력시 알아서 가져와서 넣어줌
//	PersonDAO dao;
	
	@Autowired
	PersonService service;
	
	@GetMapping("/insert")
	private String name() {
		return "insert";
	}
	@PostMapping("/insert")
	private String insert(Person person) {
		log.debug("전달된 값 : {}", person);
		
		service.insertPerson(person);
		
		return "redirect:/";
	}
	
	//삭제 요청 처리
	//경로명: delete 메소드:get
	//name이라는 이름의 parameter를 전달받아 로그출력
	//메인화면으로 리다이렉트
	@GetMapping("/delete")
	private String delete(String name) {
		log.debug("전달된 값 : {}", name);
		int result = service.deletePerson(name);
		
		if(result == 0) {
			log.debug("해당 이름이 없습니다.");
		}
		else {
			log.debug("{} 삭제 성공", name);
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/select")
	public String select(Model model) {
		
		ArrayList<Person> list = service.selectPerson();
		log.debug("조회결과: {}", list);
		
		model.addAttribute("list", list);
		
		return "select";
	}
	
}
