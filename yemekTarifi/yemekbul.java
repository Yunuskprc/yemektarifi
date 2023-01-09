import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class yemekbul {
    static String[] yemekAd = { "arap_tava", "bamya", "barbunya_yemegi", "besamel_soslu_musakka", "bezelye_yemegi",
            "bulgur_pilavi", "etli_nohut", "firinda_kabak_mucver", "firinda_kiymali_tava", "firinda_makarna",
            "fırında_patates", "garnitur_makarna", "imam_bayildi", "kabak_dolmasi", "karnabahar_graten",
            "karnabahar_yemegi", "kiymali_makarna", "kremali_domatesli_makarna", "kuru_fasulye", "lazanya",
            "mantar_sote", "patlican_kebabi", "pilav", "pirasa_yemegi", "pureli_tepsi_kebabi", "taze_fasulye_yemegi",
            "yelpaze_patates" };

    public void ybul() {
        Connection conn;
        Statement st;
        ResultSet rs;
        int sayac=0;
        int sayacsorgu[]=new int[20];
        int say=0;


        System.out.println("\n-Yapabileceğiniz Yemekler-");
        
        for(int i=0;i<27;i++)
        {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yemektarifleri", "root", "Unutma23.");
                st = conn.createStatement();
                rs = st.executeQuery("select *from "+yemekAd[i]+" ORDER BY id ASC");

                while(rs.next())
                {
                    say=Integer.parseInt(rs.getString("id"));
                }
                rs.close();


                rs = st.executeQuery("select *from " + yemekAd[i]);
                while (rs.next()) {
                    for(int j=0;j<20;j++)
                    {
                        if(Main.malzemeler[j].equals(rs.getString("malzeme")))
                        {
                            sayac++;
                        }    
                    }
                }


               if(sayac>=say)
               {
                    System.out.println(yemekAd[i]);
               }
                
                sayac=0;
                conn.close();
                st.close();
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }  
        }
        

    }
}
