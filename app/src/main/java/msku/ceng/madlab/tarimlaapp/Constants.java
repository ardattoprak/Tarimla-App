package msku.ceng.madlab.tarimlaapp;



import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static ArrayList<String> getProductSpinnerChoises(){
        ArrayList<String> products  = new ArrayList<>();

        String product1 = "Tomato";
        String product2 = "Onion";
        String product3 = "Milk";
        String product4 = "Potatoes";
        String product5 = "Apple";


        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        return products;
    }

    public static ArrayList<String> getCitySpinnerChoises(){
        ArrayList<String> cities  = new ArrayList<>();

        String city1 = "Adana";
        String city2 = "Adıyaman";
        String city3 = "Afyonkarahisar";
        String city4 = "Ağrı";
        String city5 = "Amasya";


        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        cities.add(city4);
        cities.add(city5);

        return cities;
    }






    public static ArrayList<Add> getAddsData(){

        ArrayList<Add> addList  = new ArrayList<>();

        Drawable drawable1 = null;

        Add add1 = new Add( "patates", "Patates satışta", "Edirne", "2000" , "1" , "email1");
        Add add2 = new Add("domates", "Domates satışta", "İstanbul", "10" ,"2", "email2");

        addList.add(add1);
        addList.add(add2);

        return addList;
    }
}
