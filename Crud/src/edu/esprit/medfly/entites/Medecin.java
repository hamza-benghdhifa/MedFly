/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.medfly.entites;
import edu.esprit.medfly.services.ServiceMedecin;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hamza
 */
public class Medecin {

 
    private int id;
    private String name;
    private String prenom;
    private String specialite;
    private String pays;
    private Date grad_date ;
    private int grad_num;

   

  
    public Medecin() { 
    }

    public Medecin(int id,String name, String prenom, String specialite, String pays, Date grad_date,int grad_num) {
        this.id = id;
        this.name = name;
        this.prenom = prenom;
        this.specialite = specialite;
        this.pays = pays;
        this.grad_date = grad_date;
        this.grad_num = grad_num;
    }

    public Medecin(String name, String prenom, String specialite, String pays, Date grad_date, int grad_num) {
        this.name = name;
        this.prenom = prenom;
        this.specialite = specialite;
        this.pays = pays;
        this.grad_date = grad_date;
        this.grad_num = grad_num;
    }

    public Medecin(String name, String prenom, String specialite, String pays, int grad_num) {
        this.name = name;
        this.prenom = prenom;
        this.specialite = specialite;
        this.pays = pays;
        this.grad_num = grad_num;
    }


    @Override
    public String toString() {
        return "Medecin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prenom='" + prenom + '\'' +
                ", specialite='" + specialite + '\'' +
                ", pays='" + pays + '\'' +
                ", grad_date=" + grad_date +
                ", grad_num=" + grad_num +
                '}';
    }

    
   
    public void setName(String name) { this.name = name; }
    
    public String getName() {return name;}

    public void setGrad_num(int grad_num) {this.grad_num = grad_num; }

    public int getGrad_num() { return grad_num;}

    public void setPrenom(String prenom) {this.prenom = prenom;}

    public void setSpecialite(String specialite) {this.specialite = specialite; }

    public void setPays(String pays) {this.pays = pays;}

    public void setGrad_date(Date grad_date) {this.grad_date = grad_date;}

    public String getPrenom() {return prenom;}

    public String getSpecialite() {return specialite;}

    public String getPays() {return pays;}

    public Date getGrad_date() {return grad_date;}
    
    public int getId() {return id; }


}

   
