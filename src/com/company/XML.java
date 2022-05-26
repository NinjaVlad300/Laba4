package com.company;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class XML {
    public ArrayList<Reactors> XML(String s) {
        ArrayList<Reactors> reactorsList = new ArrayList();
        Reactors reactor = null;
        try {
            XMLEventReader reader = XMLInputFactory.newInstance().createXMLEventReader(new FileInputStream(s));

            while (reader.hasNext()) {
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement start = xmlEvent.asStartElement();
                    if (start.getName().getLocalPart().equals("TYPE")) {
                        reactor = new Reactors();
                    }
                    if (start.getName().getLocalPart().equals("class")) {
                        xmlEvent = reader.nextEvent();
                        reactor.setName(xmlEvent.asCharacters().getData());
                    } else if (start.getName().getLocalPart().equals("burnup")) {
                        xmlEvent = reader.nextEvent();
                        reactor.setBurnup(Double.parseDouble(xmlEvent.asCharacters().getData()));
                    } else if (start.getName().getLocalPart().equals("kpd")) {
                        xmlEvent = reader.nextEvent();
                        reactor.setKpd(Double.parseDouble(xmlEvent.asCharacters().getData()));
                    } else if (start.getName().getLocalPart().equals("enrichment")) {
                        xmlEvent = reader.nextEvent();
                        reactor.setEnrichment(Double.parseDouble(xmlEvent.asCharacters().getData()));
                    } else if (start.getName().getLocalPart().equals("termal_capacity")) {
                        xmlEvent = reader.nextEvent();
                        reactor.setTermal_capacity(Double.parseDouble(xmlEvent.asCharacters().getData()));
                    } else if (start.getName().getLocalPart().equals("electrical_capacity")) {
                        xmlEvent = reader.nextEvent();
                        reactor.setElectrical_capacity(Double.parseDouble(xmlEvent.asCharacters().getData()));
                    } else if (start.getName().getLocalPart().equals("life_time")) {
                        xmlEvent = reader.nextEvent();
                        reactor.setLife_time(Double.parseDouble(xmlEvent.asCharacters().getData()));
                    } else if (start.getName().getLocalPart().equals("first_load")) {
                        xmlEvent = reader.nextEvent();
                        reactor.setFirst_load(Double.parseDouble(xmlEvent.asCharacters().getData()));
                        reactor.setSource("XML");
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("TYPE")) {
                        reactorsList.add(reactor);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }

        return reactorsList;
    }
}

