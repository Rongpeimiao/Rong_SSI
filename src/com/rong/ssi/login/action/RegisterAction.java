package com.rong.ssi.login.action;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rong.ssi.common.CommonUtil;
import com.rong.ssi.common.Log4jUtil;
import com.rong.ssi.common.Pager;
import com.rong.ssi.login.entity.User;
import com.rong.ssi.login.service.UserDaoServiceInter;
/**
 * @author »›≈‡Ìµ
 * ”√ªßµ«¬Ωaction
 * 
 */
public class RegisterAction extends BaseAction {

	/**
	 * login action
	 */
	private static final long serialVersionUID = 1L;
    private UserDaoServiceInter  userdaoServiceInter;
    private String userCode;
    private String password;
    private List<User> userList=new ArrayList<User>();
    private  Pager pager;
	private Integer numPerPage;
	private Integer pageNum;
	private User userDto=new User();
    
	public UserDaoServiceInter getUserdaoServiceInter() {
		return userdaoServiceInter;
	}


	public String getUserCode() {
		return userCode;
	}


	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}


	public String getPassword() {
		return password;
	}

	public List<User> getUserList() {
		return userList;
	}

	public Pager getPager() {
		return pager;
	}

	public Integer getNumPerPage() {
		return numPerPage;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public User getUserDto() {
		return userDto;
	}

	public void setUserdaoServiceInter(UserDaoServiceInter userdaoServiceInter) {
		this.userdaoServiceInter = userdaoServiceInter;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public void setNumPerPage(Integer numPerPage) {
		this.numPerPage = numPerPage;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public void setUserDto(User userDto) {
		this.userDto = userDto;
	}
   
	public String loginUser()throws Exception{
    	try {
    		if(null!=this.userCode&&!"".equals(this.userCode)){
				Map<String, Object>  codeMap=new HashMap<String,Object>();
				codeMap.put("userCode", userCode);
				codeMap.put("password",password);// CommonUtil.MD5Util(password)
				
				Integer total=userdaoServiceInter.queryUserListTotal(codeMap);
			    pager=new Pager(pageNum, numPerPage, total);
				codeMap.put("pageNum",(pager.getPageNum()-1)*pager.getNumPerPage());
				codeMap.put("numPerPage", pager.getNumPerPage());
				
				userList=userdaoServiceInter.queryUserList(codeMap);
					if(userList.size()>0&&!userList.isEmpty()){
						return "success";
					}else{
						return "error";
					}
			}else{
				return "error";
			}
		} catch (Exception e) {
			Log4jUtil.Log4jUtilThrowable(new Throwable().getStackTrace()[1].getClassName(), e);
			return "error";
		}
    }

}
