package org.example;

public class Politica {
    private int id;
    private int ano;
    private String partido;
    private double gastos;
    private int votos;
    private String cargo;
    private String estado;

    public Politica(int id, int ano, String partido, double gastos, int votos, String cargo, String estado) {
        this.id = id;
        this.ano = ano;
        this.partido = partido;
        this.gastos = gastos;
        this.votos = votos;
        this.cargo = cargo;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return String.format("%-5d%-10d%-20s%-15.2f%-10d%-15s%-15s", id, ano, partido, gastos, votos, cargo, estado);
    }
}
