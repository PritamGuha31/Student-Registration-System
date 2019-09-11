import java.util.ArrayList;
import java.util.List;

import com.srs.beans.Admin;
import com.srs.beans.Books;
import com.srs.beans.ExamRegistry;
import com.srs.beans.QuestionPapers;
import com.srs.beans.School;
import com.srs.beans.Student;
import com.srs.util.Utils;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Student s=new Student(0,"Pallavi Datta","Pradip Datta","Maitreyee Datta","1995-07-07","Female","General","Indian",200000,"Viveknagar,Jadavpur","Kolkata","West Bengal","pallavidatta123@gmail.com",8282807990L,123456789123L,"pd123","What is your nickname?","Joyee");
		Utils u=new Utils();
		boolean res= u.addStudent(s);
		System.out.println(res);*/
		
		Utils u=new Utils();
		/*boolean res=u.bookBorrowed(21);
		System.out.println(res);*/
		/*Student student=new Student();
		student=u.validateStudent("pallavidatta123@gmail.com", "pd123");
		System.out.println(student);*/
		
		/*School school=new School(0,"National Gems Higher Secondary School","MS Calvert","nghss@gmail.com","A.K.Paul Road","Behala",700034,"Kolkata",300,"Parking Space available","nghss123","PENDING");
		boolean res=u.addSchool(school);
		System.out.println(res);*/
		
		/*School school=new School();
		school=u.validateSchool("nghss@gmail.com", "nghss123");
		System.out.println(school);*/
		
		/*List<QuestionPapers> qtnpapers=new ArrayList<QuestionPapers>();
		qtnpapers=u.getAllQuestionPapers();
		for(QuestionPapers qtnppr : qtnpapers){
			System.out.println(qtnppr);
		}*/
		
		/*List<School> centres=new ArrayList<School>();
		centres=u.allAvailableSchools();
		for(School centre : centres){
			System.out.println(centre);
		}*/
		
		/*School school=u.getExaminationCentre(2);
		System.out.println(school);*/
		
		/*boolean res=u.incrementSeatsBooked(1);
		System.out.println(res);*/
		
		/*ExamRegistry res=u.getExamInfo(1);
		System.out.println(res);*/
		
		/*School school=new School(3,"Don Bosco Park Circus", "Rev. Fr. Bikash Mondal, S.D.B","dbpc@gmail.com","23, Darga Road, Near Chittaranjan Hospital, Park Circus, Beniapukur.","Park Circus",700017,"Kolkata",300,"","dbpc123","APPROVED");
		boolean res=u.addApprovedCentre(school);
		System.out.println(res);*/
		
		/*List<Books> bookdetails=new ArrayList<Books>();
		bookdetails=u.getAllBorrowedBooks();
		for(Books book:bookdetails){
			System.out.println(book);
		}*/
		
		/*boolean res=u.deleteStudent(18);
		System.out.print(res);*/
		
		/*boolean res=u.borrowBook(3, 1);
		System.out.println(res);*/
		
		/*Books book=u.getBook(3);
		System.out.println(book);*/
		
		/*String date=u.getDueDate(4);
		System.out.println(date);*/
		
		/*boolean res=u.changeExaminationCentre(5, 7, 28);
		System.out.println(res);*/
		
		Admin admin=u.validateAdmin("rajib123", "r@J!b");
		System.out.print(admin);
	}

}
