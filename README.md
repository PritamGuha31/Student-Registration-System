# Student Registration System
 This is a website built using JEE7 and JSP with MySQL as database. The application was built using Eclipse and was hosted on Apache Tomacat. This website serves the purpose of an examination registration portal where students can register themselves for an examination and also find resources required for the examination to be borrowed in an online library kind of operation. I built this web application along with a couple of my classmates as part of my final year college project during my undergraduate days.
<br><br>
<b>The system used eight tables in the database: </b><br>
i. Admin: This table stores all admin-related login details.<br>
ii. Approved Centres: This table stores details about all the examination centres which are approved to conduct examinations.<br>
iii. Books: This table stores details about the books available in the online library facility offered by the application.<br>
iv. Exam Centre: This table stores details about examination centres which registered themselves in the application for approval.<br>
v. Exam Registry: This table stores details about past academic records of students.<br>
vi. Library Register: This table stores details about the daily transactions taking place in the online library.<br>
vii. Question Papers: This table stores details about past question papers which are available in the application.<br>
viii. Student: This table stores basic details and information about a student.<br>
<br> <b> The list of columns used for the above tables are given as: </b> <br>
<b> 1. Admin </b> <br>
<table>
 <tr>
    <th> Field </th>
    <th> Type </th>
    <th> Key </th>
    <th> Default </th>
    <th> Extra </th>
 </tr>
 <tr>
  <td> adminid </td>
  <td> varchar(30) </td>
  <td> Primary </td>
  <td> Null </td>
  <td> </td>
 </tr>
 <tr>
  <td> adminpass  </td>
  <td> varchar(30) </td>
  <td> </td>
  <td> Null </td>
  <td> </td>
 </tr>
</table>
<br>
<b> 2. Approved Centres </b> <br>
<table>
 <tr>
    <th> Field </th>
    <th> Type </th>
    <th> Key </th>
    <th> Default </th>
    <th> Extra </th>
 </tr>
 <tr>
  <td> acid </td>
  <td> int(11) </td>
  <td> Primary </td>
  <td> Null </td>
  <td> Auto_increment </td>
 </tr>
 <tr>
  <td> schoolid </td>
  <td> int(11) </td>
  <td> Foreign </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> locality </td>
  <td> varchar(50) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> totalseats </td>
  <td> int(11) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> seatsbooked </td>
  <td> int(11) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
</table>
<br>
<b> 3. Books </b> <br>
<table>
 <tr>
    <th> Field </th>
    <th> Type </th>
    <th> Key </th>
    <th> Default </th>
    <th> Extra </th>
 </tr>
 <tr>
  <td> book_id </td>
  <td> int(7) </td>
  <td> Primary </td>
  <td> Null </td>
  <td> Auto_increment </td>
 </tr>
 <tr>
  <td> book_name </td>
  <td> varchar(50) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> author </td>
  <td> varchar(30) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> subject </td>
  <td> varchar(30) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> path </td>
  <td> varchar(200) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> availability </td>
  <td> varchar(10) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
</table>
<br>
<b> 4. Exam Centre </b><br>
<table>
 <tr>
    <th> Field </th>
    <th> Type </th>
    <th> Key </th>
    <th> Default </th>
    <th> Extra </th>
 </tr>
 <tr>
  <td> schoolid </td>
  <td> int(11) </td>
  <td> Primary </td>
  <td> Null </td>
  <td> Auto_increment </td>
 </tr>
 <tr>
  <td> name </td>
  <td> varchar(50) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> principal </td>
  <td> varchar(30) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> email </td>
  <td> varchar(50) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> address </td>
  <td> varchar(200) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> locality </td>
  <td> varchar(20) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> pin </td>
  <td> int(11) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> city </td>
  <td> varchar(20) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> seats </td>
  <td> int(11) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> details </td>
  <td> varchar(200) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> password </td>
  <td> varchar(50) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> status </td>
  <td> varchar(10) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 </table>
 <br>
 <b> 5. Exam Registry </b><br>
 <table>
 <tr>
    <th> Field </th>
    <th> Type </th>
    <th> Key </th>
    <th> Default </th>
    <th> Extra </th>
 </tr>
 <tr>
  <td> eid </td>
  <td> int(11) </td>
  <td> Primary </td>
  <td> Null </td>
  <td> Auto_increment </td>
 </tr>
 <tr>
  <td> roll </td>
  <td> int(11) </td>
  <td>  Foreign </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> tenboard </td>
  <td> varchar(100) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> tenyear </td>
  <td> int(11) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> tenmarks </td>
  <td> varchar(10) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> twelveboard </td>
  <td> varchar(100) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> twelveyear </td>
  <td> int(11) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> twelvemarks </td>
  <td> varchar(10) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> schoolid </td>
  <td> int(11) </td>
  <td> Foreign </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 </table>
<br>
<b> 6. Library Register </b> <br>
 <table>
 <tr>
    <th> Field </th>
    <th> Type </th>
    <th> Key </th>
    <th> Default </th>
    <th> Extra </th>
 </tr>
 <tr>
  <td> rid </td>
  <td> int(6) </td>
  <td> Primary </td>
  <td> Null </td>
  <td> Auto_increment </td>
 </tr>
 <tr>
  <td> roll </td>
  <td> int(6) </td>
  <td> Foreign </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> book_id </td>
  <td> int(6) </td>
  <td> Foreign </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> borrow_date </td>
  <td> date </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> due_date </td>
  <td> date </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 </table>
<br>
<b> 7. Question Papers </b> <br>
<table>
 <tr>
    <th> Field </th>
    <th> Type </th>
    <th> Key </th>
    <th> Default </th>
    <th> Extra </th>
 </tr>
 <tr>
  <td> id </td>
  <td> int(11) </td>
  <td> Primary </td>
  <td> Null </td>
  <td> Auto_increment </td>
 </tr>
 <tr>
  <td> title </td>
  <td> varchar(30) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> description </td>
  <td> varchar(200) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> file </td>
  <td> mediumblob </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> type </td>
  <td> varchar(20) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 </table>
 <br>
 <b> 8. Student </b><br>
 <table>
 <tr>
    <th> Field </th>
    <th> Type </th>
    <th> Key </th>
    <th> Default </th>
    <th> Extra </th>
 </tr>
 <tr>
  <td> roll </td>
  <td> int(11) </td>
  <td> Primary </td>
  <td> Null </td>
  <td> Auto_increment </td>
 </tr>
 <tr>
  <td> cname </td>
  <td> varchar(20) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> fname </td>
  <td> varchar(20) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> mname </td>
  <td> varchar(20) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> dob </td>
  <td> date </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> gender </td>
  <td> varchar(10) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> category </td>
  <td> varchar(10) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> nation </td>
  <td> varchar(20) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> aif </td>
  <td> bigint(20) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> caddress </td>
  <td> varchar(200) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> district </td>
  <td> varchar(20) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> state </td>
  <td> varchar(20) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> cemail </td>
  <td> varchar(100) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> cphone </td>
  <td> bigint(20) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> caadhar</td>
  <td> bigint(20) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> cpass </td>
  <td> varchar(20) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> secqtn </td>
  <td> varchar(100) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> secans </td>
  <td> varchar(15) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> bookidborrowed </td>
  <td> int(7) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 <tr>
  <td> picture </td>
  <td> varchar(200) </td>
  <td>  </td>
  <td> Null </td>
  <td>  </td>
 </tr>
 </table>
