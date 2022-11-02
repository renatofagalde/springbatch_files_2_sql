package br.com.likwi.springbatchfiles2sql.batch.reader;


import br.com.likwi.springbatchfiles2sql.batch.dominio.Pessoa;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import java.util.Date;

@Component
public class ArquivoPessoaReader {

    @StepScope
    @Bean
    public FlatFileItemReader<Pessoa> arquivoPessoaReader() {
        return new FlatFileItemReaderBuilder<Pessoa>()
                .name("arquivoPessoaReader")
                .resource(new FileSystemResource("arquivos/pessoa.csv"))
                .delimited()
                .names("name", "email", "dataNascimento", "idade", "id")
                .fieldSetMapper(mapearCampos())
                .addComment("--")
                .build();
    }

    private FieldSetMapper<Pessoa> mapearCampos() {
        return new FieldSetMapper<Pessoa>() {
            @Override
            public Pessoa mapFieldSet(FieldSet fieldSet) throws BindException {
                return new Pessoa(
                        fieldSet.readInt("id"),
                        fieldSet.readString("nome"),
                        fieldSet.readString("email"),
                        new Date(fieldSet.readDate("dataNascimento", "yyyy-dd-mm HH:mm:ss").getTime()),
                        fieldSet.readInt("idade")
                );
            }
        };
    }
}
