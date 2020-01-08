package com.example.servingwebcontent;

public class Overview {
    String handlebar;
    String gear;
    String material;
    String grip;

    public void setGrip(String grip) {
        this.grip = grip;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public void setHandlebar(String handlebar) {
        this.handlebar = handlebar;
    }

    public String getMaterial() {
        return material;
    }

    public String getGrip() {
        return grip;
    }

    public String getGear() {
        return gear;
    }

    public String getHandlebar() {
        return handlebar;
    }

}
