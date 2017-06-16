/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utfpr.model;

import br.edu.utfpr.beans.Monitor;
import java.util.List;

/**
 *
 * @author popovicz
 */
public class DaoMonitor {

    private Monitor monitor;
    private Dao<Monitor> dao;

    public DaoMonitor() {
        this.dao = new Dao(Monitor.class);
        this.monitor = new Monitor();
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Dao getMonitorDao() {
        return dao;
    }

    public void setMonitorDao(Dao dao) {
        this.dao = dao;
    }

    public Monitor buscarPorId(int id) {
        return this.dao.buscaPorId(id);
    }

    public List buscarPorLogin(String login) {
        return this.dao.buscaPorLogin(login);
    }

    public List listaTodos() {
        return this.dao.listaTodos();
    }

    public void adiciona(Monitor monitor) {
        this.dao.adiciona(monitor);
    }

    public void update(Monitor monitor) {
        this.dao.update(monitor);
    }

    public void remove(Monitor monitor) {
        this.dao.remove(monitor);
    }

    public void removePorId(int id) {
        this.dao.removePorId(id);
    }
}