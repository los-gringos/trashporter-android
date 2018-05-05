package io.los.gringos.trashporter.android.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class DistanceMatrixElement {

    @SerializedName("distance")
    @Expose
    private DistanceMatrixResponse distance;
    @SerializedName("duration")
    @Expose
    private DistanceMatrixDuration duration;
    @SerializedName("status")
    @Expose
    private String status;

    public DistanceMatrixResponse getDistance() {
        return distance;
    }

    public void setDistance(DistanceMatrixResponse distance) {
        this.distance = distance;
    }

    public DistanceMatrixDuration getDuration() {
        return duration;
    }

    public void setDuration(DistanceMatrixDuration duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
