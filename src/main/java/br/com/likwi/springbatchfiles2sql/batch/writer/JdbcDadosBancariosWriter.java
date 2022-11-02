package br.com.likwi.springbatchfiles2sql.batch.writer;

import br.com.likwi.springbatchfiles2sql.batch.dominio.DadosBancarios;
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
public class JdbcDadosBancariosWriter {

    @Bean
    public JdbcBatchItemWriter<DadosBancarios> dadosBancariosWriter(@Qualifier("appDataSource")DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<DadosBancarios>()
                .dataSource(dataSource)
                .sql("insert into dados_bancarios (id,pessoa_id,agencia,conta,banco) values (:id,:pessoaId,:agencia,:conta,:banco)")
                .beanMapped()
                .build();
    }
}
