//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.08 at 03:16:55 PM KST 
//


package zero26_schema.generate;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the zero11_ZacksB_customORM package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: zero11_ZacksB_customORM
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SqlMapConfig }
     * 
     */
    public SqlMapConfig createSqlMapConfig() {
        return new SqlMapConfig();
    }

    /**
     * Create an instance of {@link SqlMapConfig.TransactionManager }
     * 
     */
    public SqlMapConfig.TransactionManager createSqlMapConfigTransactionManager() {
        return new SqlMapConfig.TransactionManager();
    }

    /**
     * Create an instance of {@link SqlMapConfig.TransactionManager.DataSource }
     * 
     */
    public SqlMapConfig.TransactionManager.DataSource createSqlMapConfigTransactionManagerDataSource() {
        return new SqlMapConfig.TransactionManager.DataSource();
    }

    /**
     * Create an instance of {@link SqlMapConfig.Properties }
     * 
     */
    public SqlMapConfig.Properties createSqlMapConfigProperties() {
        return new SqlMapConfig.Properties();
    }

    /**
     * Create an instance of {@link SqlMapConfig.Settings }
     * 
     */
    public SqlMapConfig.Settings createSqlMapConfigSettings() {
        return new SqlMapConfig.Settings();
    }

    /**
     * Create an instance of {@link SqlMapConfig.SqlMap }
     * 
     */
    public SqlMapConfig.SqlMap createSqlMapConfigSqlMap() {
        return new SqlMapConfig.SqlMap();
    }

    /**
     * Create an instance of {@link SqlMapConfig.TransactionManager.DataSource.Property }
     * 
     */
    public SqlMapConfig.TransactionManager.DataSource.Property createSqlMapConfigTransactionManagerDataSourceProperty() {
        return new SqlMapConfig.TransactionManager.DataSource.Property();
    }

}
