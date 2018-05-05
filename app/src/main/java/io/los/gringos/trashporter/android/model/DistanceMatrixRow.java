package io.los.gringos.trashporter.android.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class DistanceMatrixRow {
    @SerializedName("elements")
    @Expose
    private List<DistanceMatrixElement> elements = null;

    public List<DistanceMatrixElement> getElements() {
        return elements;
    }

    public void setElements(List<DistanceMatrixElement> elements) {
        this.elements = elements;
    }
}
