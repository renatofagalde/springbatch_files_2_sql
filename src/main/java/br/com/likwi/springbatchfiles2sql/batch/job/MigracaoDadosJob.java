package br.com.likwi.springbatchfiles2sql.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class MigracaoDadosJob {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job migracaoDadosJob(
			@Qualifier("migrarPessoaStep") Step migracaoPessoasStep,
			@Qualifier("migrarDadosBancariosStep") Step migracaoDadosBancariosStep) {
		return jobBuilderFactory
				.get("migracaoDadosJob")
				.start(migracaoPessoasStep)
				.next(migracaoDadosBancariosStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}
