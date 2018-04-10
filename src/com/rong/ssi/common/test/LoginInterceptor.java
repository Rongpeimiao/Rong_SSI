package com.rong.ssi.common.test;
/*package com.atis.atispt.common.test;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	*//**
	 * 
	 *//*
	private static final long serialVersionUID = -7394093611126625836L;

    @Override
    public void destroy() {
    	System.out.println("Destory");
    }
	@Override
	public void init() {
		System.out.println("init");
	}
	
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("actionִ��֮ǰ"); 
        String name = invocation.getInvocationContext().getName(); 
        System.out.println("���󷽷���" + name); 
        ActionContext ac = invocation.getInvocationContext(); 
        Map<String, Object> session = ac.getSession(); 
        boolean allow = name.equals("infolist") || name.equals("xwgg") 
                || name.equals("pxdt") || name.equals("noticethrid") 
                || name.equals("gqpx") || name.equals("gp") 
                || name.equals("np") || name.equals("sp") 
                || name.equals("wypx") || name.equals("zgks") 
                || name.equals("shpx") || name.equals("fwxz") 
                || name.equals("noticesec") || name.equals("filedown"); 
        if (name.equals("login") || allow) { 
            // ����û����½������ִ�е���allow���������أ�ʹ֮ͨ�� 
            // invocation.invoke()�������������������Ĵ��� 
 
            return invocation.invoke(); 
 
        } else { 
            if (session.isEmpty() || session == null) { 
                // ���sessionΪ�գ������û���½ 
                return "login"; 
            } else { 
                String user = session.get("user").toString(); 
                if (user == null) { 
                    // session��Ϊ�գ�����session��û���û���Ϣ 
                    // ���û���½ 
                    return "login"; 
                } else { 
                    // �û��Ѿ���½����½�ɹ� 
                    return invocation.invoke(); 
                } 
            } 
        } 
    }

}
*/