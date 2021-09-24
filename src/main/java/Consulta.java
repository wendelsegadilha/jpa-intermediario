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
        Proprietario proprietario = manager.find(Proprietario.class, 1);
        System.out.println("Proprietario: " + proprietario.getNome());

        List<String> telefones = proprietario.getTelefones();
        telefones.forEach(t -> System.out.println(t));
        
        manager.close();
        JpaUtil.close();


    }
}
