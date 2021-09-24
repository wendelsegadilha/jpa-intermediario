import dominio.*;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Persistir {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEtityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        Proprietario proprietario = new Proprietario();
        proprietario.setNome("Anny Marcielly");
        proprietario.setEmail("consultoria_anny@gmail.com");
        proprietario.getTelefones().add(new Telefone("98", "986003186", "104"));
        proprietario.getTelefones().add(new Telefone("98", "981345267",null));
        manager.persist(proprietario);

        tx.commit();

        manager.close();
        JpaUtil.close();
    }
}