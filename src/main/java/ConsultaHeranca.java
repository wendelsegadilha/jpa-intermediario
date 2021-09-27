import dominio.*;
import util.JpaUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ConsultaHeranca {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEtityManager();

        //Consulta clientes
        List<Cliente> clientes = manager.createQuery("select c from Cliente c", Cliente.class).getResultList();

        //Consulta funcionarios
        List<Funcionario> funcionarios = manager.createQuery("select f from Funcionario f", Funcionario.class).getResultList();

        //Consulta polimórfica
        List<Pessoa> pessoas = manager.createQuery("select p from Pessoa p", Pessoa.class).getResultList();
        for (Pessoa p : pessoas) {
            System.out.print(p.getNome());
            if (p instanceof Cliente) {
                System.out.println(" - é um cliente.");
            } else {
                System.out.println(" - é um funcionário.");
            }
        }



        manager.close();
        JpaUtil.close();


    }
}
