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
 * @date 2024-04-08 21:35:17
 */
@Data
@TableName("forum_discover")
public class ForumDiscoverEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer discoverId;
	/**
	 * 
	 */
	private Integer uId;
	/**
	 * 
	 */
	private String discoverTitle;
	/**
	 * 
	 */
	private String discoverContent;
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
	/**
	 *
	 */
	private String src;

}
