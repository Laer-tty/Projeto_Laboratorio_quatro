import com.model.*;

import com.repository.ProfissionalRepository;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

public class Teste {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory("lab_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        /* pesquisa
        cliente c1 = entityManager.find(c1.class, 3);
        System.out.printf(c1.getNome()); */

        /* insere
        cliente c1 = new cliente();
        c1.setNome("Mariana Lima");
        c1.setCpf("111.222.333-44");
        c1.setTelefone("989-8757-2900");
        c1.setEmail("marianalima@gmail.com");
        c1.setDataNascimento(Date.valueOf("2004-12-21"));

        entityManager.getTransaction().begin();
        entityManager.persist(c1);
        entityManager.flush();
        entityManager.getTransaction().commit();
        */

        /* remover
        cliente c1 = entityManager.find(cliente.class, 6);

        entityManager.getTransaction().begin();
        entityManager.remove(c1);
        entityManager.getTransaction().commit();
         */

        /* atualiza e insere ao mesmo tempo
        cliente c1 = new cliente();
        c1.setId(1);
        c1.setNome("Pedro Gabriel");
        c1.setCpf("123.456.789-00");
        c1.setTelefone("111-1111-1111");
        c1.setEmail("pedro.gabriel@gmail.com");
        c1.setDataNascimento(Date.valueOf("1980-01-15"));

        entityManager.getTransaction().begin();
        entityManager.merge(c1);
        entityManager.getTransaction().commit(); */

        ProfissionalRepository pr = new ProfissionalRepository();

        Profissional profissional = Profissional.builder()
                .id(6)
                .nome("Marina Silva")
                .profissao("Tecnico em TI")
                .telefone1("987654555")
                .valorHora(BigDecimal.valueOf(50.20))
                .obs("Teste")
                .build();

        pr.save(profissional);

        List<Profissional> profissionais = pr.findAll();
        for (Profissional p : profissionais) {
            System.out.println("Profissional ID: " + p.getId() + ", Nome: " + p.getNome());
        }


        entityManager.close();
        entityManagerFactory.close();
    }
}
