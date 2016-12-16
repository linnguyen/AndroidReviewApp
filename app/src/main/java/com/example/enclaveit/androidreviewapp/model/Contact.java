package com.example.enclaveit.androidreviewapp.model;

import java.io.Serializable;

/**
 * Created by enclaveit on 16/12/2016.
 */

public class Contact  implements Serializable {
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone =  phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
