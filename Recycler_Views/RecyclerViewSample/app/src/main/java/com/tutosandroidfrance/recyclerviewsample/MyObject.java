package com.tutosandroidfrance.recyclerviewsample;

/**
 * Created by merlinngouagna on 01/05/16.
 */
public class MyObject {
    private String text;
    private String imageUrl;
    private boolean isVisible=true;

    public MyObject(String text, String imageUrl) {
        this.text = text;
        this.imageUrl = imageUrl;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof MyObject)) {
            return false;
        }

        if (this.text!= null && this.text.equals(((MyObject)obj).getText())){
           return true;
        }
        return false;
    }
}
