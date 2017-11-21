package by.tc.parsing.entity;

import java.io.Serializable;

/**
 * Created by cplus on 19.11.2017.
 */
public class Flower implements Serializable {
    private static final long serialVersionUID = 6764636872685872985L;

    private String id;
    private String leavesColor;
    private String stemColor;

    private String name;
    private Soil soil;
    private String origin;
    private GrowingType growingType;
    private Multiplying multiplying;

    public Flower() {
    }

    public Flower(String id, String leavesColor, String stemColor, String name, Soil soil,
                  String origin, GrowingType growingType, Multiplying multiplying) {
        this.id = id;
        this.leavesColor = leavesColor;
        this.stemColor = stemColor;
        this.name = name;
        this.soil = soil;
        this.origin = origin;
        this.growingType = growingType;
        this.multiplying = multiplying;
    }

    public static class GrowingType {
        private String temperature;
        private boolean lighting;
        private String watering;

        public GrowingType() {
        }

        public GrowingType(String temperature, boolean lighting, String watering) {
            this.temperature = temperature;
            this.lighting = lighting;
            this.watering = watering;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public boolean isLighting() {
            return lighting;
        }

        public void setLighting(boolean lighting) {
            this.lighting = lighting;
        }

        public String getWatering() {
            return watering;
        }

        public void setWatering(String watering) {
            this.watering = watering;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            GrowingType that = (GrowingType) o;

            if (lighting != that.lighting) return false;
            if (temperature != null ? !temperature.equals(that.temperature) : that.temperature != null) return false;
            return watering != null ? watering.equals(that.watering) : that.watering == null;
        }

        @Override
        public int hashCode() {
            int result = temperature != null ? temperature.hashCode() : 0;
            result = 31 * result + (lighting ? 1 : 0);
            result = 31 * result + (watering != null ? watering.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "GrowingType{" +
                    "temperature='" + temperature + '\'' +
                    ", lighting=" + lighting +
                    ", watering='" + watering + '\'' +
                    '}';
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLeavesColor() {
        return leavesColor;
    }

    public void setLeavesColor(String leavesColor) {
        this.leavesColor = leavesColor;
    }

    public String getStemColor() {
        return stemColor;
    }

    public void setStemColor(String stemColor) {
        this.stemColor = stemColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Soil getSoil() {
        return soil;
    }

    public void setSoil(Soil soil) {
        this.soil = soil;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public GrowingType getGrowingType() {
        return growingType;
    }

    public void setGrowingType(GrowingType growingType) {
        this.growingType = growingType;
    }

    public Multiplying getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(Multiplying multiplying) {
        this.multiplying = multiplying;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flower flower = (Flower) o;

        if (id != null ? !id.equals(flower.id) : flower.id != null) return false;
        if (leavesColor != null ? !leavesColor.equals(flower.leavesColor) : flower.leavesColor != null) return false;
        if (stemColor != null ? !stemColor.equals(flower.stemColor) : flower.stemColor != null) return false;
        if (name != null ? !name.equals(flower.name) : flower.name != null) return false;
        if (soil != flower.soil) return false;
        if (origin != null ? !origin.equals(flower.origin) : flower.origin != null) return false;
        if (growingType != null ? !growingType.equals(flower.growingType) : flower.growingType != null) return false;
        return multiplying == flower.multiplying;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (leavesColor != null ? leavesColor.hashCode() : 0);
        result = 31 * result + (stemColor != null ? stemColor.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (soil != null ? soil.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (growingType != null ? growingType.hashCode() : 0);
        result = 31 * result + (multiplying != null ? multiplying.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "id='" + id + '\'' +
                ", leavesColor='" + leavesColor + '\'' +
                ", stemColor='" + stemColor + '\'' +
                ", name='" + name + '\'' +
                ", soil=" + soil +
                ", origin='" + origin + '\'' +
                ", growingType=" + growingType +
                ", multiplying=" + multiplying +
                '}';
    }
}
