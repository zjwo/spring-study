package cn.imzjw.service.impl;

import cn.imzjw.service.IAccountService;

import java.util.*;

/**
 * @author https://blog.imzjw.cn
 * @date 2021/1/17 11:35
 */
public class AccountServiceImpl3 implements IAccountService {

	/**
	 * 复杂类型
	 */
	private String[] str;
	private List<String> list;
	private Set<String> set;
	private Map<String, String> map;
	private Properties prop;

	public void setStr(String[] str) {
		this.str = str;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	@Override
	public void saveAccount() {
		System.out.println("str=" + Arrays.toString(str) + ", list=" + list + ", set=" + set + ", map=" + map + ", prop=" + prop);
	}
}