package az.com.course.controller;

import az.com.course.bean.token.TokenRequestBean;
import az.com.course.bean.token.TokenResponseBean;
import az.com.course.persistance.entity.User;
import az.com.course.persistance.service.UserService;
import az.com.course.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/token")
    public TokenResponseBean token(@RequestBody TokenRequestBean tokenRequestBean) {
        User byUsername = userService.findByUsername(tokenRequestBean.getUsername());
        String token = jwtTokenUtil.generateToken(byUsername.getUsername());
        return new TokenResponseBean(555, "success", token);

    }
}
