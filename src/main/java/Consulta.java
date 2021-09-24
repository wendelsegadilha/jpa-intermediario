import dominio.Acessorio;
import dominio.Proprietario;
import dominio.Telefone;
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

        List<Telefone> telefones = proprietario.getTelefones();

        telefones.stream().forEach(t ->
                System.out.println(
                        "Telefone: (" + t.getPrefixo() + ")"
                        + t.getNumero()
                        +(t.getRamal() != null ? " x" + t.getRamal() : "")
                ));

        manager.close();
        JpaUtil.close();


    }
}
