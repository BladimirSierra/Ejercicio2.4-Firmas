package com.example.ejercicio24_firmas;

public class firmas {

    private Integer id;
    private byte[] image;
    private String descripcion;

    public firmas(Integer id, byte[] image, String descripcion) {
        this.id = id;
        this.image = image;
        this.descripcion = descripcion;
    }

    public firmas() {

    }

    public Integer getId() {
        return id;
    }
    public byte[] getImage() {
        return image;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
