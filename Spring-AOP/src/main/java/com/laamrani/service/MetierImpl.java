package com.laamrani.service;

import com.laamrani.aspects.Loggable;
import com.laamrani.aspects.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {

    @Override
    @Loggable
    @SecuredByAspect(roles = {"ADMIN", "USER"})

    public void process() {
        System.out.println("Business Process");
    }
    @Override
    @SecuredByAspect(roles = {"ADMIN"})
    public double compute() {
        double value = 12;
        System.out.println("Business Compute and return ");
        return value;
    }
}
