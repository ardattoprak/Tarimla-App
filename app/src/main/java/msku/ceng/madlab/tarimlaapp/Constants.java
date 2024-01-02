package msku.ceng.madlab.tarimlaapp;



import static android.content.ContentValues.TAG;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;

public class Constants {


    public static ArrayList<Add> Adds = new ArrayList<>();
    public static ArrayList<UsersInfo> Users = new ArrayList<>();





    static FirebaseFirestore db ;



    public static void getUsersFromDb() {

        db.collection("Users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<UsersInfo> userTemp = new ArrayList<>();

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());

                                UsersInfo user = new UsersInfo(document.getString("name"),document.getString("lastName"),document.getString("email"),document.getString("wareHouseCapacity"),document.getString("phoneNumber"),document.getString("city"));


                                // Or if you have setter methods
                                // Add add = new Add();
                                // add.setId(document.getId());
                                // add.setSomeProperty(document.getString("someProperty"));

                                // Add the created Add object to your list or perform any other operations
                                userTemp.add(user);
                            }
                            Users = userTemp;
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
    }

    public static void setUsersToDb(UsersInfo user){
        db.collection("Users").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });

    }

    public static void getDatasFromDb() {

        db.collection("Adds")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<Add> addsTemp = new ArrayList<>();

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());

                                Add add = new Add(document.getString("productName"),document.getString("description"),document.getString("city"),document.getString("price"),document.getString("amount"),document.getString("userEmail"));
                                // Or if you have setter methods
                                // Add add = new Add();
                                // add.setId(document.getId());
                                // add.setSomeProperty(document.getString("someProperty"));

                                // Add the created Add object to your list or perform any other operations
                                addsTemp.add(add);
                            }
                            Adds = addsTemp;
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
    }


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

    public static ArrayList<String> getCitySpinnerChoices() {
        ArrayList<String> cities = new ArrayList<>();

        String city1 = "Adana";
        String city2 = "Adıyaman";
        String city3 = "Afyonkarahisar";
        String city4 = "Ağrı";
        String city5 = "Amasya";
        String city6 = "Ankara";
        String city7 = "Antalya";
        String city8 = "Artvin";
        String city9 = "Aydın";
        String city10 = "Balıkesir";
        String city11 = "Bilecik";
        String city12 = "Bingöl";
        String city13 = "Bitlis";
        String city14 = "Bolu";
        String city15 = "Burdur";
        String city16 = "Bursa";
        String city17 = "Çanakkale";
        String city18 = "Çankırı";
        String city19 = "Çorum";
        String city20 = "Denizli";
        String city21 = "Diyarbakır";
        String city22 = "Edirne";
        String city23 = "Elazığ";
        String city24 = "Erzincan";
        String city25 = "Erzurum";
        String city26 = "Eskişehir";
        String city27 = "Gaziantep";
        String city28 = "Giresun";
        String city29 = "Gümüşhane";
        String city30 = "Hakkari";
        String city31 = "Hatay";
        String city32 = "Isparta";
        String city33 = "Mersin";
        String city34 = "İstanbul";
        String city35 = "İzmir";
        String city36 = "Kars";
        String city37 = "Kastamonu";
        String city38 = "Kayseri";
        String city39 = "Kırklareli";
        String city40 = "Kırşehir";
        String city41 = "Kocaeli";
        String city42 = "Konya";
        String city43 = "Kütahya";
        String city44 = "Malatya";
        String city45 = "Manisa";
        String city46 = "Kahramanmaraş";
        String city47 = "Mardin";
        String city48 = "Muğla";
        String city49 = "Muş";
        String city50 = "Nevşehir";
        String city51 = "Niğde";
        String city52 = "Ordu";
        String city53 = "Rize";
        String city54 = "Sakarya";
        String city55 = "Samsun";
        String city56 = "Siirt";
        String city57 = "Sinop";
        String city58 = "Sivas";
        String city59 = "Tekirdağ";
        String city60 = "Tokat";
        String city61 = "Trabzon";
        String city62 = "Tunceli";
        String city63 = "Şanlıurfa";
        String city64 = "Uşak";
        String city65 = "Van";
        String city66 = "Yozgat";
        String city67 = "Zonguldak";
        String city68 = "Aksaray";
        String city69 = "Bayburt";
        String city70 = "Karaman";
        String city71 = "Kırıkkale";
        String city72 = "Batman";
        String city73 = "Şırnak";
        String city74 = "Bartın";
        String city75 = "Ardahan";
        String city76 = "Iğdır";
        String city77 = "Yalova";
        String city78 = "Karabük";
        String city79 = "Kilis";
        String city80 = "Osmaniye";
        String city81 = "Düzce";

        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        cities.add(city4);
        cities.add(city5);
        cities.add(city6);
        cities.add(city7);
        cities.add(city8);
        cities.add(city9);
        cities.add(city10);
        cities.add(city11);
        cities.add(city12);
        cities.add(city13);
        cities.add(city14);
        cities.add(city15);
        cities.add(city16);
        cities.add(city17);
        cities.add(city18);
        cities.add(city19);
        cities.add(city20);
        cities.add(city21);
        cities.add(city22);
        cities.add(city23);
        cities.add(city24);
        cities.add(city25);
        cities.add(city26);
        cities.add(city27);
        cities.add(city28);
        cities.add(city29);
        cities.add(city30);
        cities.add(city31);
        cities.add(city32);
        cities.add(city33);
        cities.add(city34);
        cities.add(city35);
        cities.add(city36);
        cities.add(city37);
        cities.add(city38);
        cities.add(city39);
        cities.add(city40);
        cities.add(city41);
        cities.add(city42);
        cities.add(city43);
        cities.add(city44);
        cities.add(city45);
        cities.add(city46);
        cities.add(city47);
        cities.add(city48);
        cities.add(city49);
        cities.add(city50);
        cities.add(city51);
        cities.add(city52);
        cities.add(city53);
        cities.add(city54);
        cities.add(city55);
        cities.add(city56);
        cities.add(city57);
        cities.add(city58);
        cities.add(city59);
        cities.add(city60);
        cities.add(city61);
        cities.add(city62);
        cities.add(city63);
        cities.add(city64);
        cities.add(city65);
        cities.add(city66);
        cities.add(city67);
        cities.add(city68);
        cities.add(city69);
        cities.add(city70);
        cities.add(city71);
        cities.add(city72);
        cities.add(city73);
        cities.add(city74);
        cities.add(city75);
        cities.add(city76);
        cities.add(city77);
        cities.add(city78);
        cities.add(city79);
        cities.add(city80);
        cities.add(city81);

        return cities;
    }

}
