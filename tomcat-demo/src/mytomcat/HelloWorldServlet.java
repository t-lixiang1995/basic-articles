package mytomcat;
/**
 * Servlet实现类用于后续测试
 * @author pcitc
 *
 */
public class HelloWorldServlet extends MyServlet{
	@Override
	public void doGet(MyRequest myRequest,MyResponse myResponse){
		try {
			myResponse.write("get world...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void doPost(MyRequest myRequest,MyResponse myResponse){
		try {
			myResponse.write("post world...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
