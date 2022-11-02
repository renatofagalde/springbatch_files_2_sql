package br.com.likwi.springbatchfiles2sql.batch.step;

import br.com.likwi.springbatchfiles2sql.batch.dominio.DadosBancarios;
import br.com.likwi.springbatchfiles2sql.batch.dominio.Pessoa;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@EnableBatchProcessing
public class MigrarDadosBancariosStepConfig {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step migrarDadosBancariosStep(ItemReader<DadosBancarios> arquivoDadosBancariosReader,
                                 ItemWriter<DadosBancarios> bancoDadosBancariosWriter) {

        return stepBuilderFactory
                .get("migrarDadosBancariosStep")
                .<DadosBancarios, DadosBancarios>chunk(1)
                .reader(arquivoDadosBancariosReader)
                .writer(bancoDadosBancariosWriter)
                .build();

    }
}
