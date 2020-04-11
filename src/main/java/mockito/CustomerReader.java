package mockito;

public class CustomerReader {
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    public String findFullName(long id){
        Custmer custmer=this.entityManager.find(Custmer.class,id);
            return custmer.fname + " " + custmer.lname;
    }
}
