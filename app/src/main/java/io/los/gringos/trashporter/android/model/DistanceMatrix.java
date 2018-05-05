package io.los.gringos.trashporter.android.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DistanceMatrix {

    @SerializedName("destination_addresses")
    @Expose
    private List<String> destinationAddresses = null;

    @SerializedName("origin_addresses")
    @Expose
    private List<String> originAddresses = null;

    @SerializedName("rows")
    @Expose
    private List<DistanceMatrixRow> rows = null;

    @SerializedName("status")
    @Expose
    private String status;

    public List<String> getDestinationAddresses() {
        return destinationAddresses;
    }

    public void setDestinationAddresses(List<String> destinationAddresses) {
        this.destinationAddresses = destinationAddresses;
    }

    public List<String> getOriginAddresses() {
        return originAddresses;
    }

    public void setOriginAddresses(List<String> originAddresses) {
        this.originAddresses = originAddresses;
    }

    public List<DistanceMatrixRow> getRows() {
        return rows;
    }

    public void setRows(List<DistanceMatrixRow> rows) {
        this.rows = rows;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDistanceText(){
        return rows.get(0).getElements().get(0).getDistance().getText();
    }
}
