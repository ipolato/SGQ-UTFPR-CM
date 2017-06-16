/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utfpr.model;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

public class CreateBD {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SGQ");
        EntityManager em = emf.createEntityManager();
        em.close();
        emf.close();

    }
}
