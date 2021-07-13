package com.openwt.suisse.dao;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@EntityScan("com.openwt.suisse.dao.model")
@EnableJpaRepositories("com.openwt.suisse.dao.repository")
@ComponentScan("com.openwt.suisse.dao.repository")
public class TestRepositoryConfig {

}