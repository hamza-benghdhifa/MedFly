/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.util.List;

/**
 *
 * @author 21653
 */
public interface IService <T> {
    public void ajouter(T t);
    public void modifier(T t);
    public void supprimer(int id);
    public T getOnebyid(int id);
    public List<T> getAll();
    
}


