# **    Atividade 1 - Trabalhando com Java Reflection ** 📖

Este projeto é a primeira parte de trabalhos da disciplina de LP3

---

### **Como Rodar o Projeto** 🚀

Para executar a aplicação localmente, siga estes passos:

1.  **Pré-requisitos**:
    * **Java 21** ou superior
    * Uma IDE como **IntelliJ IDEA** ou **Eclipse**.

2.  **Clone o repositório**:
    ```bash
    git clone https://github.com/kenedygondim/Java-Reflections.git
    cd trabalho-java-reflection
    ```

3.  **Execute a aplicação**:
    * Abra o projeto na sua IDE.
    * Localize a classe principal com a anotação `@SpringBootApplication`(FilmeApplication).
    * Execute o método `main()` dessa classe. A aplicação será iniciada na porta `8080`.

4.  **Acesse o console do H2**:
    * Abra o navegador e acesse: `http://localhost:8080/h2-console`
    * Utilize as seguintes credenciais para conectar:
        * **JDBC URL**: `jdbc:h2:mem:trabalho-java-reflection`
        * **User Name**: `sa`
        * **Password**: `sa123`
    * Você verá as tabelas e dados criados automaticamente pelo Spring.

---

### **Dependências e Suas Funções** 🛠️

As dependências listadas no arquivo `pom.xml` são essenciais para o funcionamento do projeto.

* `spring-boot-starter-web`:
  **O que é**: O "motor" da sua aplicação web. Ele traz tudo o que é necessário para construir uma aplicação web, incluindo o **Tomcat** e o **Spring MVC**.
  **Motivo**: Permite que a aplicação funcione como um servidor web, capaz de receber requisições HTTP e criar APIs REST.
  **Observação**: A biblioteca **Jackson** foi removida por padrão (`<exclusion>`) para ser incluída e configurada de forma manual e personalizada.

* `spring-boot-starter-data-jpa`:
  **O que é**: Permite o uso do **JPA (Java Persistence API)** e do **Hibernate** para mapeamento objeto-relacional (ORM).
  **Motivo**: Facilita a interação com o banco de dados. Você pode trabalhar com objetos Java (`@Entity`) em vez de escrever comandos SQL complexos.

* `spring-boot-starter-data-jdbc`:
  **O que é**: Uma dependência que oferece o **`JdbcTemplate`** para acesso direto ao banco de dados usando JDBC.
  **Motivo**: Útil para cenários onde o JPA não é a melhor opção, permitindo a execução de queries SQL customizadas de forma simples e segura.

* `h2`:
  **O que é**: Um banco de dados em memória.
  **Motivo**: Ideal para desenvolvimento e testes, pois é leve, rápido e não requer instalação. Seus dados são perdidos ao reiniciar a aplicação.

* `lombok`:
  **O que é**: Uma biblioteca que gera automaticamente código boilerplate (como getters, setters, construtores, etc.) em tempo de compilação usando anotações.
  **Motivo**: Reduz a quantidade de código repetitivo, tornando o código mais limpo e conciso.

* `spring-boot-starter-test`:
  **O que é**: Oferece tudo o que é necessário para testes de unidade e integração.
  **Motivo**: Essencial para garantir a qualidade e o bom funcionamento da aplicação.

---

### **Configurações Importantes** ⚙️

As configurações no arquivo `application.properties` são cruciais para o comportamento da aplicação.

* `spring.h2.console.enabled=true`: Habilita a interface web do console do H2 para que você possa inspecionar o banco de dados.
* `spring.jpa.hibernate.ddl-auto=update`: Instrui o Hibernate a atualizar automaticamente o esquema do banco de dados (tabelas, colunas, etc.) com base nas classes de entidade.
* `spring.sql.init.mode=always`: Garante que os scripts SQL de inicialização (`schema.sql` e `data.sql`) sejam executados toda vez que a aplicação iniciar.
* `spring.jpa.defer-datasource-initialization=true`: Atrasará a execução dos scripts de inicialização até que o Hibernate finalize a criação do esquema do banco de dados, evitando conflitos de acesso.
* `spring.autoconfigure.exclude=...JacksonAutoConfiguration`: Desabilita o Jackson por padrão, permitindo a configuração manual do **`ObjectMapper`**.