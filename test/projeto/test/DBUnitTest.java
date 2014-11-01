package projeto.test;

import java.io.File;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import projeto.dao.CargaDao;
import projeto.util.JpaUtil;

public class DBUnitTest extends DBTestCase {

	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	private CargaDao dao;

	public DBUnitTest() {
		System.setProperty(
				PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS,
				"com.mysql.jdbc.Driver");
		System.setProperty(
				PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,
				"jdbc:mysql://localhost:3306/control_exped_db");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME,
				"root");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD,
				"1234");
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder()
				.build(new File("input/dbZerado.xml"));
	}

	@Override
	protected DatabaseOperation getSetUpOperation() throws Exception {
		return DatabaseOperation.DELETE_ALL;
	}

	public void begin() {
		JpaUtil.iniciarPersistenceUnit();
		entityManager = JpaUtil.createEntityManager();
		entityManager.getTransaction().begin();
		dao = new CargaDao(entityManager);
	}

	public void close() {
		entityManager.getTransaction().commit();
		entityManager.close();
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		dao = null;
	}

	public CargaDao getDao() {
		return dao;
	}

	// private EntityManager entityManager;
	// private EntityManagerFactory entityManagerFactory;
	// public CargaDao dao;
	//
	// public DBUnitTest() {
	// System.setProperty(
	// PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS,
	// "com.mysql.jdbc.Driver");
	// System.setProperty(
	// PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,
	// "jdbc:mysql://localhost:3306/controlexped");
	// System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME,
	// "root");
	// System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD,
	// "1234");
	// }
	//
	// @Override
	// protected IDataSet getDataSet() throws Exception {
	// return new FlatXmlDataSetBuilder().build(new FileInputStream(new File(
	// "input/dbZerado.xml")));
	// }
	//
	// @Override
	// protected DatabaseOperation getSetUpOperation() throws Exception {
	// return DatabaseOperation.DELETE_ALL;
	// }
	//
	// @Override
	// protected DatabaseOperation getTearDownOperation() throws Exception {
	// return DatabaseOperation.DELETE_ALL;
	// }
	//
	// public void begin() {
	// JpaUtil.iniciarPersistenceUnit();
	// entityManager = JpaUtil.getEntityManager();
	// entityManager.getTransaction().begin();
	// dao = new CargaDao(entityManager);
	// }
	//
	// public void close() {
	// entityManager.getTransaction().commit();
	// entityManager.close();
	// if (entityManagerFactory != null) {
	// entityManagerFactory.close();
	// dao = null;
	// JpaUtil.fecharPersistenceUnit();
	// }
	//
	// }
}
