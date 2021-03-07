package com.soickm.configuration;

import com.soickm.repositories.POCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
//import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import com.mongodb.MongoClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Optional;

@Configuration
@EnableMongoRepositories(basePackageClasses = POCRepository.class)
public class ApplicationConfiguration extends AbstractMongoConfiguration {

    @Autowired
    private Environment env;

    @Value("${spring.data.mongodb.db}")
    private String databaseName;

    @Value("${spring.data.mongodb.host}")
    private String mongoHost;

    @Value("${spring.data.mongodb.port}")
    private Integer mongoPort;

    private static final Logger logger = LoggerFactory.getLogger(ApplicationConfiguration.class);

    @Override
    protected String getDatabaseName() {
        Optional<String> db = Optional.of(databaseName);
        logger.info("Connecting to database " + db.get());
        return db.orElse("default");

    }

    @Override
    public MongoClient mongoClient() {
        Optional<String> host = Optional.of(mongoHost);
        Optional<Integer> port = Optional.of(mongoPort);
        logger.info("Connecting to MongoDB on "+host.get() + ":" + port.get());
        return new MongoClient(host.orElse("localhost"), port.orElse(27017));
    }
}
