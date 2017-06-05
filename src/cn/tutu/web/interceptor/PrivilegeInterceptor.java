package cn.tutu.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 权限拦截器
 *
 * Created by 曹贵生 on 2017/6/4.
 * Email: 1595143088@qq.com
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Object user = ActionContext.getContext().getSession().get("user");
        if (user == null) {
            return "toLogin";
        }
        return actionInvocation.invoke();
    }
}
