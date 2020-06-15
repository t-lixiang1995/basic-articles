package mytomcat;
/**
 * tomcat是满足servlet规范的容器，所以要提供servlet的几个常用方法doGet,doPost,service
 * @author pcitc
 *
 */
public abstract class MyServlet {

	public abstract void doGet(MyRequest myRequest,MyResponse myResponse);
	public abstract void doPost(MyRequest myRequest,MyResponse myResponse);
	
	public void service(MyRequest myRequest,MyResponse myResponse){
		if(myRequest.getMethod().equalsIgnoreCase("GET")){
			doGet(myRequest,myResponse);
		}
		if(myRequest.getMethod().equalsIgnoreCase("POST")){
			doPost(myRequest,myResponse);
		}
	}
}
