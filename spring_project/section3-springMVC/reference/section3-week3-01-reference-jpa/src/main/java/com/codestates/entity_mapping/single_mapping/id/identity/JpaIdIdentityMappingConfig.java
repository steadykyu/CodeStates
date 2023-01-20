package com.codestates.entity_mapping.single_mapping.id.identity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Profile("id-identity")
@EntityScan(basePackageClasses = {JpaIdIdentityMappingConfig.class})
@Configuration
public class JpaIdIdentityMappingConfig {
    private EntityManager em;
    private EntityTransaction tx;

    @Bean
    public CommandLineRunner testJpaSingleMappingRunner(EntityManagerFactory emFactory) {
        this.em = emFactory.createEntityManager();
        this.tx = em.getTransaction();
        System.out.println("# Active Profile: id-identity");

        return args -> {
            tx.begin();
            em.persist(new Member());
            //커밋 하지 않아도 조회가 된다.
            // 이미 1차 캐시에 ID가 있다. why?..
//            Member member = em.find(Member.class, 1L);
            tx.commit();
            Member member = em.find(Member.class, 1L);

            System.out.println("# memberId: " + member.getMemberId());
        };
    }
}
