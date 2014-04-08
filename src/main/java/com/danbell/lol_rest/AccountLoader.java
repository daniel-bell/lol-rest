package com.danbell.lol_rest;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * AccountLoader Class
 */

public class AccountLoader {
    private ArrayList<LolAccount> accounts;

    public AccountLoader() {
        accounts = new ArrayList<LolAccount>();
        accounts = readConfig("accounts.xml");
    }

    public ArrayList<LolAccount> readConfig(String path) {
        ArrayList<LolAccount> configAccounts = new ArrayList<LolAccount>();

        try {
            // Setup XML reader for file in path
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            InputStream in = new FileInputStream(path);
            XMLEventReader er = inputFactory.createXMLEventReader(in);

            while (er.hasNext()) {
                XMLEvent event = er.nextEvent();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        return configAccounts;
    }
}