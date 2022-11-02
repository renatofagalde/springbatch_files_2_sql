package br.com.likwi.springbatchfiles2sql.batch.writer;

import br.com.likwi.springbatchfiles2sql.batch.dominio.Pessoa;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class JdbcPessoaWriter {

    @Bean
    public JdbcBatchItemWriter<Pessoa> pessoaWriter(@Qualifier("appDataSource")DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Pessoa>()
                .dataSource(dataSource)
                .sql("insert into pessoa (id,nome,email,data_nascimento,idade) values (?,?,?,?)")
                .itemPreparedStatementSetter(itemPreparedStatementSetter())
                .build();
    }

    private ItemPreparedStatementSetter<Pessoa> itemPreparedStatementSetter() {
        return new ItemPreparedStatementSetter<Pessoa>() {
            @Override
            public void setValues(Pessoa pessoa, PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1,pessoa.getId());
                preparedStatement.setString(2,pessoa.getNome());
                preparedStatement.setString(3,pessoa.getEmail());
                preparedStatement.setDate(4,new Date(pessoa.getNascimento().getTime()));
                preparedStatement.setInt(5,pessoa.getIdade());

            }
        };
    }
}
