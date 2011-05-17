package quanquen;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

import quanquen.bussinessaccess.Connection;
import quanquen.model.Address;
import quanquen.model.Article;
import quanquen.model.Category;
import quanquen.model.Comment;
import quanquen.model.Group;
import quanquen.model.Image;
import quanquen.model.Member;
import quanquen.model.Place;

public class DataTest {
	private static PersistenceManager pm;

	public static void main(String[] args) {
		pm = Connection.getPersistenceManager();
		List<Address> address = new ArrayList<Address>();
		List<Category> categories = new ArrayList<Category>();
		List<Place> places = new ArrayList<Place>();
		List<Article> articles = new ArrayList<Article>();
		List<Comment> comments = new ArrayList<Comment>();
		List<Image> images = new ArrayList<Image>();
		List<Member> members = new ArrayList<Member>();
		
		
		for (int i=1; i<=17; i++){
			images.add(new Image("images/place/hinh ("+i+").jpg"));
		}
		
		
		String[] street1 = new String[] { "Điện biên phủ", "Đinh Tiên Hoàng",
				"Nam kì khởi nghĩa", "Cao bá quát", "Tông thất tùng",
				"Các mạng tháng tám", "Lý tự trọng", "Sương nguyệt ánh" };
		String[] street2 = new String[] { "Xa lộ Hà Nội" };
		String[] street3 = new String[] { "Xa lộ Hà Nội" };
		String[] street4 = new String[] { "Xa lộ Hà Nội" };
		String[] street5 = new String[] { "Xa lộ Hà Nội" };
		String[] td = new String[] { "Đường trường Sơn", "Võ Văn Ngân",
				"Đặng Văn Bi", "Thống Nhất", "Hoàng Diệu 2", "Kha Vạn Cân",
				"Tô Ngọc Vân", "Gò Dưa", "Lê Văn Việt" };

		String[] categoriesString = new String[] { "Quán cà phê", "Quán Internet",
				"Shop quần áo", "Quán ăn", "Cửa hàng máy tính",
				"Cửa hàng sách", "Quán Chè", "Quán phở", "Quán bún",
				"Quán hủ tiếu", "Quán Sinh tố", "Khu vui chơi", "Công viên",
				"Nhà hàng", "Khách sạn", "Bệnh viện", "Trường THPT",
				"Trường ĐH", "Trường CĐ", "Cơ quan - Tổ chức", "Quán mì",
				"Quán Bánh xèo", "Quán nhậu", "Cửa hàng giày dép",
				"Cửa hàng điện thoại", "Cửa hàng đồ gia dụng",
				"Cửa hàng mĩ phẩm", "Siêu thị", "Cửa hàng điện máy",
				"Quán sửa xe máy, đạp, ô tô", "Trạm ATM", "Cây xăng",
				"Ngân hàng", "Bưu điện", "Chợ", "Trung tâm thương mại",
				"Sân vận động", "Câu lạc bộ", "Nhà hát", "Rạp chiếu phim",
				"Khách sạn", "Chùa", "Nhà thờ" };
		String[] district = new String[] { "Quận 1", "Quận 2", "Quận 3",
				"Quận 4", "Quận 5", "Quận 6", "Quận 7", "Quận 8", "Quận 9",
				"Quận 10", "Quận 11", "Quận 12", "Quận Bình Thạnh",
				"Quận Phú Nhuận", "Gò Vấp", "Quận Tân Bình", "Quận Thủ Đức" };
		String[] usernames = new String[] { "vinh", "duc", "quan", "duong",
				"tung", "thao", "my", "luyen", "nga", "hieu", "manh", "chien",
				"nam", "tam", "dai", "xuan", "tram" };
		
		String aContent1 = "Mình thì không trung thành với rạp chiếu nào cả nhưng tính tần suất đi xem ở các rạp thì có khi mình đi Galaxy nhiều nhất. Thường thì mình đi Galaxy Nguyễn Du nhưng hum bữa đi với đứa qua Galaxy Nguyễn Trãi bỗng dưng nổi hứng lên thế là vào xem luôn.  Nói chung là về màn hình, chất lượng âm thanh thì mình thấy cũng ok (như bên Nguyễn Du thôi). Quầy bán vé cũng rất chuyên nghiệp. Bắp rang ngon, rẻ hơn bên mega :D. Thêm nữa là: Nhân viên ở đây phục vụ rất tốt, mình có cảm tình hơn so với bên Nguyễn Du. Mấy chị nói năng, hỏi han khách cũng rất lịch sự và phục vụ chu đáo. Mặc dù khách mua vé đông nhưng vẫn làm cho mình cảm thấy ở Galaxy Nguyễn Trãi coi \"khách hàng là thượng đế\" chứ không phải \"bán vé là số 1\". Nhân viên phục vụ cũng là điều khá quan trọng trong việc quyết định hứng khởi cho bạn trước khi vào rạp xem phim đấy. Vì nếu bực bội thì tâm trạng mất vui, ăn bắp ";
		String aContent2 = "Galaxy NT vé thường rẻ hơn galaxy ND, mình thích kiểu phân bố và trang trí rạp ở đây hơn bên NDu. Lần đầu tiên đi coi film ở NT là lúc tết đi coi bóng ma học đưiờng với mấy đứa pạn. Chứ trước đó thì thường là mình coi ở Nguyễn Du. Kể từ lúc đó, tự nhiên thích bên NT hơn lun. Nhân viên ở đêy khá là nhiệt tình hướng dẫn khách, Rạp thì nói chug là sạch sẽ và khá là ok";
		String aConent3 = "Ôi rạp chiếu phim Galaxy Nguyễn Trãi thì khỏi phải chê. Có thể nói rằng ở đây rất sạch sẽ và thoáng mát. Phòng chờ coi phim rất lớn và mát mẻ, thoải mái tự do chờ đến giờ coi phim không hề có chút phiền nào hết. Phòng chiếu phim thì có 3 phòng. Phòng nào cũng được trang bị màn hình sáng sủa, sạch sẽ dễ nhìn, trong veo,chất lượng hình ảnh rất là tốt. Hệ thống âm thanh thì nghe rất rõ ràng và đã tai. Không hề bị mất âm, mất chữ hay ồn ào khó nghe. Ghế ngồi rất êm ái, dễ chịu, phòng luôn giữ rất sạch sẽ, mát mẻ. Hệ thống máy điều hòa vừa phải không lạnh lắm, rất dễ chịu. Phim ảnh được chiếu ở đây thì có sự lựa chọn rất hay và tinh tế. Không bộ phim nào được chiếu ở đây bị phàn nàn cả. Nhiều khi tới coi một phim mà muốn coi tới nhiều lần luôn. Nhân viên có phong cách phục vụ tốt, vui vẻ và hòa đồng, ăn nói dễ nghe. Kết hợp là khó mà chê được nhiều. Các bạn hoàn toàn yên tâm về chất lượng, phong cách phục vụ và cả phim ảnh được chiếu tại đây. Do là rạp nằm trong khu mua sắm luôn nên khi xem phim xong các bạm cũng có thể đi mua sắm luôn. Mình thường đến đâY để xem phim hoài và mình thấy rất hài lòng luôn.";
		
		
		
		
		//------------------------Start Address----------------------------------
		for(int j=0; j<street1.length; j++){
			Address a = new Address("TP.Hồ Chí Minh", "Quận 1", street1[j], "11B");
			address.add(a);
//			System.out.println(a.toString());
		}
		for(int j=0; j<street1.length; j++){
			Address a = new Address("TP.Hồ Chí Minh", "Thủ Đức", td[j], "11B");
			address.add(a);
//			System.out.println(a);
		}
		//---------------------------End Address-------------------------------
		
		
		
		
		
		
		
		//------------------------------------Start Group------------------------------------
		LinkedHashSet<String> member = new LinkedHashSet<String>();
		LinkedHashSet<String> admin = new LinkedHashSet<String>();
		member.add("member");
		admin.add("member");
		admin.add("admin");
		Group groupAdmin = new Group("admin", new LinkedHashSet<Member>(),
				admin);
		Group groupMember = new Group("member", new LinkedHashSet<Member>(),
				member);
		//-------------------------------------End group-------------------------------------------------
		
		
		
		
		
		
		
		//---------------------------------Start Member---------------------------------------
		for (int i=0; i<usernames.length; i++){
			Member aa = new Member(usernames[i], usernames[i], usernames[i] + "@yahoo.com", new Date(), groupMember, true);
			if (i >= address.size()){
				break;
			}
			aa.setAddress(address.get(i));
			members.add(aa);
			groupMember.addMember(aa);
//			System.out.println(aa);
		}
		//---------------------------------End Member----------------------------------------------
		
		
		
		
		
		
		
		
		//---------------------------------Start Comment---------------------------------------
		for (int i=0; i<members.size(); i++){
			Comment a=  new Comment(members.get(i), new Date(), aContent2);
			a.setId(i);
			comments.add(a);		
		}
		//---------------------------------End Comment----------------------------------------------
		
		
		

		
		//---------------------------------Start Article---------------------------------------
		for (int i=0; i<members.size(); i++){
			Article a = new Article("Không có", members.get(i), new Date(), aConent3);
			Article aa = new Article("Không có", members.get(i), new Date(), aContent1);
			Article aaa = new Article("Không có", members.get(i), new Date(), aContent2);
			for (int j=0; j<1; j++){
				Comment d=  new Comment(members.get(j), new Date(), aContent2);
				comments.add(d);
				LinkedList<Comment> cm = new LinkedList<Comment>();
				cm.add(d);
				a.setComments(cm);
				aa.setComments(cm);
				aa.setComments(cm);
				articles.add(a);
				articles.add(aa);
				articles.add(aa);				
			}
			
		}
		//---------------------------------End Article----------------------------------------------
		
		
		
		
		
		//---------------------------------Start Category---------------------------------------
		for (int i=0; i<categoriesString.length; i++){
			Category a = new Category(categoriesString[i]);
			categories.add(a);
		}
		//---------------------------------End Category----------------------------------------------
		
		
		
		
		
		
//		Transaction tx = pm.currentTransaction();
//		tx.begin();
//		Category category = categories.get(0);
//		Member memberTest = members.get(0);
//		Article article = articles.get(0);
//		Comment comment = comments.get(0);
//		Address address2 = address.get(0);
//	
//		
//		
//		
//		
//		//Set list manager in place
//		LinkedHashSet<Member> managers = new LinkedHashSet<Member>();
//		Place place = new Place("Test", address2, null, null);
//		managers.add(memberTest);
//		place.setManagers(managers);
//		
//
//		pm.makePersistent(memberTest);
//		pm.makePersistent(place);
//		
//		//Set list place in member
//		LinkedHashSet<Place> p = new LinkedHashSet<Place>();
//		p.add(place);
//		memberTest.setPlaces(p);
//		
//		pm.makePersistent(memberTest);
//		pm.makePersistent(place);

		
		
		
		
		
		
		//---------------------------------Start Place---------------------------------------
		for (int i=0; i< categories.size(); i++){
					LinkedHashSet<Category> a = new LinkedHashSet<Category>();
					a.add(categories.get(i));
					for (int k = 0; k < members.size(); k++){
						LinkedHashSet<Member> b = new LinkedHashSet<Member>();
						b.add(members.get(k));
						
						Place p = new Place(categories.get(k).getTitle() + " " + k, address.get(k), a, b);
						LinkedHashSet<Article> ad = new LinkedHashSet<Article>();
						ad.add(articles.get(k));
						p.setArticles(ad);
						LinkedList<Image> image= new LinkedList<Image>();
						image.add(images.get(k));
						p.setImages(image);
						places.add(p);
						categories.get(i).addPlace(p);
//						
					}
			}

		//---------------------------------End Place----------------------------------------------
//		tx.commit();
//		pm.close();
		
		
		
		
		
		
		
		
		
		
		
		//=================================================Start save==========================================
		Transaction tx = pm.currentTransaction();
		tx.begin();
		pm.makePersistent(groupMember);
		pm.makePersistent(groupAdmin);
		
		for(Category p: categories){
			pm.makePersistent(p);			
		}
		
		for(Comment p: comments){
			pm.makePersistent(p);			
		}
		
		for(Article p: articles){
			pm.makePersistent(p);			
		}
		
		for(Place p: places){
				pm.makePersistent(p);			
		}
		
//		pm.makePersistent(members);
//		pm.makePersistent(groupMember);
//		pm.makePersistent(groupAdmin);
//		pm.makePersistent(places);
		tx.commit();
		pm.close();
		//=================================================End save==========================================
		
		System.out.println("--------------------------------All Done----------------------");
		System.out.println("Hinh " + images.size());
		System.out.println("Place " + places.size());
		System.out.println("Address " + address.size());
		System.out.println("Member " + members.size());
		System.out.println("Category " + categories.size());
		System.out.println("Article " + articles.size());
		System.out.println("Comment " + comments.size());
//		System.out.println("" + );
		
		
	}
}
