package msku.ceng.madlab.tarimlaapp;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Add {
    // buralarda dictionary ile fln bi şekilde halletmen lazım patates ve resim mevzusunu
    // aynı zamanda spinner için şehirleri de ayarlaman lazım

    Drawable drawable;
    public String productName;

    public String description;
    public String city;
    public String price;
    public String amount;
    public String userEmail;


    public Add(String productName, String description, String city, String price, String amount, String userEmail) {

        this.productName = productName;
        this.description = description;
        this.city = city;
        this.price = price;
        this.amount = amount;
        this.userEmail = userEmail;
    }

}
