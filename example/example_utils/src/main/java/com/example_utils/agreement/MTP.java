package com.example_utils.agreement;

import java.sql.Timestamp;

/**
 * Message Transfer Protocol(消息传输协议)
 * @author 962
 *
 */
public class MTP {
	/**
	 * 发送消息的时间
	 */
	private Timestamp time;
	/**
	 * 发送者Id
	 */
	private int senderId;
	/**
	 * 发送者Ip
	 */
	private int senderIp;
	/**
	 * 发送者角色Id
	 */
	private int senderRoleId;
	/**
	 * 目标Id
	 */
	private int targetId;
	/**
	 * 目标Ip
	 */
	private int targetIp;
	/**
	 * 目标角色Id
	 */
	private int targetRoleId;
	/**
	 * 发送的信息
	 */
	private String message;
}
