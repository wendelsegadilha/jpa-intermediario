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
        proprietario.setNome("Venes Lopes");
        proprietario.setEmail("venes.lopes@gmail.com");
        proprietario.setTelefone("(98)98600-4587");

        manager.persist(proprietario);

        Veiculo veiculo = new Veiculo();
        veiculo.setModelo("Corola");
        veiculo.setFabricante("Toyota");
        veiculo.setAnoFabricacao(2022);
        veiculo.setAnoModelo(2022);
        veiculo.setValor(new BigDecimal(160_000));
        veiculo.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
        veiculo.setDataCadastro(LocalDate.now());
        veiculo.setProprietario(proprietario);

        manager.persist(veiculo);
        tx.commit();

        manager.close();
        JpaUtil.close();
    }
}
