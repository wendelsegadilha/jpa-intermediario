import dominio.Acessorio;
import dominio.Proprietario;
import dominio.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;

public class Consulta {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEtityManager();

        Veiculo veiculo = manager.find(Veiculo.class, 1L);
        System.out.println("Veículo: " + veiculo.getModelo());

        Set<Acessorio> acessorios = veiculo.getAcessorios();
        acessorios.stream().forEach(a -> System.out.println("Acessório: " + a.getDescricao()));


        manager.close();
        JpaUtil.close();


    }
}
