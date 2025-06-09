package kr.ac.kopo.diet.controller;

import java.time.LocalDate;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.diet.service.DietService;
import kr.ac.kopo.diet.vo.DietRecordVO;
import kr.ac.kopo.framework.annotation.RequestMapping;

/**
 * Controller for diet related endpoints.
 */
public class DietController {

    private DietService dietService = new DietService();

    @RequestMapping("/diet/list.do")
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String memberId = request.getParameter("memberId");
        List<DietRecordVO> list = dietService.getRecords(memberId);
        request.setAttribute("dietList", list);
        return "/diet/list.jsp";
    }

    @RequestMapping("/diet/add.do")
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DietRecordVO record = new DietRecordVO();
        record.setMemberId(request.getParameter("memberId"));
        record.setDate(LocalDate.parse(request.getParameter("date")));
        record.setMealType(request.getParameter("mealType"));
        record.setFoodName(request.getParameter("foodName"));
        record.setCalories(Integer.parseInt(request.getParameter("calories")));
        record.setMemo(request.getParameter("memo"));

        dietService.addRecord(record);
        return "redirect:/diet/list.do?memberId=" + record.getMemberId();
    }
}
