import dominio.Proprietario;
import dominio.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class Consulta {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEtityManager();

        Proprietario proprietario = manager.find(Proprietario.class, 1);
        System.out.println("Proprietario: " + proprietario.getNome());

        List<Veiculo> veiculos = proprietario.getVeiculos();
        veiculos.stream().forEach(v -> System.out.println("Veículo: " + v.getModelo()));


        manager.close();
        JpaUtil.close();


    }
}
