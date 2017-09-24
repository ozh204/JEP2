package service;

import java.io.Serializable;
import java.util.Random;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "randomWaffle", eager = true)
@SessionScoped
public class RandomWaffle implements Serializable {

    @EJB
    WaffleManager wm;

    public long get() {

        Random randomWaffle = new Random();
        int howManyWaffles = wm.getAll().size();
        long pickedNumber = randomWaffle.nextInt(howManyWaffles) + 1;

        return pickedNumber;

    }

}