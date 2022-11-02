package br.com.likwi.springbatchfiles2sql.batch.reader;


import br.com.likwi.springbatchfiles2sql.batch.dominio.DadosBancarios;
import br.com.likwi.springbatchfiles2sql.batch.dominio.DadosBancarios;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import java.util.Date;

@Component
public class ArquivoDadoBancarioReader {

    @StepScope
    @Bean
    public FlatFileItemReader<DadosBancarios> dadosBancarioReader() {
        return new FlatFileItemReaderBuilder<DadosBancarios>()
                .name("arquivoDadosBancariosReader")
                .resource(new FileSystemResource("arquivos/dados_bancarios.csv"))
                .delimited()
                .names("dadosBancariosId", "agencia", "conta", "banco", "id")
                .targetType(DadosBancarios.class)
                .addComment("--")
                .build();
    }
}
