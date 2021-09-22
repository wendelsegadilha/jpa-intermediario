import dominio.Proprietario;
import dominio.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class Consulta {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEtityManager();
        List<Veiculo> veiculos = manager.createQuery("select v from Veiculo v", Veiculo.class).getResultList();

        veiculos.stream()
                .forEach(v -> System.out.println(v.getModelo() + " - " + v.getProprietario().getNome()));

        Veiculo veiculo = manager.find(Veiculo.class, 1L);
        System.out.println(veiculo.getModelo() + " - " + veiculo.getProprietario().getNome());

        Proprietario proprietario = manager.find(Proprietario.class, 2);
        System.out.println(proprietario.getNome() + " - " +proprietario.getVeiculo().getModelo());

        manager.close();
        JpaUtil.close();


    }
}
