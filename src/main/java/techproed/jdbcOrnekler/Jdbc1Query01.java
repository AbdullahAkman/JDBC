package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 
 

public class Jdbc1Query01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 1) ilgili driver'ı yuklemeliyiz. tv'nin fisini tak, mesela baska alet calismasın,ne calısacagını bilsin
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 
		 // 2) Baglantı olusturmaliyiz (uydu sifrelerini girmek gibi )
		 
		 Connection con  =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "mysql123456");
			 
		 // 3) SQL komutlari icin bir Statement listesi olustur. alan olusturmak  (her kanal icin kumanda da sayi ayarlamak gibi)
		 
		 Statement st= con.createStatement();
		
		// SQL ifadeleri yazabilir ve calistirabiliriz. (yani kumanda da 1 e basarım istedigim kanal gelir)
		 
		   ResultSet veri = st.executeQuery( "SELECT isim, maas FROM personel WHERE id=123456789");
		 
		 // 5) Sonuclari aldik ve isledik
		   
		   while(veri.next()) {
			   System.out.println(veri.getString("isim") + veri.getInt("maas"));
			   System.out.println("Personel Adi : " + veri.getString(1)+ "--> Maas : " + veri.getInt(2));
		   }
		   
		   // 6) Olusturulan nesneleri bellekten kaldıralim 
		   
		   con.close(); // baglantıyı kapattık
		   st.close(); // alanı kapatmis olduk
		   veri.close();  // bu satıla mysql ile veri getirmeyi kapatmıs olduk
		 
		
		

	}

}
