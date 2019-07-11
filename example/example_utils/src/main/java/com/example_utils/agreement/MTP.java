package com.example_utils.agreement;

import java.sql.Timestamp;

/**
 * Message Transfer Protocol(��Ϣ����Э��)
 * @author 962
 *
 */
public class MTP {
	/**
	 * ������Ϣ��ʱ��
	 */
	private Timestamp time;
	/**
	 * ������Id
	 */
	private int senderId;
	/**
	 * ������Ip
	 */
	private int senderIp;
	/**
	 * �����߽�ɫId
	 */
	private int senderRoleId;
	/**
	 * Ŀ��Id
	 */
	private int targetId;
	/**
	 * Ŀ��Ip
	 */
	private int targetIp;
	/**
	 * Ŀ���ɫId
	 */
	private int targetRoleId;
	/**
	 * ���͵���Ϣ
	 */
	private String message;
}
