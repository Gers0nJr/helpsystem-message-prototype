package br.com.helpsystem.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageUserController {

	@GetMapping("/message")
	public String acessoMessage() {
		return "/message-page";
	}
}
