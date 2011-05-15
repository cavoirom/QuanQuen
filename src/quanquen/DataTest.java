package quanquen;

import java.util.Date;
import java.util.LinkedHashSet;

import javax.jdo.PersistenceManager;

import quanquen.bussinessaccess.Connection;
import quanquen.model.Group;
import quanquen.model.Member;

public class DataTest {
	private static PersistenceManager pm;

	public static void main(String[] args) {
		pm = Connection.getPersistenceManager();

		String[] categorys = new String[] { "Ẩm thực", "Giải trí",
				"Mua sắm - Thời trang", "Làm đẹp - Sức khỏe", "Dịch Vụ",
				"Học Tập", "Cơ Quan - Tổ Chức" };
		String[] district = new String[] { "Quận 1", "Quận 2", "Quận 3",
				"Quận 4", "Quận 5", "Quận 6", "Quận 7", "Quận 8", "Quận 9",
				"Quận 10", "Quận 11", "Quận 12", "Quận Bình Thạnh",
				"Quận Phú Nhuận", "Gò Vấp", "Quận Tân Bình", "Quận Thủ Đức" };
		LinkedHashSet<String> member = new LinkedHashSet<String>();
		LinkedHashSet<String> admin = new LinkedHashSet<String>();
		member.add("member");
		admin.add("member");
		Group group2 = new Group("admin", new LinkedHashSet<Member>(), admin);
		Group group = new Group("member", new LinkedHashSet<Member>(), member);
		Member phong = new Member("phong", "phong", "huuphongdn2009@yahoo.com",
				new Date(1989, 11, 6), group, true);
		String aContent1 = "Mình thì không trung thành với rạp chiếu nào cả nhưng tính tần suất đi xem ở các rạp thì có khi mình đi Galaxy nhiều nhất. Thường thì mình đi Galaxy Nguyễn Du nhưng hum bữa đi với đứa qua Galaxy Nguyễn Trãi bỗng dưng nổi hứng lên thế là vào xem luôn.  Nói chung là về màn hình, chất lượng âm thanh thì mình thấy cũng ok (như bên Nguyễn Du thôi). Quầy bán vé cũng rất chuyên nghiệp. Bắp rang ngon, rẻ hơn bên mega :D. Thêm nữa là: Nhân viên ở đây phục vụ rất tốt, mình có cảm tình hơn so với bên Nguyễn Du. Mấy chị nói năng, hỏi han khách cũng rất lịch sự và phục vụ chu đáo. Mặc dù khách mua vé đông nhưng vẫn làm cho mình cảm thấy ở Galaxy Nguyễn Trãi coi \"khách hàng là thượng đế\" chứ không phải \"bán vé là số 1\". Nhân viên phục vụ cũng là điều khá quan trọng trong việc quyết định hứng khởi cho bạn trước khi vào rạp xem phim đấy. Vì nếu bực bội thì tâm trạng mất vui, ăn bắp ";
		String aContent2 = "Galaxy NT vé thường rẻ hơn galaxy ND, mình thích kiểu phân bố và trang trí rạp ở đây hơn bên NDu. Lần đầu tiên đi coi film ở NT là lúc tết đi coi bóng ma học đưiờng với mấy đứa pạn. Chứ trước đó thì thường là mình coi ở Nguyễn Du. Kể từ lúc đó, tự nhiên thích bên NT hơn lun. Nhân viên ở đêy khá là nhiệt tình hướng dẫn khách, Rạp thì nói chug là sạch sẽ và khá là ok";
		String aConent3 = "Ôi rạp chiếu phim Galaxy Nguyễn Trãi thì khỏi phải chê. Có thể nói rằng ở đây rất sạch sẽ và thoáng mát. Phòng chờ coi phim rất lớn và mát mẻ, thoải mái tự do chờ đến giờ coi phim không hề có chút phiền nào hết. Phòng chiếu phim thì có 3 phòng. Phòng nào cũng được trang bị màn hình sáng sủa, sạch sẽ dễ nhìn, trong veo,chất lượng hình ảnh rất là tốt. Hệ thống âm thanh thì nghe rất rõ ràng và đã tai. Không hề bị mất âm, mất chữ hay ồn ào khó nghe. Ghế ngồi rất êm ái, dễ chịu, phòng luôn giữ rất sạch sẽ, mát mẻ. Hệ thống máy điều hòa vừa phải không lạnh lắm, rất dễ chịu. Phim ảnh được chiếu ở đây thì có sự lựa chọn rất hay và tinh tế. Không bộ phim nào được chiếu ở đây bị phàn nàn cả. Nhiều khi tới coi một phim mà muốn coi tới nhiều lần luôn. Nhân viên có phong cách phục vụ tốt, vui vẻ và hòa đồng, ăn nói dễ nghe. Kết hợp là khó mà chê được nhiều. Các bạn hoàn toàn yên tâm về chất lượng, phong cách phục vụ và cả phim ảnh được chiếu tại đây. Do là rạp nằm trong khu mua sắm luôn nên khi xem phim xong các bạm cũng có thể đi mua sắm luôn. Mình thường đến đâY để xem phim hoài và mình thấy rất hài lòng luôn.";
		
	}
}
