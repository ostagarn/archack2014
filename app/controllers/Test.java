package controllers;

import play.mvc.Controller;

public class Test extends Controller {


	public static void test1() {
		String parameterx = "ddd";
		//renderArgs.put("parameterx", parameterx);
        render(parameterx);
    }

}
