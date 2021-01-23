package cn.imzjw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author https://blog.imzjw.cn
 * @date 2021/1/21 16:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {

	private Integer id;
	private String name;
	private float money;
}
