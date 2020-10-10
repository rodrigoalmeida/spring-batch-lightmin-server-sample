package br.rodrigoalmeida.spring.batch.lightmin.sample.client.app1.jobs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class JobListConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	public JobListConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		super();
		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
	}

	@Bean
	public Job jobListBean() {
		return jobBuilderFactory.get("jobListBean")
		.start(stepListBean())
		.build();
	}
	
	@Bean
	public Step stepListBean() {
		return stepBuilderFactory.get("stepListBean")
		.<String, String>chunk(10)
		.reader(ittemReaderListBean())
		.writer(itemWriterListBean())
		.build();
	}
	
	@Bean
	public ItemReader<String> ittemReaderListBean(){
		return new ItemReader<String>() {
			List<String> items;
			int currentIndex = 0;
			
			private void loadList() {
				items = new ArrayList<>();
				for (int i = 1; i<=100; i++) {
					items.add("linha"+i);
				}				
			}

			@Override
			public String read()
					throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
				if (items == null) {
					loadList();
				}
				if (currentIndex >= items.size()) {
					return null;
				}
				String currentItem = items.get(currentIndex);
				currentIndex += 1;				
				return currentItem;
			}
		};
	}
		
		@Bean 
		public ItemWriter<String> itemWriterListBean(){
			return new ItemWriter<String>() {

				@Override
				public void write(List<? extends String> items) throws Exception {
					items.forEach(it ->{
						log.debug("{}", it);
					});
					
				}
			};
		}	

}
