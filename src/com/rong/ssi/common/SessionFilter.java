package com.rong.ssi.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;

public class SessionFilter
  implements Filter
{
  public void init(FilterConfig cfg)
    throws ServletException
  {}
  
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
    throws IOException, ServletException
  {
    HttpServletRequest request = (HttpServletRequest)req;
    HttpServletResponse response = (HttpServletResponse)res;
    String servletPath = request.getRequestURI();
    if (servletPath.contains("login"))
    {
      chain.doFilter(req, res);
      return;
    }
    Object sessionObj = request.getSession().getAttribute("user");
    

    boolean s = !servletPath.contains("action");
    boolean s2 = !servletPath.contains("login");
    if ((sessionObj == null) && (servletPath.contains("action")))
    {
      String contextPath = request.getContextPath();
      String redirect = servletPath + "?" + StringUtils.defaultString(request.getQueryString());
      response.sendRedirect("login.action");
    }
    else
    {
      chain.doFilter(req, res);
    }
  }
  
  public void destroy() {}
}
