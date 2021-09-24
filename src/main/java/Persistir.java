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
        proprietario.setTelefone("(98)98600-4587");
        manager.persist(proprietario);

        Veiculo veiculo = new Veiculo();
        veiculo.setModelo("Celta");
        veiculo.setFabricante("Chevrollet");
        veiculo.setAnoFabricacao(2019);
        veiculo.setAnoModelo(2019);
        veiculo.setValor(new BigDecimal(20_000));
        veiculo.setTipoCombustivel(TipoCombustivel.GASOLINA);
        veiculo.setDataCadastro(LocalDate.now());
        veiculo.setProprietario(proprietario);
        manager.persist(veiculo);

        Veiculo veiculo2 = new Veiculo();
        veiculo2.setModelo("Gol");
        veiculo2.setFabricante("VW");
        veiculo2.setAnoFabricacao(2020);
        veiculo2.setAnoModelo(2020);
        veiculo2.setValor(new BigDecimal(25_000));
        veiculo2.setTipoCombustivel(TipoCombustivel.GASOLINA);
        veiculo2.setDataCadastro(LocalDate.now());
        veiculo2.setProprietario(proprietario);
        manager.persist(veiculo2);

        tx.commit();

        manager.close();
        JpaUtil.close();
    }
}