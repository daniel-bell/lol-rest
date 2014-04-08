package com.danbell.lol_rest;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

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

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    if (startElement.getName().getLocalPart().equals("account")) {
                        Attribute username = startElement.getAttributeByName(new QName("username"));
                        Attribute password = startElement.getAttributeByName(new QName("password"));
                        Attribute region = startElement.getAttributeByName(new QName("region"));

                        if (!(username == null || password == null || region == null)) {
                            LolAccount account = new LolAccount(username.getValue(), password.getValue(), region.getValue());
                            configAccounts.add(account);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        return configAccounts;
    }
}