package com.fpp.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import com.fpp.dto.user.UserDto;
import com.fpp.service.user.UserService;
import com.fpp.validator.user.UserValidator;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	UserValidator userValidator;

	@GetMapping("/join")
	public String join(HttpSession session) {

		return "join";
	}

	@PostMapping("/join")
	public String join_process(UserDto userDto) {

		// userDto 안에 사용자가 입력한, id , name 들어있을것이다.
		int result = userService.saveUser(userDto);

		if (result > 0) {
			// 정상 케이스
			return "login";
		} else {
			return "join";
		}

	}

	@GetMapping("/userList")
	public String userList(Model model) {

		UserDto userDto = new UserDto();

		List<UserDto> userList = userService.getUserList2(userDto);

		model.addAttribute("userList", userList);

		return "userList";
	}

}
