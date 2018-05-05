package io.los.gringos.trashporter.android.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class DistanceMatrixDuration {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("value")
    @Expose
    private Integer value;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
