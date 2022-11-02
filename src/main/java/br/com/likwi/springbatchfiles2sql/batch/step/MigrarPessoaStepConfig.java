package br.com.likwi.springbatchfiles2sql.batch.step;

import br.com.likwi.springbatchfiles2sql.batch.dominio.Pessoa;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@EnableBatchProcessing
@Component
public class MigrarPessoaStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step migrarPessoaStep(ItemReader<Pessoa> arquivoPessoaReader,
                                 ItemWriter<Pessoa> bancoPessoaWriter) {

        return stepBuilderFactory
                .get("migrarPessoaStep")
                .<Pessoa, Pessoa>chunk(1)
                .reader(arquivoPessoaReader)
                .writer(bancoPessoaWriter)
                .build();

    }
}
