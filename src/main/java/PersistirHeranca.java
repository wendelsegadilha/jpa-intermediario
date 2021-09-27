import dominio.Cliente;
import dominio.Funcionario;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;

public class PersistirHeranca {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEtityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Wendel Segadilha");
        funcionario.setCargo("Programador Java Jr.");
        funcionario.setSalario(new BigDecimal(2500));

        Cliente cliente1 = new Cliente();
        cliente1.setNome("Venes Lopes");
        cliente1.setRendaMensal(new BigDecimal(1200));
        cliente1.setLimiteCredito(new BigDecimal(400));
        cliente1.setBloqueado(false);

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Junior");
        cliente2.setRendaMensal(new BigDecimal(1500));
        cliente2.setLimiteCredito(new BigDecimal(300));
        cliente2.setBloqueado(true);

        manager.persist(funcionario);
        manager.persist(cliente1);
        manager.persist(cliente2);
        tx.commit();

        manager.close();
        JpaUtil.close();
    }
}
