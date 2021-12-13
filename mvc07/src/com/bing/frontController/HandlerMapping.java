package com.bing.frontController;

import java.util.HashMap;

import com.bing.controller.BasicController;
import com.bing.controller.MemberContentController;
import com.bing.controller.MemberDeleteController;
import com.bing.controller.MemberInsertController;
import com.bing.controller.MemberListController;
import com.bing.controller.MemberLoginController;
import com.bing.controller.MemberLogoutController;
import com.bing.controller.MemberRegisterController;
import com.bing.controller.MemberUpdateController;

public class HandlerMapping {

	private HashMap<String, BasicController> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, BasicController>();

		mappings.put("/memberList.do", new MemberListController());
		mappings.put("/memberInsert.do", new MemberInsertController());
		mappings.put("/memberRegister.do", new MemberRegisterController());
		mappings.put("/memberContent.do", new MemberContentController());
		mappings.put("/memberUpdate.do", new MemberUpdateController());
		mappings.put("/memberDelete.do", new MemberDeleteController());
		mappings.put("/memberLogin.do", new MemberLoginController());
		mappings.put("/memberLogout.do", new MemberLogoutController());
	}

	public BasicController getController(String key) { // key -> /memberList.do
		return mappings.get(key);
	}
}
