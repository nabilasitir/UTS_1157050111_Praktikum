package com.nabilasitir.uts_1157050111;

import com.google.gson.annotations.SerializedName;

public class Buah {
    @SerializedName("id") private int Id;
    @SerializedName("name") private String Name;
    @SerializedName("price") private String Price;
    @SerializedName("image") private String Image;
    @SerializedName("detail") private String Detail;

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getPrice() {
        return Price;
    }

    public String getImage() {
        return Image;
    }

    public String getDetail() {
        return Detail;
    }


}
