package kr.ac.kopo.member.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.framework.annotation.RequestMapping;
import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

/**
 * Controller handling member related actions.
 */
public class MemberController {

    private MemberService memberService = new MemberService();

    @RequestMapping("/login.do")
    public String loginForm(HttpServletRequest request, HttpServletResponse response) {
        return "/login/login.jsp";
    }

    @RequestMapping("/loginProcess.do")
    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MemberVO loginVO = new MemberVO();
        loginVO.setId(request.getParameter("id"));
        loginVO.setPassword(request.getParameter("password"));
        MemberVO member = memberService.login(loginVO);
        if (member != null) {
            request.getSession().setAttribute("userVO", member);
            request.setAttribute("msg", "로그인되었습니다");
            request.setAttribute("url", "/board/list.do");
        } else {
            request.setAttribute("msg", "아이디 또는 비밀번호가 틀립니다");
            request.setAttribute("url", "/login/login.jsp");
        }
        return "/login/loginProcess.jsp";
    }

    @RequestMapping("/logout.do")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        return "redirect:/board/list.do";
    }

    @RequestMapping("/member/register.do")
    public String register(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MemberVO member = new MemberVO();
        member.setId(request.getParameter("id"));
        member.setPassword(request.getParameter("password"));
        member.setName(request.getParameter("name"));
        member.setNickname(request.getParameter("nickname"));
        member.setAge(Integer.parseInt(request.getParameter("age")));
        member.setGender(request.getParameter("gender"));
        member.setHeight(Double.parseDouble(request.getParameter("height")));
        member.setWeight(Double.parseDouble(request.getParameter("weight")));

        memberService.register(member);
        return "redirect:/login.do";
    }
}
