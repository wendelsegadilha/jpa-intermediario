import dominio.Acessorio;
import dominio.Proprietario;
import dominio.TipoCombustivel;
import dominio.Veiculo;
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
        proprietario.getTelefones().add("(98) 98600-3186");
        proprietario.getTelefones().add("(98) 98531-4010");
        manager.persist(proprietario);

        tx.commit();

        manager.close();
        JpaUtil.close();
    }
}