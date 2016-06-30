package calculator.servlet;

import junit.framework.Assert;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.*;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import calculator.servlet.Requete;
import calculator.servlet.RequeteDAO;

import java.util.List;


public class RequeteDAOTest extends DBTestCase
{
    private String driver = "org.hsqldb.jdbcDriver";
    private String url = "jdbc:hsqldb:mem";
    private String login = "sa";
    private String mdp = "";
    private static Boolean uneSeuleFois = true;
    RequeteDAO dao;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        dao = new RequeteDAO(driver, url, login, mdp);                
    }

    public RequeteDAOTest(String name) throws Exception
    {
        super( name );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, driver);
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, url);
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, login );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, mdp );

        if (uneSeuleFois) {
            uneSeuleFois = false;
            String r = "CREATE TABLE tblLog (ID int, ip char(50), duree int, " +
                        "parama int, paramb int, resultat int, PRIMARY KEY (ID))";
            getConnection().getConnection().createStatement().execute(r);
        }
    }

    @Override
    protected IDataSet getDataSet() throws Exception
    {
        return new FlatXmlDataSetBuilder().build(
                    this.getClass().getResourceAsStream("/RequeteDAOTest_getDataSet.xml"));
    }

    @Override
    protected DatabaseOperation getSetUpOperation() throws Exception
    {
        return DatabaseOperation.CLEAN_INSERT;
    }

    @Override
        protected DatabaseOperation getTearDownOperation() throws Exception
    {
        return DatabaseOperation.NONE;
    }

    public void testLireRequetes() throws Exception {
        List<Requete> liste = dao.lireRequetes();
        Assert.assertEquals(1, liste.size());
        Requete req = liste.get(0);

        assertTrue(req.getID().equals(0));
        assertTrue(req.getAdresseIp().equals("192.168.1.10"));
        assertTrue(req.getDuree().equals(1000));
        assertTrue(req.getParama().equals(new Long(7)));
        assertTrue(req.getParamb().equals(new Long(3)));
        assertTrue(req.getResultat().equals(new Long(1))); 
    }

    public void testAjouterDonnees() throws Exception {
       Requete req = new Requete();
       req.setID(1);
       req.setAdresseIp("10.0.0.10");
       req.setDuree(10);
       req.setParama(new Long(1));
       req.setParamb(new Long(2));
       req.setResultat(new Long(3));

       dao.ajouterRequete(req);
       IDataSet referenceDataSet = new FlatXmlDataSetBuilder().build(
           this.getClass().getResourceAsStream("/RequeteDAOTest_testAjouterDonnees.xml"));

       IDataSet resultatDataSet = getConnection().createDataSet();
       Assertion.assertEquals(referenceDataSet, resultatDataSet);

       ITable referenceDataSetTable = referenceDataSet.getTable("tblLog");
       ITable resultatTable = resultatDataSet.getTable("tblLog");
       Assertion.assertEquals(referenceDataSetTable, resultatTable);

   }    
}

