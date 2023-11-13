package consulta.jpql;
import com.crud.domain.model.entity.aulajpql.Configuracao;
import com.crud.domain.model.entity.aulajpql.Dominio;
import com.crud.domain.model.entity.aulajpql.Usuario;
import com.crud.dto.UsuarioDTO;
import com.crud.infrastructure.factory.ManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConsultasAulaJOIN {
    public static void main(String[] args) {
        EntityManager entityManager = ManagerFactory.getEntityManager();

        //primeirasConsultas(entityManager);
        //escolhendoORetorno(entityManager);
        //fazendoProjecoes(entityManager);
        //passandoParametros(entityManager);


        //fazendoJoins(entityManager);
        //fazendoLeftJoin(entityManager);
        //carregamentoComJoinFetch(entityManager);
        //filtrandoRegistros(entityManager);
        //utilizandoOperadoresLogicos(entityManager);
        //utilizandoOperadorIn(entityManager);
        //ordenandoResultados(entityManager);
        paginandoResultados(entityManager);

        ManagerFactory.emClose(); // fechando o Entity Manager (gerenciador de entidades)
        ManagerFactory.emfClose(); // fechando o Entity Manager Factory (fábrica de Entity Manager)
    }

    public static void paginandoResultados(EntityManager entityManager) {
        // setFirstResult, setMaxResults
        // setFirstResult -> define a partir de qual registro será feito a consulta
        // setMaxResults -> define a quantidade de registros que serão retornados


        String jpql = "select u from Usuario u";
        TypedQuery<Usuario> typedQuery = entityManager.createQuery(jpql, Usuario.class)
                .setFirstResult(0) // a partir do registro 0 a pagina 1, pagina 2 seria 10, pagina 3 seria 20....
                .setMaxResults(10); // 10 registros por página
        List<Usuario> lista = typedQuery.getResultList();
        lista.forEach(u -> System.out.println(u.getId() + ", " + u.getNome()));
    }


    public static void ordenandoResultados(EntityManager entityManager) {
        // ORDER BY ASC, ORDER BY DESC
        // ORDER BY = select u from Usuario u order by u.nome
        // ORDER BY = select u from Usuario u order by u.nome asc
        // ORDER BY = select u from Usuario u order by u.nome desc
        // ORDER BY = select u from Usuario u order by u.nome asc, u.login desc

        String jpql = "select u from Usuario u order by u.nome";
        TypedQuery<Usuario> typedQuery = entityManager.createQuery(jpql, Usuario.class);
        List<Usuario> lista = typedQuery.getResultList();
        lista.forEach(u -> System.out.println(u.getId() + ", " + u.getNome()));

        String jpqlAsc = "select u from Usuario u order by u.nome asc";
        TypedQuery<Usuario> typedQueryAsc = entityManager.createQuery(jpqlAsc, Usuario.class);
        List<Usuario> listaAsc = typedQueryAsc.getResultList();

        String jpqlDesc = "select u from Usuario u order by u.nome desc";
        TypedQuery<Usuario> typedQueryDesc = entityManager.createQuery(jpqlDesc, Usuario.class);
        List<Usuario> listaDesc = typedQueryDesc.getResultList();
    }

    public static void utilizandoOperadorIn(EntityManager entityManager) {
        // IN
        // IN = select u from Usuario u where u.id in (1,2)
        // IN = select u from Usuario u where u.id in (:ids)
        // IN = select u from Usuario u where u.id in :ids


        String jpql = "select u from Usuario u where u.id in (:ids)";
        TypedQuery<Usuario> typedQuery = entityManager.createQuery(jpql, Usuario.class)
                .setParameter("ids", Arrays.asList(1,2));
        List<Usuario> lista = typedQuery.getResultList();
        lista.forEach(u -> System.out.println(u.getId() + ", " + u.getNome()));


        // passando uma lista de objetos
        Usuario usuario1 = new Usuario();
        usuario1.setId(1);
        Usuario usuario2 = new Usuario();
        usuario2.setId(2);
        Usuario usuario3 = new Usuario();
        usuario3.setId(3);
        List<Usuario> listaDeUsuarios = Arrays.asList(usuario1, usuario2, usuario3);

        // Crie a lista de IDs a partir dos objetos Usuario
        List<Integer> listaDeIds = listaDeUsuarios.stream()
                .map(Usuario::getId)
                .collect(Collectors.toList());

        String jpql2 = "select u from Usuario u where u.id in :ids";
        TypedQuery<Usuario> typedQuery2 = entityManager.createQuery(jpql2, Usuario.class)
                .setParameter("ids", listaDeIds);
        List<Usuario> lista2 = typedQuery2.getResultList();
        lista2.forEach(u -> System.out.println(u.getId() + ", " + u.getNome()));

    }

    public static void utilizandoOperadoresLogicos(EntityManager entityManager) {
        // AND, OR, NOT
        // AND = select u from Usuario u where u.login = 'ria' and u.senha = '123'
        // OR = select u from Usuario u where u.login = 'ria' or u.senha = '123'
        // NOT = select u from Usuario u where not u.login = 'ria'


        String jpql = "select u from Usuario u where " +
                " (u.ultimoAcesso > :ontem and u.ultimoAcesso < :hoje) " +
                " or u.ultimoAcesso is null";
        TypedQuery<Usuario> typedQuery = entityManager.createQuery(jpql, Usuario.class)
                .setParameter("ontem", LocalDateTime.now().minusDays(1))
                .setParameter("hoje", LocalDateTime.now());
        List<Usuario> lista = typedQuery.getResultList();
        lista.forEach(u -> System.out.println(u.getId() + ", " + u.getNome()));
    }

    public static void filtrandoRegistros(EntityManager entityManager) {
        // LIKE, IS NULL, IS EMPTY, BETWEEN, >, <, >=, <=, =, <>
        // LIKE = select u from Usuario u where u.nome like concat(:nomeUsuario, '%')
        // IS NULL = select u from Usuario u where u.senha is null
        // IS EMPTY = select d from Dominio d where d.usuarios is empty
        // BETWEEN = select u from Usuario u where u.ultimoAcesso between :ontem and :hoje

        String jpql = "select u from Usuario u where u.ultimoAcesso between :ontem and :hoje";
        TypedQuery<Usuario> typedQuery = entityManager.createQuery(jpql, Usuario.class)
                .setParameter("ontem", LocalDateTime.now().minusDays(1))
                .setParameter("hoje", LocalDateTime.now());
        List<Usuario> lista = typedQuery.getResultList();
        lista.forEach(u -> System.out.println(u.getId() + ", " + u.getNome()));
    }

    public static void carregamentoComJoinFetch(EntityManager entityManager) {
        // JOIN FETCH
        // JOIN FETCH = select u from Usuario u join fetch u.configuracao join fetch u.dominio d
        // JOIN FETCH = select u from Usuario u join fetch u.configuracao join fetch u.dominio d where d.id = 1
        // JOIN FETCH = select u from Usuario u join fetch u.configuracao join fetch u.dominio d where d.id = 1

        // String jpql = "select u from Usuario u"; // faz muitas consultas no banco
        String jpql = "select u from Usuario u join fetch u.configuracao join fetch u.dominio d";
        TypedQuery<Usuario> typedQuery = entityManager.createQuery(jpql, Usuario.class);
        List<Usuario> lista = typedQuery.getResultList();
        lista.forEach(u -> System.out.println(u.getId() + ", " + u.getNome()));

    }

    public static void fazendoLeftJoin(EntityManager entityManager) {
        // LEFT JOIN
        // LEFT JOIN = select u, c from Usuario u left join u.configuracao c
        // LEFT JOIN = select u, c from Usuario u left join u.configuracao c where c.ativo = true
        // LEFT JOIN = select u, c from Usuario u left join u.configuracao c where c.ativo = true and u.id = 1
        // LEFT JOIN = select u, c from Usuario u left join u.configuracao c on c.ativo = true where u.id = 1

        String jpql = "select u, c from Usuario u left join u.configuracao c";
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> lista = typedQuery.getResultList();

        // arr[0] = usuario
        // arr[1] = configuracao
        lista.forEach(arr -> {
            String out = ((Usuario) arr[0]).getNome();
            if (arr[1] == null) {
                out += ", NULL";
            } else {
                out += ", " + ((Configuracao) arr[1]).getId();
            }

            System.out.println(out);
        });
    }

    public static void fazendoJoins(EntityManager entityManager) {
        // JOIN
        // JOIN = select u from Usuario u join u.dominio d
        // JOIN = select u from Usuario u join u.dominio d where d.id = 1

        String jpql = "select u from Usuario u join u.dominio d where d.id = 1"; // alis u = usuario, d = dominio
        TypedQuery<Usuario> typedQuery = entityManager.createQuery(jpql, Usuario.class);
        List<Usuario> lista = typedQuery.getResultList();
        lista.forEach(u -> System.out.println(u.getId() + ", " + u.getNome()));

        String jpqlJoinExplicito = "select u from Usuario u join Dominio d on u.dominio = d where d.id = 1";
        TypedQuery<Usuario> typedQueryJoinExplicito  = entityManager.createQuery(jpqlJoinExplicito, Usuario.class);
        List<Usuario> listaJoinExplicito  = typedQueryJoinExplicito .getResultList();
        listaJoinExplicito .forEach(u -> System.out.println(u.getId() + ", " + u.getNome()));

        String jpqlFETCH = "select u from Usuario u join fetch u.dominio d where d.id = 1";
        TypedQuery<Usuario> typedQueryFETCH = entityManager.createQuery(jpqlFETCH, Usuario.class);
        List<Usuario> listaFETCH = typedQueryFETCH.getResultList();
        listaFETCH.forEach(u -> System.out.println(u.getId() + ", " + u.getNome()));

        String jpqlAliasExplicito = "select u from Usuario u join u.dominio as d where d.id = 1";
        TypedQuery<Usuario> typedQueryAliasExplicito = entityManager.createQuery(jpqlAliasExplicito, Usuario.class);
        List<Usuario> listaAliasExplicito = typedQueryAliasExplicito.getResultList();
        listaAliasExplicito.forEach(u -> System.out.println(u.getId() + ", " + u.getNome()));

    }

    public static void passandoParametros(EntityManager entityManager) {
        String jpql = "select u from Usuario u where u.id = :idUsuario";
        TypedQuery<Usuario> typedQuery = entityManager.
                createQuery(jpql, Usuario.class).
                setParameter("idUsuario", 1);
        Usuario usuario = typedQuery.getSingleResult();
        System.out.println(usuario.getId() + ", " + usuario.getNome());


        String jpqlLog = "select u from Usuario u where u.login = :loginUsuario";
        TypedQuery<Usuario> typedQueryLog = entityManager.
                createQuery(jpqlLog, Usuario.class).
                setParameter("loginUsuario", "ria");
        Usuario usuarioLog = typedQueryLog.getSingleResult();
        System.out.println(usuarioLog.getId() + ", " + usuarioLog.getNome());
    }

    public static void fazendoProjecoes(EntityManager entityManager) {
        String jpqlArr = "select id, login, nome from Usuario";
        TypedQuery<Object[]> typedQueryArr = entityManager.createQuery(jpqlArr, Object[].class);
        List<Object[]> listaArr = typedQueryArr.getResultList();
        listaArr.forEach(arr -> System.out.println(String.format("%s, %s, %s", arr)));


        String jpqlDto = "select new com.crud.dto.UsuarioDTO(id, login, nome)" +
                "from Usuario";
        TypedQuery<UsuarioDTO> typedQueryDto = entityManager.createQuery(jpqlDto, UsuarioDTO.class);
        List<UsuarioDTO> listaDto = typedQueryDto.getResultList();
        listaDto.forEach(u -> System.out.println("DTO: " + u.getId() + ", " + u.getNome()));
    }

    public static void escolhendoORetorno(EntityManager entityManager) {
        String jpql = "select u.dominio from Usuario u where u.id = 1";
        TypedQuery<Dominio> typedQuery = entityManager.createQuery(jpql, Dominio.class);
        Dominio dominio = typedQuery.getSingleResult();
        System.out.println(dominio.getId() + ", " + dominio.getNome());

        String jpqlNom = "select u.nome from Usuario u";
        TypedQuery<String> typedQueryNom = entityManager.createQuery(jpqlNom, String.class);
        List<String> listaNom = typedQueryNom.getResultList();
        listaNom.forEach(nome -> System.out.println(nome));
    }

    public static void primeirasConsultas(EntityManager entityManager) {
        String jpql = "select u from Usuario u";
        TypedQuery<Usuario> typedQuery = entityManager.createQuery(jpql, Usuario.class);
        List<Usuario> lista = typedQuery.getResultList();
        lista.forEach(u -> System.out.println(u.getId() + ", " + u.getNome()));

        String jpqlSing = "select u from Usuario u where u.id = 1";
        TypedQuery<Usuario> typedQuerySing = entityManager.createQuery(jpqlSing, Usuario.class);
        Usuario usuario = typedQuerySing.getSingleResult();
        System.out.println(usuario.getId() + ", " + usuario.getNome());

        String jpqlCast = "select u from Usuario u where u.id = 1";
        Query query = entityManager.createQuery(jpqlCast);
        Usuario usuario2 = (Usuario) query.getSingleResult();
        System.out.println(usuario2.getId() + ", " + usuario2.getNome());
    }
}
