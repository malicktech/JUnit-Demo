package com.agilidee.livrejunit.servlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RequeteDAO {
    Connection con = null;

    public RequeteDAO(String driver, String url, String login, String mdp) throws Exception {
        Class.forName(driver).newInstance();
        con = DriverManager.getConnection(url, login, mdp);
    }

    void ajouterRequete(Requete r) throws Exception {
       String requete = "INSERT INTO tblLog values(";
        requete += r.getID().toString() + ", ";
        requete += "'" + r.getAdresseIp() + "', ";
        requete += r.getDuree().toString() + ", ";
        requete += r.getParama().toString() + ", ";
        requete += r.getParamb().toString() + ", ";
        requete += r.getResultat().toString() + ")";
        con.createStatement().executeQuery(requete);
    }

    List<Requete> lireRequetes() throws Exception {
        Statement select = con.createStatement();
        ResultSet result = select.executeQuery("SELECT ID, ip, duree, parama, paramb, resultat FROM tblLog");

        List<Requete> liste = new ArrayList<Requete>();
        while (result.next()) {
            Requete r = new Requete();
            r.setID(result.getInt(1));
            r.setAdresseIp(result.getString(2));
            r.setDuree(result.getInt(3));
            r.setParama(result.getLong(4));
            r.setParamb(result.getLong(5));
            r.setResultat(result.getLong(6));
            liste.add(r);
        }
        return liste;
    }
}
