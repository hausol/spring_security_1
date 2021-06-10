package edu.bit.ex.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/security/*")
@Controller
public class SecurityController {
	
    @GetMapping("/all")
    public void doAll() {
       log.info("do all can access everybody");
    }

//    // 위 void와 같은 코드
//    @GetMapping("/all")
//    public String doAll() {
//       log.info("do all can access everybody");
//       return "security/all";
//    }

    // 멤버 로그인
    @GetMapping("/member")
    public void doMember() {
       log.info("logined member");
    }
    
    // 관리자 로그인
    @GetMapping("/admin")
    public void doAdmin() {
       log.info("logined admin");
    }
    
    // 에러 해결
    @GetMapping("/accessError")
    public void accessError(Authentication auth, Principal pi, Model model) {
        
        log.info("accessError().." + auth);
        model.addAttribute("msg", "Access Denied");
    }

}
