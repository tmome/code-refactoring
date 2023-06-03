package code.refactoring._03_long_function._12_split_loop._08_shotgun_surgery._29_inline_class;

public class Shipment {

    private TrackingInformation trackingInformation;

    public Shipment(TrackingInformation trackingInformation) {
        this.trackingInformation = trackingInformation;
    }

    public TrackingInformation getTrackingInformation() {
        return trackingInformation;
    }

    public void setTrackingInformation(TrackingInformation trackingInformation) {
        this.trackingInformation = trackingInformation;
    }

    public String getTrackingInfo() {
        return this.trackingInformation.display();
    }
}
