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

    public Add(Drawable drawable, String productName, String description, String city, String price) {
        this.drawable = drawable;
        this.productName = productName;
        this.description = description;
        this.city = city;
        this.price = price;
    }

}
