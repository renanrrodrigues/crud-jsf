package consulta.jpql;

import com.crud.domain.model.entity.aulajpql.Dominio;
import com.crud.domain.model.entity.aulajpql.Usuario;
import com.crud.dto.UsuarioDTO;
import com.crud.infrastructure.factory.ManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ConsultasAulaJPQL {

    public static void main(String[] args) {
        EntityManager entityManager = ManagerFactory.getEntityManager();


        //primeirasConsultas(entityManager);
        //escolhendoORetorno(entityManager);
        //fazendoProjecoes(entityManager);
        passandoParametros(entityManager);

        ManagerFactory.emClose(); // fechando o Entity Manager (gerenciador de entidades)
        ManagerFactory.emfClose(); // fechando o Entity Manager Factory (fábrica de Entity Manager)
    }

    public static void passandoParametros(EntityManager entityManager) {

        String jpql = "select u from Usuario u where u.id = :idUsuario";
        /*
        podemos usar o setParameter ou passar o parâmetro direto na query
        TypedQuery<Usuario> typedQuery = entityManager.createQuery(jpql, Usuario.class);
        typedQuery.setParameter("idUsuario", 1); // passando o parâmetro (parecido com o PreparedStatement)
        */
        TypedQuery<Usuario> typedQuery = entityManager.
                createQuery(jpql, Usuario.class).
                setParameter("idUsuario", 1); // passando o parâmetro (parecido com o PreparedStatement)
        Usuario usuario = typedQuery.getSingleResult();
        System.out.println(usuario.getId() + ", " + usuario.getNome());



        String jpqlLog = "select u from Usuario u where u.login = :loginUsuario";
        TypedQuery<Usuario> typedQueryLog = entityManager.
                createQuery(jpqlLog, Usuario.class).
                setParameter("loginUsuario", "ria"); // passando o parâmetro (parecido com o PreparedStatement)
        Usuario usuarioLog = typedQueryLog.getSingleResult();
        System.out.println(usuarioLog.getId() + ", " + usuarioLog.getNome());

    }

    public static void fazendoProjecoes(EntityManager entityManager) {

        String jpqlArr = "select id, login, nome from Usuario"; // poderíamos usar alis também.
        TypedQuery<Object[]> typedQueryArr = entityManager.createQuery(jpqlArr, Object[].class);
        List<Object[]> listaArr = typedQueryArr.getResultList();
        listaArr.forEach(arr -> System.out.println(String.format("%s, %s, %s", arr)));


        String jpqlDto = "select new com.crud.dto.UsuarioDTO(" +
                "id, " +
                "login, " +
                "nome)" +
                "from Usuario";

        TypedQuery<UsuarioDTO> typedQueryDto = entityManager.createQuery(jpqlDto, UsuarioDTO.class);
        List<UsuarioDTO> listaDto = typedQueryDto.getResultList();

        listaDto.forEach(u -> System.out.println("DTO: " + u.getId() + ", " + u.getNome()));

    }

    public static void escolhendoORetorno(EntityManager entityManager) {

        // selecionando um atributo da entidade nesse caso o nome do usuario
        String jpqlNom = "select u.nome from Usuario u";
        TypedQuery<String> typedQueryNom = entityManager.createQuery(jpqlNom, String.class);
        List<String> listaNom = typedQueryNom.getResultList();
        listaNom.forEach(nome -> System.out.println(nome));


        // selecionando um atributo da entidade nesse caso Dominio(outra entidade) da entidade usuario
        String jpql = "select u.dominio from Usuario u where u.id = 1"; // JPQL (Java Persistence Query Language)
        //TypedQuery<RetornoQueQueremos> typedQuery = entityManager.createQuery(nossaQuery, RetornoQueQueremos.class);
        TypedQuery<Dominio> typedQuery = entityManager.createQuery(jpql, Dominio.class);
        Dominio dominio = typedQuery.getSingleResult();
        System.out.println(dominio.getId() + ", " + dominio.getNome());


    }

    public static void primeirasConsultas(EntityManager entityManager) {

        // select retornoQueQueremos from Entidade entidade // usamos alias para a entidade
        String jpql = "select u from Usuario u"; // JPQL (Java Persistence Query Language)
        //TypedQuery<RetornoQueQueremos> typedQuery = entityManager.createQuery(nossaQuery, RetornoQueQueremos.class);
        TypedQuery<Usuario> typedQuery = entityManager.createQuery(jpql, Usuario.class);
        List<Usuario> lista = typedQuery.getResultList();
        lista.forEach(u -> System.out.println(u.getId() + ", " + u.getNome()));


        String jpqlSing = "select u from Usuario u where u.id = 1";
        TypedQuery<Usuario> typedquerySing = entityManager.createQuery(jpqlSing, Usuario.class);
        Usuario usuario = typedquerySing.getSingleResult();
        System.out.println(usuario.getId()+", "+usuario.getNome());


        String jpqlQueryCast = "select u from Usuario u where u.id = 2";
        Query query  = entityManager.createQuery(jpqlQueryCast);
        Usuario usuario2 = (Usuario) query.getSingleResult();
        System.out.println(usuario2.getId()+", "+usuario2.getNome());

    }
}
