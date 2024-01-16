package msku.ceng.madlab.tarimlaapp;

import static android.content.ContentValues.TAG;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
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
                        //..
                        Constants.getUsersFromDb();
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
        ArrayList<String> products = new ArrayList<>();

        String[] productNames = {
                "Tomato", "Onion", "Milk", "Potatoes", "Apple",
                "Barley",
                "Pepper",
                "Wheat",
                "Orange",
                "Egg",
                "Olive"};

        for (String productName : productNames) {
            products.add(productName);
        }
        return products;
    }
    public static ArrayList<String> getCitySpinnerChoices() {
        ArrayList<String> cities = new ArrayList<>();

        String[] cityNames = {
                "Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Amasya",
                "Ankara", "Antalya", "Artvin", "Aydın", "Balıkesir",
                "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur",
                "Bursa", "Çanakkale", "Çankırı", "Çorum", "Denizli",
                "Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum",
                "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkari",
                "Hatay", "Isparta", "Mersin", "İstanbul", "İzmir",
                "Kars", "Kastamonu", "Kayseri", "Kırklareli", "Kırşehir",
                "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa",
                "Kahramanmaraş", "Mardin", "Muğla", "Muş", "Nevşehir",
                "Niğde", "Ordu", "Rize", "Sakarya", "Samsun",
                "Siirt", "Sinop", "Sivas", "Tekirdağ", "Tokat",
                "Trabzon", "Tunceli", "Şanlıurfa", "Uşak", "Van",
                "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman",
                "Kırıkkale", "Batman", "Şırnak", "Bartın", "Ardahan",
                "Iğdır", "Yalova", "Karabük", "Kilis", "Osmaniye",
                "Düzce"
        };

        for (String cityName : cityNames) {
            cities.add(cityName);
        }
        return cities;
    }
    public static int getImageId(Add add){
        String name = add.productName;
        switch(name) {
            case "Tomato":
                return R.mipmap.domates;

            case "Onion":
                return R.mipmap.onion;

            case "Milk":
                return R.mipmap.milk;

            case "Potatoes":
                return R.mipmap.potatoes;

            case "Apple":
                return R.mipmap.apple;

            case "Barley":
                return R.mipmap.barley;

            case "Pepper":
                return R.mipmap.pepper;

            case "Wheat":
                return R.mipmap.wheat;

            case "Orange":
                return R.mipmap.orange;

            case "Egg":
                return R.mipmap.egg;

            case "Olive":
                return R.mipmap.olive;
            default:
                return R.mipmap.tarimla_icon;
        }
    }
}
