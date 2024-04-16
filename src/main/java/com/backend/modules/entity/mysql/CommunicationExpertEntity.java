package com.backend.modules.entity.mysql;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author hsy
 * @email 760356917@qq.com
 * @date 2024-04-08 21:35:18
 */
@Data
@TableName("communication_expert")
public class CommunicationExpertEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer communicationExpertId;
	/**
	 * 
	 */
	private Integer expertId;
	/**
	 * 
	 */
	private Integer uId;
	/**
	 * 
	 */
	private String content;
	/**
	 * 
	 */
	private Integer isDeleted;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Date updateTime;

}
