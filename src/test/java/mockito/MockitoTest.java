package mockito;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoTest {
    @Mock
    MyDataBase databaseMock;

    @Rule
    public MockitoRule mockitoRule= MockitoJUnit.rule();

    @Test
    public void testQuery(){
        ClassToTest t=new ClassToTest(databaseMock);
        when(databaseMock.query("* from t")).thenReturn(true);
        boolean check=t.query("* from t");
        Assert.assertTrue(check);
    }
    @Test
    public void customerReaderTest(){
        Custmer sampleCustomer=new Custmer("Shital","Sonwane");

        EntityManager entityManager = mock(EntityManager.class);
        when(entityManager.find(Custmer.class,1L)).thenReturn(sampleCustomer);

        CustomerReader customerReader=new CustomerReader();
        customerReader.setEntityManager(entityManager);

        String fullName=customerReader.findFullName(1L);
        Assert.assertEquals("Shital Sonwane",fullName);
    }

}
