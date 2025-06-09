package kr.ac.kopo.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import kr.ac.kopo.framework.annotation.RequestMapping;

public class HandlerMapping {

    public HandlerMapping() throws Exception {
        String[] controllers = {
            "kr.ac.kopo.board.controller.BoardController",
            "kr.ac.kopo.member.controller.MemberController",
            "kr.ac.kopo.diet.controller.DietController"
        };
        for (String controller : controllers) {
            Class<?> clz = Class.forName(controller);
            Constructor<?> constructor = clz.getConstructor();
            Object target = constructor.newInstance();
            Method[] methods = clz.getMethods();
            for (Method method : methods) {
                RequestMapping reqAnno = method.getAnnotation(RequestMapping.class);
                if (reqAnno != null) {
                    String uri = reqAnno.value();
                    System.out.println("url : " + uri + " -> " + controller + "." + method.getName());
                }
            }
        }
    }
}
