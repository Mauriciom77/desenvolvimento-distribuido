package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pbc.jpa.exercicio4.modelo.Cliente;
import pbc.jpa.exercicio4.modelo.Endereco;

/**
 * Classe utilizada para fazer as operações de banco de dados sobre a entity
 * Cliente.
 */
public class ClienteDAO {

    /**
     * Método utilizado para obter o entity manager.
     *
     * @return
     */
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = null;
        EntityManager entityManager = null;
        try {
//Obtém o factory a partir da unidade de persistencia.
            factory = Persistence.createEntityManagerFactory("ExercicioJPA4PU");
//Cria um entity manager.
            entityManager = factory.createEntityManager();
        } finally {
            factory.close();
        }
        return entityManager;
    }

    /**
     * Método que salva ou atualiza as informações do cliente.
     *
     * @param cliente
     * @return
     * @throws java.lang.Exception
     */
    public Cliente salvar(Cliente cliente) throws Exception {
        EntityManager entityManager = getEntityManager();
        try {
// Inicia uma transação com o banco de dados.
            entityManager.getTransaction().begin();
            System.out.println("Salvando as informações do cliente.");
            /* Verifica se o cliente ainda não está salvo
             no banco de dados. */
            if (cliente.getId() == null) {
                entityManager.persist(cliente);
            } else {
                cliente = entityManager.merge(cliente);
            }
// Finaliza a transação.
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
// Retorna o cliente salvo.
        return cliente;
    }

    /**
     * Método que apaga as informações do cliente do banco de dados.
     *
     * @param id
     */
    public void apagar(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
// Inicia uma transação com o banco de dados.
            entityManager.getTransaction().begin();
// Consulta o cliente na base de dados através do seu ID.
            Cliente cliente = entityManager.find(Cliente.class, id);
            System.out.println("Excluindo o cliente: "
                    + cliente.getNome());
// Remove o cliente da base de dados.
            entityManager.remove(cliente);
// Finaliza a transação.
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    /**
     * Consulta o cliente pelo ID.
     *
     * @param id
     * @return
     */
    public Cliente consultarPorId(Long id) {
        EntityManager entityManager = getEntityManager();
        Cliente cliente = null;
        try {
//Consulta o cliente pelo ID.
            cliente = entityManager.find(Cliente.class, id);
        } finally {
            entityManager.close();
        }
//Retorna o cliente consultado.
        return cliente;
    }
}
