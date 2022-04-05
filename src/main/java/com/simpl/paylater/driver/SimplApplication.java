package com.simpl.paylater.driver;

import com.simpl.paylater.command.ICommand;
import com.simpl.paylater.command.classifier.CommandClassifier;
import com.simpl.paylater.exception.PayLaterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.simpl.paylater"})
@EnableJpaRepositories("com.simpl.paylater.repository")
@EntityScan("com.simpl.paylater.model")
public class SimplApplication implements CommandLineRunner
{

	@Autowired
	@Qualifier("CommandClassifier")
	CommandClassifier commandCategoryFactory;

	private static final Logger logger = LoggerFactory.getLogger(SimplApplication.class);

	public static void main(String[] args) {

		System.exit(SpringApplication.exit(
				SpringApplication.run(SimplApplication.class, args))
		);
	}

	@Override
	public void run(String... args){
		Object result;
		try {

			ICommand command = commandCategoryFactory.getRequiredCommand(args);

			command.validateInput(args);

			result = command.run(args);

			logger.warn(String.format("Result  : %s", result));
		} catch (PayLaterException payLaterException) {
			result = payLaterException.getMessage();
			logger.error(String.format("Input args were not as expected , command rejected due to : %s",result));
		} catch (Exception e) {
			logger.error("Something went wrong :( ",e);
		}
	}
}
