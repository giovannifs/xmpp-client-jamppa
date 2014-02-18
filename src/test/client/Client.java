package test.client;

import org.jamppa.client.XMPPClient;
import org.jamppa.client.plugin.xep0077.XEP0077;
import org.jivesoftware.smack.XMPPException;
import org.xmpp.packet.IQ;
import org.xmpp.packet.IQ.Type;


public class Client {
	public static void main(String[] args) throws XMPPException,
			InterruptedException {

//		ConnectionConfiguration config = new ConnectionConfiguration(
//				"127.0.0.1", 5222, "test.com");
//		Connection conn2 = new XMPPConnection(config);
//		conn2.connect();
//		conn2.login("user1", "user1");
//		IQ iq = new IQ() {
//
//			@Override
//			public String getChildElementXML() {
//				return "<query xmlns = \"uppercase\"><content>Hello World</content></query>";
//			}
//		};
//		
//		iq.setFrom("user1@test.com");
//		iq.setTo("uppercase.test.com");
//		System.out.println(iq.toXML());
//		conn2.sendPacket(iq);
//
//		IQ answer = (IQ) SyncPacketSend.getReply(conn2, iq);
//		System.out.println(answer.toXML());

		
		XMPPClient client = new XMPPClient("user1@test.com", 
				"user1", "localhost", 5222);
		
		client.connect();
			
		client.login();
		client.process(false);
		
		IQ iq = new IQ(Type.get);
		iq.setTo("uppercase.test.com");
		iq.getElement()
				.addElement("query", "uppercase")
				.addElement("content")
				.setText("hello world");
		
		IQ response = (IQ) client.syncSend(iq);
		System.out.println(response.toXML());
		client.disconnect();
		
	}
}
