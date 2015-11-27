package kr.ac.kookmin.cs.sms;

import java.util.ArrayList;

import kr.ac.kookmin.cs.basic.AppModel;

public class SMSModel implements AppModel {
	private ArrayList<String> msgList = new ArrayList<String>();
	private ArrayList<String> senderList = new ArrayList<String>();
	private int newMsg = 0;
	private int currentMsg = 0;
	private int totalMsg = 0;

	public void addMsg(String msg,String sender)
	{
		msgList.add(msg);
		senderList.add(sender);
		newMsg++;
		totalMsg++;
		currentMsg = totalMsg - 1;
	}

	public boolean isMsg()
	{
		if(totalMsg>0)
			return true;
		else
			return false;
	}

	public String getNewMsg()
	{
		String msg = msgList.get(currentMsg);
	    String formatStr = "";
	    int lineSize = 11;
	    int lineNum = 5;

	    for(int i=0, j=0; i<lineNum; i++, j++) {
	      for(int count =0; count < lineSize; count++, j++) {
	        if(j >= msg.length() || msg.charAt(j) == '\n')
	          break;
	        formatStr += msg.charAt(j);
	      }
	      formatStr +='\n';
	    }

	    formatStr+="from:"+senderList.get(currentMsg);
	    return formatStr;
	}

	public int getNewMsgNum()
	{
		return newMsg;
	}

	public void leftMsg()
	{
		currentMsg--;
		if(currentMsg<0)
			currentMsg = totalMsg-1;
	}

	public void rightMsg()
	{
		currentMsg++;
		if(currentMsg == totalMsg)
			currentMsg = 0;
	}

	public void clearMsg()
	{
		newMsg = 0;
	}
}
