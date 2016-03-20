package entities;

import enums.ClientSortParams;

import java.util.*;

/**
 * The class {@code ClientStorage}
 * for storing a multiplicity of clients ({@code Client} class)
 * Created by Evgeny on 14.03.2016.
 */
public class ClientStorage {
    private List<Client> clients = new ArrayList<Client>();
    private int currentClientID = 0;

    public void addClient(String firstName, String lastName, String middleName, int year) {
        clients.add(new Client (currentClientID++, firstName, lastName, middleName, year));
    }

    /**
     * use only for create additional ClientStorages when search
     * @param c
     */
    public void addClient(Client c) {
        clients.add(new Client (c.getID(), c.getfirstName(), c.getlastName(), c.getmiddleName(), c.getYear()));
        currentClientID++;
    }

    public void sort(ClientSortParams.ClientComparator comp) {
        Collections.sort(clients, ClientSortParams.ClientComparator.getComparator(comp));
    }

    public ClientStorage search(HashMap<String, String> params) {
        ClientStorage findedClients = clone();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            findedClients = search(findedClients, entry.getKey(), entry.getValue());
        }
        return findedClients;
    }

    public ClientStorage search(ClientStorage ls, String param, String value) {
        ClientStorage findedClients = new ClientStorage();
        switch (param) {
            case "firstname":
                for (int i=0; i<ls.getSize(); i++) {
                    if (value.equalsIgnoreCase(ls.getByIndex(i).getfirstName())) {
                        findedClients.addClient(ls.getByIndex(i));
                    }
                }
                break;

            case "lastname":
                for (int i=0; i<ls.getSize(); i++) {
                    if (value.equalsIgnoreCase(ls.getByIndex(i).getlastName())) {
                        findedClients.addClient(ls.getByIndex(i));
                    }
                }
                break;

            case "middlename":
                for (int i=0; i<ls.getSize(); i++) {
                    if (value.equalsIgnoreCase(ls.getByIndex(i).getmiddleName())) {
                        findedClients.addClient(ls.getByIndex(i));
                    }
                }
                break;

            case "year":
                for (int i=0; i<ls.getSize(); i++) {
                    if (value.equalsIgnoreCase(String.valueOf(ls.getByIndex(i).getYear()))) {
                        findedClients.addClient(ls.getByIndex(i));
                    }
                }
                break;

            case "id":
                for (int i=0; i<ls.getSize(); i++) {
                    if (value.equalsIgnoreCase(String.valueOf(ls.getByIndex(i).getID()))) {
                        findedClients.addClient(ls.getByIndex(i));
                    }
                }
                break;

            default:
                findedClients = ls;
        }
        return findedClients;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Client client : clients) {
            str.append(client.toString()).append("\n");
        }
        return str.toString();
    }

    @Override
    public ClientStorage clone() {
        ClientStorage cls = new ClientStorage();
        for (Client client : clients) {
            cls.addClient(client.clone());
        }
        return cls;
    }

    public int getSize() {
        return clients.size();
    }

    public Client getByIndex(int ind) {
        return clients.get(ind).clone();
    }

    public Client getByID(int id) {
        for (Client client : clients) {
            if (client.getID() == id) {
                return client.clone();
            }
        }
        return null;
    }

    public boolean containsID(int id) {
        for (Client client : clients) {
            if (client.getID() == id) {
                return true;
            }
        }
        return false;
    }
}
