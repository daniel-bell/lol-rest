package com.danbell.lol_rest;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class LolRestBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(new AccountDatabase()).to(AccountDatabase.class);
    }
}