package dominio;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa{

    @Column(name = "salario", nullable = true)
    private BigDecimal salario;

    @Column(length = 100, nullable = true)
    private String cargo;

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
