package mytomcat;
/**
 * Servlet实现类用于后续测试
 * @author pcitc
 *
 */
public class FindGirlServlet extends MyServlet{

	@Override
	public void doGet(MyRequest myRequest,MyResponse myResponse){
		try {
			myResponse.write("get girl...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void doPost(MyRequest myRequest,MyResponse myResponse){
		try {
			myResponse.write("post girl...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
