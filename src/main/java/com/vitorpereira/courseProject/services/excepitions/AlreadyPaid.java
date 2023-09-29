package com.vitorpereira.courseProject.services.excepitions;

public class AlreadyPaid extends RuntimeException{

    public AlreadyPaid(Object id){
        super("Order with id " + id + " is already paid");
    }
}
